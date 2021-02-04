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
	EmployeeMapper emp_mapper; // ������ �������� �ʾƵ� �Ǵ� �ڵ� ( ����/���� ���� )
	
	@Override
	public Employee salaryInformation(int pk) {
		// ��ȸ Ƚ���� ����
		// ex > mapper.updateCount();
		
		// pk�� �̸� / ���� / Ŀ�̼��� ��ȸ�Ѵ�.
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
