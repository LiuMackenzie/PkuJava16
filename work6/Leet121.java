package com.ly.test;

public class Leet121 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = { 1, 2, 4, 5, 7 };
		System.out.println(maxProfit(test));

	}

	static public int maxProfit(int[] prices) {

		// 方法一：使用两个指针
		// 时间复杂度O(n)
		int front = 0;
		int profit = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[front] > prices[i]) {
				front = i;
			}
			if (profit < prices[i] - prices[front]) {
				profit = prices[i] - prices[front];
			}
		}
		return profit;

		// 方法二：在去重后，使用两个for循环求最有价格。
		// 时间复杂度O（n^2）,单个测试用例可通过，但不能AC.
		//		
		// int offset = 0;
		// for (int i = 0; i < prices.length - 1 - offset; i++) {
		// if (prices[i] == prices[i + 1]) {
		// for (int j = i + 1; j < prices.length - 1 - offset; j++) {
		// prices[j] = prices[j + 1];
		// }
		// // 如果不在i--;
		// // 在{1，1，1}这种用例下，只能出去一个1.
		// i--;
		// offset++;
		// }
		// }
		//
		//
		//		
		//		
		// int profit = 0;
		// for (int i = 0; i < prices.length - offset; i++) {
		// for (int j = i; j < prices.length - offset; j++) {
		// if (profit < prices[j] - prices[i] || profit <= 0) {
		// profit = prices[j] - prices[i];
		// }
		// }
		// }
		// return profit;
	}
}
