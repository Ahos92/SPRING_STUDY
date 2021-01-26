package com.kgitbank.model;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.junit.Test;

public class RCPgameTest {


	private static Logger log = Logger.getLogger(RCPgameTest.class);

	public static String rcpStr(int rcp) {
		switch(rcp) {

		case 1:
			return "����";
		case 2:
			return "����";
		case 3:
			return "��";
		default:
			return "�߸��� �Է�";
		}
	}

	@Test
	public void test() {
		System.out.println("## ���� ���� �� ���� ##");
		int user, com;
		int win = 0, draw = 0, lose = 0;
		String result, logstr;
		
		for (int i = 0; i < 100; i++) {
			
			user = (int)(Math.random() * 2 + 1);
			com = (int)(Math.random() * 2 + 1);

			if (user == com) {
				result = "��!";
				draw++;

			} else if ((user == 1 && com == 3) 
					|| (user == 2 && com == 1) 
					|| (user == 3 && com == 2)) {
				result = "��!";
				win++;

			} else{
				result = "��!";
				lose++;
			}

			logstr = String.format("log : ���� - %s / ��ǻ�� -%s [%s] %d�� %d�� %d�� %d��\n",
					rcpStr(user), rcpStr(com), result, i+1, win, draw, lose);

			log.info(logstr);

		}

	}
}
