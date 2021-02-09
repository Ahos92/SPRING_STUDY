package com.kgitbank.controller.rest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kgitbank.mapper.PracticeMapper;
import com.kgitbank.model.ChangeSalaryDTO;
import com.kgitbank.model.Employee;
import com.kgitbank.service.EmployeeService;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/rest/")
@Log4j
public class RestSampleController {

	@Autowired
	EmployeeService emp_service;
	@Autowired
	PracticeMapper p_mapper;
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
	
	@GetMapping(value = "/getJson/{employee_id}",
				produces = "application/json; charset=UTF-8")
	public ResponseEntity<Employee> getJson(@PathVariable("employee_id") int employee_id) {
		// jackson databind 라이브러리는 VO형태의 클래스를 응답하면 
		// JSON 또는 XML타입으로 자동으로 변환하여 응답한다.
		
//		log.info("MIME Type들을 상수화 시켜놓은 것 : " + MediaType.APPLICATION_JSON_VALUE);
//		log.info("employee_id : " + employee_id);
		Employee emp =  emp_service.salaryInformation(employee_id);
		
		// ResponseEntity : status code를 다르게 리턴하기 (ajax에서 활용)
		return emp == null ? new ResponseEntity<>(HttpStatus.BAD_REQUEST) 
												: new ResponseEntity<>(emp, HttpStatus.OK) ;
	}
	
	@GetMapping(value = "/getXML",
				produces = "application/xml")
	public Employee getXML() {
		log.info("MIME Type들을 상수화 시켜놓은 것 : " + MediaType.APPLICATION_XML_VALUE);
		return emp_service.salaryInformation(100);
	}
	
	// 두가지 produces타입을 모두 사용하는 경우, 경로 뒤에 .json을 붙여야 json형태로 응답을 받을 수 있다.
	@GetMapping(value = "/getMap",
				produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Map<String, Employee> getMap() {
		Map<String, Employee> map = new HashMap<>();
		
		map.put("frist_employee", emp_service.salaryInformation(100));
		map.put("second_employee", emp_service.salaryInformation(101));
		
		return map;
	}
	
	// 두가지 produces를 모두 쓰는 것은 produces 타입을 안쓰는 것과 동일하다
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
	@PostMapping(value = "/employee",
				consumes = "application/json", // 데이터를 받고
				produces = "text/plain; charset=UTF-8"// 가공해서 데이터를 반환
				)
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee new_emp) {
		log.info("INSERT할 데이터 : " + new_emp);

		int result = emp_service.addEmployee(new_emp);
		
		return result > 0 ? new ResponseEntity<>(HttpStatus.OK) 
							: new ResponseEntity<>(HttpStatus.BAD_REQUEST) ;
	}
	
	@PatchMapping(value = "/employee",
			consumes = "application/json", // 데이터를 받고
			produces = "application/json; charset=UTF-8"// 가공해서 데이터를 반환
			)
	public ResponseEntity<ChangeSalaryDTO> updateEmp(@RequestBody ChangeSalaryDTO incre) {
	
		int result = p_mapper.changeSalary2(incre); 

		return result > 0 ? new ResponseEntity<>(HttpStatus.OK) 
							: new ResponseEntity<>(HttpStatus.BAD_REQUEST) ;
	}
}
