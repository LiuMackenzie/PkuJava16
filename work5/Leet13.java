package com.ly.test;

public class Leet13 {
	public static void main(String args[]) {
		System.out.println(romanToInt("MDC"));
	}

	static public int romanToInt(String s) {
		// I(1)��V(5)��X(10)��L(50)��C(100)��D(500)��M(1000)��
		// ����������һ���ص㣬������ܿ�ȼ�����99������IC��ʾ��������switch�����ʱ�Ϳɼ���������
		// �Ӻ���ǰ������ĳһλ������һλ��ʱ����ʾ�������ֽ��м�������
		// �Ƚ����� ���ַ�����һ���ո�������ѭ���ڵ��ж�ʱ�����������Խ���쳣���Ҳ�Ӱ�����ս����
		// ʱ�临�Ӷ�:O(n)��
		s = s + " ";
		int size = s.length() - 1;
		char temp;
		int mid = 0;

		while (size >= 0) {
			temp = s.charAt(size);

			switch (temp) {
			case 'I':
				if (s.charAt(size + 1) == 'V' || s.charAt(size + 1) == 'X') {
					mid -= 1;
				} else {
					mid += 1;
				}
				break;
			case 'V':
				if (s.charAt(size + 1) == 'X') {
					mid -= 5;
				} else {
					mid += 5;
				}
				break;
			case 'X':
				if (s.charAt(size + 1) == 'L' || s.charAt(size + 1) == 'C') {
					mid -= 10;
				} else {
					mid += 10;
				}
				break;
			case 'L':
				if (s.charAt(size + 1) == 'C' || s.charAt(size + 1) == 'D') {
					mid -= 50;
				} else {
					mid += 50;
				}
				break;
			case 'C':
				if (s.charAt(size + 1) == 'D' || s.charAt(size + 1) == 'M') {
					mid -= 100;
				} else {
					mid += 100;
				}
				break;
			case 'D':
				if (s.charAt(size + 1) == 'M') {
					mid -= 500;
				} else {
					mid += 500;
				}
				break;
			case 'M':

				mid += 1000;
				break;
			}

			size--;
		}
		return mid;

	}
}
