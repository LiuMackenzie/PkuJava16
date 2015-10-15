package com.ly.test;

public class Leet125 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome("1a2"));
	}

	static public boolean isPalindrome(String s) {
		// 时间复杂度O（n）
		// 输入为null
		if (s == null)
			return true;
		int n = s.length() - 1;
		StringBuilder before = new StringBuilder();
		while (n >= 0) {
			// 去掉不在a~z,A~Z,0~9的字符

			if ((s.charAt(n) <= 'z' && s.charAt(n) >= 'a')
					|| (s.charAt(n) <= 'Z' && s.charAt(n) >= 'A')
					|| (s.charAt(n) <= '9' && s.charAt(n) >= '0')) {

				before.append(s.charAt(n));
			}
			n--;
		}
		// 新的字符全部转为小写
		String input = new String(before.toString().toLowerCase());
		StringBuilder finall = new StringBuilder(before.toString()
				.toLowerCase());
		// 将最终去除完符号的两个字符串进行对比
		if (input.equals(finall.reverse().toString())) {
			return true;
		}
		return false;
	}
}
