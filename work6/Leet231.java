package com.ly.test;

public class Leet231 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.MIN_VALUE - 1);
	}

	public static boolean intToByte4(int n) {
		// method 1
		// ʱ�临�Ӷ�O(n)
		// int flag = 0;
		// if (n == 1 || n == 2)
		// return true;
		// while (true) {
		// flag = n % 2;
		// n = n / 2;
		// if ((flag == 1 && n != 1) || n == 0) {
		// return false;
		// } else if (flag == 0 && n == 2) {
		// return true;
		// }

		// method 2
		// -2147483648��int��������С����ֵ
		// -2147483648-1��ֵ��2147483647;��ʱ-2147483648��2147483647�������㣬���Ϊ0.
		// ʱ�临�Ӷ�O(1)
		if (n == 0 || n == -2147483648)
			return false;
		int a = n & (n - 1);
		if (a == 0)
			return true;
		else
			return false;
	}
}
