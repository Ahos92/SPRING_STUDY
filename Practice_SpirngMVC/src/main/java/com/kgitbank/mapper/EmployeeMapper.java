package com.kgitbank.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.kgitbank.model.Employee;

public interface EmployeeMapper {
	
	// java 코드에 하는ㄴ법
//	@Select("SELECT * FROM employees WHERE employee_id = #{id}")
//	Employee getEmployeeById(int id);
//	
//	@Select("SELECT * FROM employees")
//	List<Employee> getEmployeeList();
	
	// src/main/resources 안에 com/kgitbank/mapper/EmployeeMapper.xml 같은 경로의 폴더를 만들어 설정
	Employee getEmployeeById(int id);
	
	List<Employee> getEmployeeList();
	
	List<Map<String, Object>> getEmployeeMap();
	
	// 데이터모델 클래스 만들어서 객체로 보내기!!
	List<Employee> getPageEmployeeList(
					@Param("page") int page,
					@Param("amount") int amount);
	
	int addEmployee(Employee emp);
	
	int deleteEmployeeById(int emp_id);
	
	int updateEmployee(Employee emp);
	
	int getEmployeeCount();

	List<Employee> getJobIdList();
	
	List<Employee> getManagerIdList();
	
	List<Employee> getDepartmentIdList();
	
	int updateSalary(int emp_id);
}
