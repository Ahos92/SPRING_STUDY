package com.kgitbank.util;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;


public class PracticeTests {

	Lotto lotto;
	
	@Before
	public void testbefore() {
		lotto = new Lotto();
	}
	
	@After
	public void testafter() {	
		
	}
	
	@Test
	public void testEquals() {
		assertEquals(7, lotto.generateNumber().size());
	}
	
	@Test
	public void testSame() {	
		assertSame("same", new String("same"));
	}
	
	@Test
	public void testNull() {	
		ArrayList<Integer> test = lotto.generateNumber();
		assertNull(test.get(6));
	}
	
	@Test
	public void testNotNull() {	
		assertNotNull("");
	}
	
	@Test
	public void testTrue() {
		assertTrue('A' == 65);
	}
	
	@Test
	@Ignore
	public void testFail() {
		fail("����");
	}
	
	@Test(expected=NumberFormatException.class)
	public void testExceptoin() {
		System.out.println("  testExceptoin() �׽�Ʈ ��");
		
		String str = "��~��ȣ~123";
		int[] yaho = new int[3];
		
		for (int i = 0; i < yaho.length; i++) {
			String[] str_arr = str.split("~");
			
			yaho[i] = Integer.parseInt(str_arr[i]);		
		}
		
	}
	
//	@Test(timeout=10)
//	public void testTime() {
//		System.out.println("  testTime() �׽�Ʈ ��");
//		int i = 0;
//		while (i <= 3000000) {
//			System.out.println(i++);
//		}
//		
//	}

}
