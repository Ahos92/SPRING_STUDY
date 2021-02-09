package com.kgitbank.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.kgitbank.model.Employee;

public interface EmployeeMapper {
	
	// java �ڵ忡 �ϴ¤���
//	@Select("SELECT * FROM employees WHERE employee_id = #{id}")
//	Employee getEmployeeById(int id);
//	
//	@Select("SELECT * FROM employees")
//	List<Employee> getEmployeeList();
	
	// src/main/resources �ȿ� com/kgitbank/mapper/EmployeeMapper.xml ���� ����� ������ ����� ����
	Employee getEmployeeById(int id);
	
	List<Employee> getEmployeeList();
	
	List<Map<String, Object>> getEmployeeMap();
	
	// �����͸� Ŭ���� ���� ��ü�� ������!!
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
