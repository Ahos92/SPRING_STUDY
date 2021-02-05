package com.kgitbank.dbconfig;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kgitbank.mapper.EmployeeMapper;
import com.kgitbank.mapper.PracticeMapper;
import com.kgitbank.model.ChangeSalaryDTO;
import com.kgitbank.model.Employee;
import com.kgitbank.service.PageService;

import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class JdbcTests {

	@Autowired
	private DataSource ds;
	@Autowired
	private SqlSessionFactory sqlsf;
	@Autowired
	private EmployeeMapper emp_mapper;
	@Autowired
	private PracticeMapper prac_mapper;
	@Autowired
	private Employee employee;
	
	@Autowired
	PageService page_service;
	
	@Before
	@Ignore
	public void loadDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			log.info("driver found");
			
		} catch (ClassNotFoundException e) {
			log.error("drvier not found");
		}
	}
	
	
	@Test
	@Ignore
	public void test() {
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String user = "hr";
		String password = "hr";
				
		try (Connection conn = DriverManager.getConnection(url, user, password)){
			log.info("Connection 잘 가져옴 : " + conn);
			
		} catch (SQLException e) {
			log.error("Connection 못 가져옴 : " + e.getMessage());
		}
	}
	
	@Test
	@Ignore
	public void testHikari() throws SQLException { 
		com.zaxxer.hikari.HikariConfig config = new com.zaxxer.hikari.HikariConfig();
		config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/XEPDB1");
		config.setUsername("hr");
		config.setPassword("hr");
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		
		com.zaxxer.hikari.HikariDataSource ds = new com.zaxxer.hikari.HikariDataSource(config);
		
		java.sql.Connection conn = ds.getConnection();
		
		assertNotNull(config);
		log.info(config);
		
		assertNotNull(ds);
		log.info(ds);
		
		assertNotNull(conn);
		log.info(conn);
	}
	
	@Test
	@Ignore
	public void testDataSourceDi() {
		assertNotNull(ds);
		
		// HikariCP : getConnection()까지의 과정을 편하게 만들어줌 (직접 커네셕풀을 구현할 필요가 없어짐)
		// Mybatis : prepareStatment, execute, ResultSet을 사용하는 과정을 간편하게 만들어줌 - SqlSessionFactory
		try (Connection conn = ds.getConnection()) {
			
			ResultSet rs = conn.prepareStatement("select * from employees").executeQuery();
			
			while (rs.next()) {
				String print = String.format("%-12s / %d", rs.getString("first_name"), rs.getInt("salary"));
				log.info(print);
			}
			
		} catch (SQLException e) {
			fail(e.getMessage());
		}
		log.info(ds);
	}
	
	
	@Test
	@Ignore
	public void testSqlSessionFactory() {
		
		try (SqlSession session = sqlsf.openSession()) {
			// selectOne 방법
			log.info(session.selectOne("com.kgitbank.mapper.EmployeeMapper.getEmployeeById", 119));
			
			for (Object person : session.selectList("com.kgitbank.mapper.EmployeeMapper.getEmployeeList")) {
				log.info(person);
			}
		} 

	}
	
	@Test
	@Ignore
	public void testEmpMapper() {
		// spring-mybatis가 mapper를 자동 주입하기 위해 알아서 sqlSessionFactory로 부터 sqlSession을 꺼내서 사용한다.
		log.info("emp_mapper.get~~ : " + emp_mapper.getEmployeeById(119));
		
		for (Object person : emp_mapper.getEmployeeList()) {
			log.info(person);
		}
		
		// 하나의 row는 하나의 Map타입 또는 VO타입으로 변환하여 받을 수 있다.
		// 여러개의 row는 Map타입 또는 VO타입의 리스트로 변환하여 받을 수 있다.
		// INSERT, UPDATE, DELETE의 경우에는 반환값을 int로 받을 수 있다.
		log.info(emp_mapper.getEmployeeMap());
		
	}
	
	
	// 연습 : employees테이블을 복사하여 employees2 테이블을 생성한 후 mybatis를 이용해 CRUD를 실습해보세요
	@Test
	@Ignore
	public void testSave() {
		employee.setEmployee_id(777);
		employee.setFirst_name("babo");
		employee.setLast_name("Wang");
		employee.setEmail("stupid");
		employee.setPhone_number("010.1234.1234");
		employee.setHire_date(new Date());
		employee.setJob_id("IT_PROG");
		employee.setSalary(50000);
		employee.setCommission_pct(0.9);
		employee.setManager_id(100);
		employee.setDepartment_id(90);
		
		int save_result = prac_mapper.saveEmployee(employee);
		assertEquals(1, save_result);
		log.info("신입사원 " + save_result + "명 입사!");
	}
	
	@Test
	@Ignore
	public void testDelete() {
		int fire_id = 107; 
		int delete_result = prac_mapper.deleteEmployeeById(fire_id);
		assertEquals(1, delete_result);
		log.info(fire_id + "번 사원 " + delete_result + "명 해고");
	}
	
	@Test
	@Ignore
	public void testSelect() {
		log.info(prac_mapper.getNameBySalary(7700)); // 월급 7700이상 사원
	}
	
	
	@Test
	@Ignore
	public void testUpdate() {	
		int rise_result = prac_mapper.changeSalary(777, 2500.0);
		assertEquals(1, rise_result);
		log.info(rise_result + "행이 변경");
	}
	
	@Test
	@Ignore
	public void testUpdate2() {	
		ChangeSalaryDTO dto = new ChangeSalaryDTO();
		
		dto.setEmployee_id(777);
		dto.setIncrement(-500.0);
		
		int rise_result = prac_mapper.changeSalary2(dto);
		assertEquals(1, rise_result);
		log.info(rise_result + "행이 변경");
	}
	
	@Test
	@Ignore
	public void testUpdate2_2() {	
		ChangeSalaryDTO dto = new ChangeSalaryDTO();
		
		dto.setJob_id("ST_CLERK");
		dto.setIncrement(500.0);
		
		int rise_result = prac_mapper.changeSalary2(dto);
		
		assertTrue(rise_result > 0);
		log.info(rise_result + "행이 변경");
	}
	
	@Test
	@Ignore
	public void testUpdate2_3() {	
		ChangeSalaryDTO dto = new ChangeSalaryDTO();
		
		dto.setManager_id(149);
		dto.setIncrement(-1050.0);
		
		int rise_result = prac_mapper.changeSalary2(dto);
		
		assertTrue(rise_result > 0);
		log.info(rise_result + "행이 변경");
	}
	
	@Test
	@Ignore
	public void testUpdate2_4() {	
		ChangeSalaryDTO dto = new ChangeSalaryDTO();
		
		dto.setDepartment_id(100);
		dto.setIncrement(5025.0);
		
		int rise_result = prac_mapper.changeSalary2(dto);
		
		assertTrue(rise_result > 0);
		log.info(rise_result + "행이 변경"); // 특정 사번 얼마만큼 월급 인상
	}
	
	
	@Test
	@Ignore
	public void testUpdate2_5() {	
		ChangeSalaryDTO dto = new ChangeSalaryDTO();
		
		dto.setIncrement(5025.0);
		
		int rise_result = prac_mapper.changeSalary2(dto);
		
		assertTrue(rise_result == 0);
		log.info(rise_result + "행이 변경"); // 특정 사번 얼마만큼 월급 인상
	}
	
	// 연습 2 : employees2 테이블과 departments 테이블을 이용한 JOIN한 쿼리문을 mybatis로 실행하여 Map 또는 VO로 가져와보세요
	@Test
	@Ignore
	public void testJoin() {
		log.info(prac_mapper.getJoinMap());
	}

	@Test
	@Ignore
	public void testTenEmployees() {
		List<Employee> page = emp_mapper.getPageEmployeeList(1, 10); // 1 페이지 10명
		
		assertEquals(10, page.size());
		
		// 자바의 ArrowFunction
		page.forEach(emp -> log.info(emp));	
//		for (Employee emp : page) {
//			log.info(emp);
//		}	
		
	}
	
	@Test
	@Ignore
	public void testTenEmployees2() {
		List<Employee> page = emp_mapper.getPageEmployeeList(2, 10); // 2페이지 10명
		
		assertEquals(10, page.size());
		
		for (Employee emp : page) {
			log.info(emp);
		}	
	}
	
	@Test
	@Ignore
	public void testEmployeesNumber() {
		List<Employee> list = emp_mapper.getEmployeeList(); // 2페이지 10명
		
		assertEquals(107, list.size());
		
		for (Employee emp : list) {
			log.info(emp);
		}	
	}
	
	@Test
	@Ignore
	public void testCount() {
		int cnt = emp_mapper.getEmployeeCount();
		
		assertEquals(108, cnt);
		
		log.info(cnt);
	}
	
	@Test
	@Ignore
	public void testServiceCount() {
		int cnt = page_service.startPage(9);
		
		assertEquals(8, cnt);
		
		log.info(cnt);
	}
	
	@Test
	public void testIdlist() {
		assertTrue(emp_mapper.getManagerIdList().size() > 0);
		assertTrue(emp_mapper.getDepartmentIdList().size() > 0);
		
		log.info(emp_mapper.getManagerIdList().get(0).getManager_id());
		log.info(emp_mapper.getDepartmentIdList().get(0).getDepartment_id());
	}
}
