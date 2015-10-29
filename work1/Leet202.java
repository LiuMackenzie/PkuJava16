package com.ly.test;

import java.util.ArrayList;

public class Leet202 {
	public static void main(String args[]) {
		System.out.print(isHappy(19));
	}

	static public boolean isHappy(int n) {
		//ÿ������Ĵ���������ֵn��λ������ÿ��n�Ƿ�ΪHappyNumber��ء�
		//T��n��=��
		ArrayList array = new ArrayList();
		while (n <= Integer.MAX_VALUE) {
			if (array.contains(n)) {
				return false;
			} else {
				array.add(n);
			}
			n = count(n);
			if (n == 1)
				return true;
		}
		return false;
	}

	// ����ÿһλ��ƽ����
	static public int count(int num) {
		int count = 0;
		int a;
		while (true) {
			a = num % 10;
			num = num / 10;
			count += a * a;
			if (num <= 0) {
				break;
			}
		}
		return count;
	}
}
