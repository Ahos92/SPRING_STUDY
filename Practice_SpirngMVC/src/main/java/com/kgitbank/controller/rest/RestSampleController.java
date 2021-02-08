package com.kgitbank.controller.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kgitbank.model.Employee;
import com.kgitbank.service.EmployeeService;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/rest/")
@Log4j
public class RestSampleController {

	@Autowired
	EmployeeService emp_service;
	
	/* 
	 * READ - GET
	 * */
	@GetMapping(value = "/getText",
				produces = "text/plain; charset=UTF-8")
	public String getText() {
		return "<h1 style=\"color: teal;\">Hello, REST!</h1>";
	}

	@GetMapping(value = "/getHtml",
				produces = "text/html; charset=UTF-8")
	public String getHtml() {
		return "<h1 style=\"color: orange;\">Hello, REST!</h1>";
	}
	
	@GetMapping(value = "/getJson",
				produces = "application/json; charset=UTF-8")
	public Employee getJson() {
		// jackson databind ���̺귯���� VO������ Ŭ������ �����ϸ� 
		// JSON �Ǵ� XMLŸ������ �ڵ����� ��ȯ�Ͽ� �����Ѵ�.
		log.info("MIME Type���� ���ȭ ���ѳ��� �� : " + MediaType.APPLICATION_JSON_VALUE);
		return emp_service.salaryInformation(100);
	}
	
	@GetMapping(value = "/getXML",
				produces = "application/xml")
	public Employee getXML() {
		log.info("MIME Type���� ���ȭ ���ѳ��� �� : " + MediaType.APPLICATION_XML_VALUE);
		return emp_service.salaryInformation(100);
	}
	
	// �ΰ��� producesŸ���� ��� ����ϴ� ���, ��� �ڿ� .json�� �ٿ��� json���·� ������ ���� �� �ִ�.
	@GetMapping(value = "/getMap",
				produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Map<String, Employee> getMap() {
		Map<String, Employee> map = new HashMap<>();
		
		map.put("frist_employee", emp_service.salaryInformation(100));
		map.put("second_employee", emp_service.salaryInformation(101));
		
		return map;
	}
	
	// �ΰ��� produces�� ��� ���� ���� produces Ÿ���� �Ⱦ��� �Ͱ� �����ϴ�
	@GetMapping(value="/getList")
	public List<Employee> getList() {
		return emp_service.employeeAllList();
	}
	
	@GetMapping(value = "/employee/{employee_id}",
				produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployee(@PathVariable("employee_id") int employee_id) {
		log.info(employee_id);
		return emp_service.salaryInformation(employee_id);
	}
	
	
	
	/*
	 * CREATE - POST
	 */
	@PostMapping(value = "/employee/create",
				consumes = "application/json", // �����͸� �ް�
				produces = "text/html; charset=UTF-8"// �����ؼ� �����͸� ��ȯ
				)
	public String createEmployee(@RequestBody Employee new_emp) {
		log.info(new_emp);
		
		// INSERT INTO employees2 VALUES (JSON���� ���� ������)
		int result = 1;
		
		return result > 0 ? "<h1>success</h1>" : "<h1>fail</h1>";
	}
	
	
}
