package com.kgitbank.util;

import java.util.ArrayList;

public class Lotto {

	public ArrayList<Integer> generateNumber() {
		ArrayList<Integer> nums = new ArrayList<>();
		int ran;
		
		for (int i = 0; i < 7;) {
			ran = (int)(Math.random() * 45 + 1);
			
			if (!nums.contains(ran)) {
				nums.add(ran);
				i++;
			}
		}
		
		return nums;
	}

}
