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
		
		emp.setFirst_name("�浿");
		emp.setLast_name("ȫ");
		emp.setEmployee_name("����");
		
		emp2.setFirst_name("�浿");
		emp2.setLast_name("ȫ");
		emp2.setEmployee_name("����");

		// ���� ����
//		log.setLevel(Level.WARN);
		// log4j.xml ���� ����������

		log.info(emp);
		log.info(emp.equals(emp2));
		
		log.warn(emp2);
		log.error(emp2);
		log.fatal(emp2);
		
	}

}
