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
	
	
	// URL은 각자 알아서 설정하기
	// 1. 전체 사원 목록 보기 (10개씩 페이지 단위로 보기, 다음버튼, 이전버튼, 숫자버튼 구현)
	// 2. 새로운 사원 추가하기
	// 3. 기존의 사원 정보 수정하기
	// 4. 사원 정보 삭제 하기
	// 5. 더 추가하고 싶은 기능은 마음대로 추가해보기 
	
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
