package com.ly.test;

public class Leet7 {
	public static void main(String args[]) {
		System.out.println(reverse(999997000));
	}

	static public int reverse(int x) {
		// 时间复杂度O(1)
		// 将int转为StringBuffer，两次捕获异常虽然通过了但代码看起来太乱了
		Integer input = new Integer(x);
		if (x >= 0) {
			StringBuffer res = new StringBuffer(input.toString());
			if (res.lastIndexOf("0") == res.length()) {
				// 去除末尾多个0
				res = new StringBuffer(res.substring(0, res.indexOf("0")));
			}
			try {
				return Integer.parseInt(res.reverse().toString());
				// 由于逆转产生的溢出用异常捕获
			} catch (NumberFormatException e) {
				return 0;
			}
		} else {
			StringBuffer res = new StringBuffer(input.toString());
			if (res.lastIndexOf("0") == res.length()) {
				res.indexOf("0");
				// 去除末尾多个0
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
