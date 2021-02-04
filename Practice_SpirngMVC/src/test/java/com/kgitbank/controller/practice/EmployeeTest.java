package com.kgitbank.controller.practice;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
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
import org.springframework.web.servlet.ModelAndView;

import com.kgitbank.model.Employee;

import jdk.internal.org.jline.utils.Log;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@Log4j
public class EmployeeTest {
	
	@Setter(onMethod_ = { @Autowired })
	private WebApplicationContext context;
	
	private MockMvc mock_mvc; 
	
	@Before
	public void init() {
		mock_mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void employeeMockTest() throws Exception {
		ModelAndView mnv = 
				mock_mvc.perform(
						MockMvcRequestBuilders.get("/emp/index").param("page", "1")
				
				).andReturn().getModelAndView();

		List<Employee> emp_model = (List<Employee>) mnv.getModel().get("list");
		String view_path = mnv.getViewName();
		
		assertEquals(10, emp_model.size());
		assertEquals("emp/index", view_path);
		
		log.info(emp_model.get(9));
		log.info(emp_model.size());
		log.info(view_path);
		
	}
}
