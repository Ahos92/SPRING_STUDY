package com.kgitbank.controller.practice;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kgitbank.mapper.EmployeeMapper;
import com.kgitbank.model.Employee;
import com.kgitbank.service.EmployeeService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/emp/*")
@Log4j
public class EmployeesController {
	
	@Autowired
	EmployeeService emp_service;	
	
	@GetMapping("salinfo")
	public String salinfo(Model model, int pk) {
		model.addAttribute("emp", emp_service.salaryInformation(pk));	
		log.info("Salary Info : " + pk);
		return "emp/salinfo";
	}
	
	
	// URL�� ���� �˾Ƽ� �����ϱ�
	// 1. ��ü ��� ��� ���� (10���� ������ ������ ����, ������ư, ������ư, ���ڹ�ư ����)
	// 2. ���ο� ��� �߰��ϱ�
	// 3. ������ ��� ���� �����ϱ�
	// 4. ��� ���� ���� �ϱ�
	// 5. �� �߰��ϰ� ���� ����� ������� �߰��غ��� 
	
	@GetMapping("index")
	public String empIndex(Model model, int page) {	
		model.addAttribute("list", emp_service.employeeList(page, 10));	
		model.addAttribute("all", emp_service.employeeAllList());
		return "emp/index";
	}
	
	@GetMapping("detail")
	public String detialEmp(Model model, int id) {
		model.addAttribute("emp", emp_service.salaryInformation(id));
		return "emp/detail";
	}
	
	@PostMapping("addpage")
	public String addPageEmp() {
		
		return "emp/addpage";
	}
	
	@PostMapping("add")
	public String success(Model model, Employee emp) {
		emp_service.addEmployee(emp);
		
		return "emp/success";
	}
	
	@PostMapping("delete")
	public String delete(Model model, int id) {
		emp_service.deleteEmployee(id);
		return "emp/delete";
	}
	
	@PostMapping("updatepage")
	public String updatepage(Model model, int id) {
		
		model.addAttribute("emp", emp_service.salaryInformation(id));
		
		return "emp/updatepage";
	}
	
	@PostMapping("update")
	public String update(Model model, Employee emp, Date hire_date) {
		
		model.addAttribute("emp", emp_service.updateEmployee(emp));
		return "emp/update";
	}
	
}
