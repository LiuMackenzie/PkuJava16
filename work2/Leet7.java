package com.ly.test;

public class Leet7 {
	public static void main(String args[]) {
		System.out.println(reverse(999997000));
	}

	static public int reverse(int x) {
		// ʱ�临�Ӷ�O(1)
		// ��intתΪStringBuffer�����β����쳣��Ȼͨ���˵����뿴����̫����
		Integer input = new Integer(x);
		if (x >= 0) {
			StringBuffer res = new StringBuffer(input.toString());
			if (res.lastIndexOf("0") == res.length()) {
				// ȥ��ĩβ���0
				res = new StringBuffer(res.substring(0, res.indexOf("0")));
			}
			try {
				return Integer.parseInt(res.reverse().toString());
				// ������ת������������쳣����
			} catch (NumberFormatException e) {
				return 0;
			}
		} else {
			StringBuffer res = new StringBuffer(input.toString());
			if (res.lastIndexOf("0") == res.length()) {
				res.indexOf("0");
				// ȥ��ĩβ���0
				res = new StringBuffer(res.substring(0, res.indexOf("0")));
			}
			try {
				return Integer.parseInt("-"
						+ res.reverse().substring(0, res.length() - 1));
			} catch (NumberFormatException e) {
				return 0;
			}
		}

	}
}
