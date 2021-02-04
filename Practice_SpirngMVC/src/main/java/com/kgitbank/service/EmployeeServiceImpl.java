package com.kgitbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgitbank.mapper.EmployeeMapper;
import com.kgitbank.model.Employee;
import com.kgitbank.model.PageNation;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeMapper emp_mapper; // 영원히 변경하지 않아도 되는 코드 ( 유지/보수 좋다 )
	
	@Override
	public Employee salaryInformation(int pk) {
		// 조회 횟수를 증가
		// ex > mapper.updateCount();
		
		// pk로 이름 / 월급 / 커미션을 조회한다.
		return emp_mapper.getEmployeeById(pk);
	}
	
	@Override
	public List<Employee> employeeList(PageNation pagenation) {
		return emp_mapper.getPageEmployeeList(pagenation.getPage(), pagenation.getAmount());
	}
	
	@Override
	public List<Employee> employeeAllList() {
		return emp_mapper.getEmployeeList();
	}


	@Override
	public int addEmployee(Employee emp) {	
		return emp_mapper.addEmployee(emp);
	}

	@Override
	public int updateEmployee(Employee emp) {
		return emp_mapper.updateEmployee(emp);
	}

	@Override
	public int deleteEmployee(int emp_id) {
		return emp_mapper.deleteEmployeeById(emp_id);
	}

	@Override
	public int allEmployeeCount() {
		return emp_mapper.getEmployeeCount();
	}

	@Override
	public int getEmployeeId() {
		return emp_mapper.getEmployeeMaxId() + 1;
	}

}
