package com.ly.test;

import java.util.Arrays;

public class Leet242 {
	public static void main(String args[]) {
		System.out.println(isAnagram("''", "''"));
	}

	static public boolean isAnagram(String s, String t) {
		// 转换为数组后对比，使用Arrays.equals(fi, se)对比数组内容，否则比较的是数组的地址
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
