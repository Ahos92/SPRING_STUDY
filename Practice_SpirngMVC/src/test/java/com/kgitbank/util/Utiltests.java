package com.kgitbank.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;

public class Utiltests {

	@Test
	@Ignore
	public void testSum() {
		
		Calculator calc = new Calculator();
		
		int result = calc.sum(new int[] {1, 2, 3, 4, 5});
		
		// assert�� ����ؾ� �׽�Ʈ ������ �����ȴ�.
//		assertEquals("�׽�Ʈ �޼���", 14, result); // (��밪, �����)
		
//		assertNull(null);
		
//		assertTrue(true);
		
//		int[] ��÷��ȣ = {1, 2, 3, 4, 5, 6, 7};
//		int[] ������ = {7, 6, 5, 4, 3, 2, 1};
//		
//		Arrays.sort(������);
//		
//		assertArrayEquals(��÷��ȣ, ������);
		if (result > 0) {
			fail("�̰� ������ �����Դϴ�.");
		}
	
	}
	
	@Test
	@Ignore
	public void missionImpossible() {
		fail("Impossible!");
	}
	
	@Test(timeout=500)
	@Ignore
	public void testSpeed() {
		int i = 0;
		while (i >= 0) {
			System.out.println(i++);
		}
		
	}
	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testOutBound() {
		int[] abc = new int[3];
		
		abc[5] = 99;
	}
	
	
}
