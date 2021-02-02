package com.kgitbank.mapper;

import java.util.List;
import java.util.Map;

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
	
}
