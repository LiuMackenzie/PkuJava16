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
		//ʱ�临�Ӷ���O��n��

		// 1��Ugly Number
		if (num == 1)
			return true;
		// ���ݲ�������������0ʱ����false
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
