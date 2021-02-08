package com.kgitbank.controller.rest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.kgitbank.model.Employee;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
						"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class RestSampleConTests {

	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	@Ignore
	public void testGetEmployee() throws Exception {
		log.info(mockMvc.perform(
				MockMvcRequestBuilders.get("/rest/employee/100")).andReturn()
																 .getResponse()
																 .getContentAsString()
		);
			
	}
	
	@Test
	public void testPostEmployee() throws Exception {
		Employee emp = new Employee();
		
		emp.setDepartment_id(999);
		emp.setFirst_name("babo");
		emp.setLast_name("king");
		emp.setEmail("STUPID");
		emp.setPhone_number("010.1010.1010");
		emp.setJob_id("IT_PROG");
		emp.setSalary(2600.0);
		emp.setCommission_pct(0.2);
		emp.setManager_id(100);
		emp.setDepartment_id(90);
		
		// 넘겨받은 데이터JSON으로 바꾸기
		String json_str = new Gson().toJson(emp);
		log.info("JSON으로 변환된 홍길동 : " + json_str);
		
		log.info(mockMvc.perform(
			MockMvcRequestBuilders.post("/rest/employee/create").contentType("application/json")
																.content(new Gson().toJson(emp))
																).andReturn().getResponse().getContentAsString());
																//.andExpect(status().is(200)); 
																// 200 -> OK	( 200은 성공번호 / (404) 경로실패 ...)	
			
	}
	
}
