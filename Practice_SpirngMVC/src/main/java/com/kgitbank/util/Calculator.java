package com.kgitbank.util;

public class Calculator {

	public int sum(int[] arr) {
		int sum = 0;
		for (int num : arr) {
			sum += num;
		}
		return sum;
	}
	
}
