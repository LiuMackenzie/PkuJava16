package com.ly.test;

import java.util.Arrays;

public class Leet242 {
	public static void main(String args[]) {
		System.out.println(isAnagram("''", "''"));
	}

	static public boolean isAnagram(String s, String t) {
		// ת��Ϊ�����Աȣ�ʹ��Arrays.equals(fi, se)�Ա��������ݣ�����Ƚϵ�������ĵ�ַ
		char[] fi = s.toCharArray();
		char[] se = t.toCharArray();
		Arrays.sort(fi);
		Arrays.sort(se);
		// for()
		if (Arrays.equals(fi, se))
			// if(fi.equals(se))
			return true;
		else
			return false;

	}

}
