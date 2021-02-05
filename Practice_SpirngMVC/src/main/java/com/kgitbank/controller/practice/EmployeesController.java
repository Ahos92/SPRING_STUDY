package com.kgitbank.controller.practice;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kgitbank.mapper.EmployeeMapper;
import com.kgitbank.model.Employee;
import com.kgitbank.model.PageNation;
import com.kgitbank.service.EmployeeService;
import com.kgitbank.service.PageService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/emp/*")
@Log4j
public class EmployeesController {
	
	@Autowired
	EmployeeService emp_service;
//	@Autowired
//	PageService page_service;
	
	@GetMapping("salinfo")
	public String salinfo(Model model, int pk) {
		model.addAttribute("emp", emp_service.salaryInformation(pk));	
		log.info("Salary Info : " + pk);
		return "emp/salinfo";
	}

	
	/*
	 * test
	 */
	@GetMapping("test")
	public String test() {
		return "resourceTest";
	}
	
	
	/** 
	 * Quiz 
	 */
	
	// http://localhost:8080/practice_mvc/emp/index?page=1&amount=10
	@GetMapping("index")
	public String empIndex(Model model, PageNation pagenation) {
		model.addAttribute("list", emp_service.employeeList(pagenation));	
		// ������ �� Ŭ���� ��ü�� �޾Ƽ� ���ٿ� ������ �ִ�
		model.addAttribute("page", pagenation.getPageData(7, emp_service.allEmployeeCount()));
		
		// service �޾Ƽ� ���� ������ �ڵ�
//		int endPage = page_service.endPage(page);
//		int lastPage = page_service.lastPage(amount);
//		
//		endPage = endPage > lastPage ? lastPage : endPage;
//		
//		model.addAttribute("currPage", page);
//		model.addAttribute("amount", amount);
//		model.addAttribute("startPage", page_service.startPage(page));
//		model.addAttribute("endPage", endPage);
//		model.addAttribute("lastPage", lastPage);
//		model.addAttribute("previous", page_service.prevPage(page));
//		model.addAttribute("next", page_service.nextPage(page, amount));
		
		return "emp/index";
	}
	
	@GetMapping("detail")
	public String detialEmp(Model model, int id) {
		model.addAttribute("emp", emp_service.salaryInformation(id));
		return "emp/detail";
	}
	
	@PostMapping("addpage")
	public String addPageEmp(Model model) {
		model.addAttribute("jobId", emp_service.jobIdList());
		model.addAttribute("manId", emp_service.managerIdList());
		model.addAttribute("deptId", emp_service.departmentIdList());
		
		return "emp/addpage";
	}
	
	@PostMapping("add")
	public String success(Model model, Employee emp) {
		int result = emp_service.addEmployee(emp);
		
		String msg = result > 0 ? "���ο� ����� �߰��Ǿ����ϴ�." : "�����Ͽ����ϴ�.";
		model.addAttribute("msg", msg);
		
		return "emp/success";
	}
	
	// @PathVariable �� �޾ƿ���
	 @GetMapping(value = "delete/{pk}")
	 public String deleteGet(@PathVariable("pk") int id) {
		 log.info(id);
	 	return "emp/delete";
	 }
	 
	 //hidden���� ����
//	@PostMapping("delete")
//	public String delete(Model model, int id) {
//		emp_service.deleteEmployee(id);
//		return "emp/delete";
//	}
	
	@PostMapping("updatepage")
	public String updatepage(Model model, int id) {
		
		model.addAttribute("emp", emp_service.salaryInformation(id));
		
		return "emp/updatepage";
	}
	
	@PostMapping("update")
	public String update(Model model, Employee emp) {
		model.addAttribute("row", emp_service.updateEmployee(emp));
		model.addAttribute("emp", emp_service.salaryInformation(emp.getEmployee_id()));
		return "emp/update";
	}
	
}
