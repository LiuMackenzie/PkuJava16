package com.ly.test;

public class Leet70 {
	public int climbStairs(int n) {
		// 时间复杂度O（n）
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		// -----------------直接递归 return 超时------------------------
		// return climbStairs(n - 1) + climbStairs(n - 2);
		// -----------------直接递归 return 超时------------------------
		int step1 = 1;
		int step2 = 2;
		int res = 0;
		for (int i = 3; i <= n; i++) {
			res = step1 + step2;
			// 2给1
			step1 = step2;
			// res给2
			step2 = res;

		}
		return res;
	}
}
