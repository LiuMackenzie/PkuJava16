package com.ly.test;

public class Leet13 {
	public static void main(String args[]) {
		System.out.println(romanToInt("MDC"));
	}

	static public int romanToInt(String s) {
		// I(1)，V(5)，X(10)，L(50)，C(100)，D(500)，M(1000)。
		// 罗马数字有一个特点，左减不能跨等级，既99不能用IC表示，这样在switch语句检查时就可减少条件。
		// 从后向前遍历，某一位比他后一位低时，表示都此数字进行减操作。
		// 先将输入 的字符串加一个空格，这样在循环内的判定时不会出现数组越界异常，且不影响最终结果。
		// 时间复杂度:O(n)。
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
