package com.ly.test;

public class Leet171 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(titleToNumber("ABA"));
	}

	static public int titleToNumber(String s) {
		int total = 0;
		// for (int i = 1; i <= s.length(); i++) {
		// System.out.println(s.charAt(i-1) - 'A' + 1);
		// total = (s.charAt(i-1) - 'A' + 1) * (26 *(i - 1)) + total;
		// }
		// java内求幂运算用Math.pow(x,y);w
		int j = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			total = (int) (total + (s.charAt(i) - 'A' + 1) * Math.pow(26, j));
			j++;
		}
		return total;
	}
}
