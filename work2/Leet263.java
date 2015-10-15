package com.ly.test;

public class Leet263 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isUgly(21));
	}

	static public boolean isUgly(int num) {
		//时间复杂度是O（n）

		// 1是Ugly Number
		if (num == 1)
			return true;
		// 根据测试用例，输入0时返回false
		if (num == 0)
			return false;
		while (num % 2 == 0)
			num = num / 2;
		while (num % 3 == 0)
			num = num / 3;
		while (num % 5 == 0)
			num = num / 5;
		if (num == 1)
			return true;
		else
			return false;
	}

}
