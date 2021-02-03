package com.kgitbank.service;

import java.util.List;

import com.kgitbank.model.Employee;

public interface EmployeeService {

	public Employee salaryInformation(int pk);
	
	public List<Employee> employeeList(int page, int amount);
	
	public List<Employee> employeeAllList();
	
	// URL�� ���� �˾Ƽ� �����ϱ�
		// 1. ��ü ��� ��� ���� (10���� ������ ������ ����, ������ư, ������ư, ���ڹ�ư ����)
		// 2. ���ο� ��� �߰��ϱ�
		// 3. ������ ��� ���� �����ϱ�
		// 4. ��� ���� ���� �ϱ�
		// 5. �� �߰��ϰ� ���� ����� ������� �߰��غ��� 
	
	public int addEmployee(Employee emp);
	
	public int deleteEmployee(int emp_id);
	
	public int updateEmployee(Employee emp);
	
}
