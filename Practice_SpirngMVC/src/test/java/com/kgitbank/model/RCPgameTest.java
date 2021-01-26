package com.kgitbank.model;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.junit.Test;

public class RCPgameTest {


	private static Logger log = Logger.getLogger(RCPgameTest.class);

	public static String rcpStr(int rcp) {
		switch(rcp) {

		case 1:
			return "가위";
		case 2:
			return "바위";
		case 3:
			return "보";
		default:
			return "잘못된 입력";
		}
	}

	@Test
	public void test() {
		System.out.println("## 가위 바위 보 게임 ##");
		int user, com;
		int win = 0, draw = 0, lose = 0;
		String result, logstr;
		
		for (int i = 0; i < 100; i++) {
			
			user = (int)(Math.random() * 2 + 1);
			com = (int)(Math.random() * 2 + 1);

			if (user == com) {
				result = "무!";
				draw++;

			} else if ((user == 1 && com == 3) 
					|| (user == 2 && com == 1) 
					|| (user == 3 && com == 2)) {
				result = "승!";
				win++;

			} else{
				result = "패!";
				lose++;
			}

			logstr = String.format("log : 유저 - %s / 컴퓨터 -%s [%s] %d전 %d승 %d무 %d패\n",
					rcpStr(user), rcpStr(com), result, i+1, win, draw, lose);

			log.info(logstr);

		}

	}
}
