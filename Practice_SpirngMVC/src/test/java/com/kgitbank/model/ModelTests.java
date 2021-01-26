package com.kgitbank.model;

import static org.junit.Assert.*;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Test;

public class ModelTests {

	// org.apache.log4j.Logger;
	private Logger log = Logger.getLogger(ModelTests.class);
	
	@Test
	public void testLombok() {
		Employee emp = new Employee();
		Employee emp2 = new Employee();
		
		emp.setFirst_name("길동");
		emp.setLast_name("홍");
		emp.setEmployee_name("의적");
		
		emp2.setFirst_name("길동");
		emp2.setLast_name("홍");
		emp2.setEmployee_name("의적");

		// 레벨 설정
//		log.setLevel(Level.WARN);
		// log4j.xml 에서 설정도가능

		log.info(emp);
		log.info(emp.equals(emp2));
		
		log.warn(emp2);
		log.error(emp2);
		log.fatal(emp2);
		
	}

}
