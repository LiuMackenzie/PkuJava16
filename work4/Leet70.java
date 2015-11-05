package com.ly.test;

public class Leet70 {
	public int climbStairs(int n) {
		// ʱ�临�Ӷ�O��n��
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		// -----------------ֱ�ӵݹ� return ��ʱ------------------------
		// return climbStairs(n - 1) + climbStairs(n - 2);
		// -----------------ֱ�ӵݹ� return ��ʱ------------------------
		int step1 = 1;
		int step2 = 2;
		int res = 0;
		for (int i = 3; i <= n; i++) {
			res = step1 + step2;
			// 2��1
			step1 = step2;
			// res��2
			step2 = res;

		}
		return res;
	}
}
