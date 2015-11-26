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

		// ����һ��ʹ������ָ��
		// ʱ�临�Ӷ�O(n)
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

		// ����������ȥ�غ�ʹ������forѭ�������м۸�
		// ʱ�临�Ӷ�O��n^2��,��������������ͨ����������AC.
		//		
		// int offset = 0;
		// for (int i = 0; i < prices.length - 1 - offset; i++) {
		// if (prices[i] == prices[i + 1]) {
		// for (int j = i + 1; j < prices.length - 1 - offset; j++) {
		// prices[j] = prices[j + 1];
		// }
		// // �������i--;
		// // ��{1��1��1}���������£�ֻ�ܳ�ȥһ��1.
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
