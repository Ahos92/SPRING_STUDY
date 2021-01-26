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
		
		// assert를 통과해야 테스트 성공이 인정된다.
//		assertEquals("테스트 메세지", 14, result); // (기대값, 결과값)
		
//		assertNull(null);
		
//		assertTrue(true);
		
//		int[] 당첨번호 = {1, 2, 3, 4, 5, 6, 7};
//		int[] 뽑은거 = {7, 6, 5, 4, 3, 2, 1};
//		
//		Arrays.sort(뽑은거);
//		
//		assertArrayEquals(당첨번호, 뽑은거);
		if (result > 0) {
			fail("이걸 만나면 실패입니다.");
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
