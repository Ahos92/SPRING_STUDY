package com.kgitbank.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

// 스프링 테스트의 추가적인 설정 (spring-test 필요)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DiTests {

	@Autowired
	private Student student;
	
	@Autowired
	private Uniform uniform;
	
	@Autowired
	private School school;
	
	@Autowired
	private Pizza pizza;
	
	@Test
	@Ignore
	public void testInfiPizza() {
		log.info(pizza);
	}
	
	@Test
	public void testStudentInstance() {
		log.info(student);
		
		assertNotNull(student);
	}
	
	@Test
	public void testUniFormInatance() {
		log.info(uniform);
		
		assertNotNull(uniform);
	}
	
	@Test
	public void testSchoolInatance() {
		log.info(school);
		
		assertNotNull(school);
	}
	
}
