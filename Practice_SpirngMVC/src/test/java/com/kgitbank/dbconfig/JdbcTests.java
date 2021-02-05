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
			log.info("Connection �� ������ : " + conn);
			
		} catch (SQLException e) {
			log.error("Connection �� ������ : " + e.getMessage());
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
		
		// HikariCP : getConnection()������ ������ ���ϰ� ������� (���� Ŀ�׼�Ǯ�� ������ �ʿ䰡 ������)
		// Mybatis : prepareStatment, execute, ResultSet�� ����ϴ� ������ �����ϰ� ������� - SqlSessionFactory
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
			// selectOne ���
			log.info(session.selectOne("com.kgitbank.mapper.EmployeeMapper.getEmployeeById", 119));
			
			for (Object person : session.selectList("com.kgitbank.mapper.EmployeeMapper.getEmployeeList")) {
				log.info(person);
			}
		} 

	}
	
	@Test
	@Ignore
	public void testEmpMapper() {
		// spring-mybatis�� mapper�� �ڵ� �����ϱ� ���� �˾Ƽ� sqlSessionFactory�� ���� sqlSession�� ������ ����Ѵ�.
		log.info("emp_mapper.get~~ : " + emp_mapper.getEmployeeById(119));
		
		for (Object person : emp_mapper.getEmployeeList()) {
			log.info(person);
		}
		
		// �ϳ��� row�� �ϳ��� MapŸ�� �Ǵ� VOŸ������ ��ȯ�Ͽ� ���� �� �ִ�.
		// �������� row�� MapŸ�� �Ǵ� VOŸ���� ����Ʈ�� ��ȯ�Ͽ� ���� �� �ִ�.
		// INSERT, UPDATE, DELETE�� ��쿡�� ��ȯ���� int�� ���� �� �ִ�.
		log.info(emp_mapper.getEmployeeMap());
		
	}
	
	
	// ���� : employees���̺��� �����Ͽ� employees2 ���̺��� ������ �� mybatis�� �̿��� CRUD�� �ǽ��غ�����
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
		log.info("���Ի�� " + save_result + "�� �Ի�!");
	}
	
	@Test
	@Ignore
	public void testDelete() {
		int fire_id = 107; 
		int delete_result = prac_mapper.deleteEmployeeById(fire_id);
		assertEquals(1, delete_result);
		log.info(fire_id + "�� ��� " + delete_result + "�� �ذ�");
	}
	
	@Test
	@Ignore
	public void testSelect() {
		log.info(prac_mapper.getNameBySalary(7700)); // ���� 7700�̻� ���
	}
	
	
	@Test
	@Ignore
	public void testUpdate() {	
		int rise_result = prac_mapper.changeSalary(777, 2500.0);
		assertEquals(1, rise_result);
		log.info(rise_result + "���� ����");
	}
	
	@Test
	@Ignore
	public void testUpdate2() {	
		ChangeSalaryDTO dto = new ChangeSalaryDTO();
		
		dto.setEmployee_id(777);
		dto.setIncrement(-500.0);
		
		int rise_result = prac_mapper.changeSalary2(dto);
		assertEquals(1, rise_result);
		log.info(rise_result + "���� ����");
	}
	
	@Test
	@Ignore
	public void testUpdate2_2() {	
		ChangeSalaryDTO dto = new ChangeSalaryDTO();
		
		dto.setJob_id("ST_CLERK");
		dto.setIncrement(500.0);
		
		int rise_result = prac_mapper.changeSalary2(dto);
		
		assertTrue(rise_result > 0);
		log.info(rise_result + "���� ����");
	}
	
	@Test
	@Ignore
	public void testUpdate2_3() {	
		ChangeSalaryDTO dto = new ChangeSalaryDTO();
		
		dto.setManager_id(149);
		dto.setIncrement(-1050.0);
		
		int rise_result = prac_mapper.changeSalary2(dto);
		
		assertTrue(rise_result > 0);
		log.info(rise_result + "���� ����");
	}
	
	@Test
	@Ignore
	public void testUpdate2_4() {	
		ChangeSalaryDTO dto = new ChangeSalaryDTO();
		
		dto.setDepartment_id(100);
		dto.setIncrement(5025.0);
		
		int rise_result = prac_mapper.changeSalary2(dto);
		
		assertTrue(rise_result > 0);
		log.info(rise_result + "���� ����"); // Ư�� ��� �󸶸�ŭ ���� �λ�
	}
	
	
	@Test
	@Ignore
	public void testUpdate2_5() {	
		ChangeSalaryDTO dto = new ChangeSalaryDTO();
		
		dto.setIncrement(5025.0);
		
		int rise_result = prac_mapper.changeSalary2(dto);
		
		assertTrue(rise_result == 0);
		log.info(rise_result + "���� ����"); // Ư�� ��� �󸶸�ŭ ���� �λ�
	}
	
	// ���� 2 : employees2 ���̺�� departments ���̺��� �̿��� JOIN�� �������� mybatis�� �����Ͽ� Map �Ǵ� VO�� �����ͺ�����
	@Test
	@Ignore
	public void testJoin() {
		log.info(prac_mapper.getJoinMap());
	}

	@Test
	@Ignore
	public void testTenEmployees() {
		List<Employee> page = emp_mapper.getPageEmployeeList(1, 10); // 1 ������ 10��
		
		assertEquals(10, page.size());
		
		// �ڹ��� ArrowFunction
		page.forEach(emp -> log.info(emp));	
//		for (Employee emp : page) {
//			log.info(emp);
//		}	
		
	}
	
	@Test
	@Ignore
	public void testTenEmployees2() {
		List<Employee> page = emp_mapper.getPageEmployeeList(2, 10); // 2������ 10��
		
		assertEquals(10, page.size());
		
		for (Employee emp : page) {
			log.info(emp);
		}	
	}
	
	@Test
	@Ignore
	public void testEmployeesNumber() {
		List<Employee> list = emp_mapper.getEmployeeList(); // 2������ 10��
		
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
