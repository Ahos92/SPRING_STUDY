package com.kgitbank.service;

import java.util.List;

import com.kgitbank.model.Employee;
import com.kgitbank.model.PageNation;

public interface EmployeeService {

	// URL�� ���� �˾Ƽ� �����ϱ�
	// 1. ��ü ��� ��� ���� (10���� ������ ������ ����, ������ư, ������ư, ���ڹ�ư ����)
	// 2. ���ο� ��� �߰��ϱ�
	// 3. ������ ��� ���� �����ϱ�
	// 4. ��� ���� ���� �ϱ�
	// 5. �� �߰��ϰ� ���� ����� ������� �߰��غ��� 
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
