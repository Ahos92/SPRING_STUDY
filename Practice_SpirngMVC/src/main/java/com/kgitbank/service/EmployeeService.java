package com.kgitbank.service;

import java.util.List;

import com.kgitbank.model.Employee;
import com.kgitbank.model.PageNation;

public interface EmployeeService {

	// URL은 각자 알아서 설정하기
	// 1. 전체 사원 목록 보기 (10개씩 페이지 단위로 보기, 다음버튼, 이전버튼, 숫자버튼 구현)
	// 2. 새로운 사원 추가하기
	// 3. 기존의 사원 정보 수정하기
	// 4. 사원 정보 삭제 하기
	// 5. 더 추가하고 싶은 기능은 마음대로 추가해보기 
	public Employee salaryInformation(int pk);
	
	public List<Employee> employeeList(PageNation pagenation);
	
	public List<Employee> employeeAllList();	
	
	public int addEmployee(Employee emp);
	
	public int deleteEmployee(int emp_id);
	
	public int updateEmployee(Employee emp);
	
	public int allEmployeeCount();
	
	public List<Employee> jobIdList();
	
	public List<Employee> managerIdList();
	
	public List<Employee> departmentIdList();
}
