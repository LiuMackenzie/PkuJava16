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
		// ʱ�临�Ӷ�O��n��
		// ����Ϊnull
		if (s == null)
			return true;
		int n = s.length() - 1;
		StringBuilder before = new StringBuilder();
		while (n >= 0) {
			// ȥ������a~z,A~Z,0~9���ַ�

			if ((s.charAt(n) <= 'z' && s.charAt(n) >= 'a')
					|| (s.charAt(n) <= 'Z' && s.charAt(n) >= 'A')
					|| (s.charAt(n) <= '9' && s.charAt(n) >= '0')) {

				before.append(s.charAt(n));
			}
			n--;
		}
		// �µ��ַ�ȫ��תΪСд
		String input = new String(before.toString().toLowerCase());
		StringBuilder finall = new StringBuilder(before.toString()
				.toLowerCase());
		// ������ȥ������ŵ������ַ������жԱ�
		if (input.equals(finall.reverse().toString())) {
			return true;
		}
		return false;
	}
}
