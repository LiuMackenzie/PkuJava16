package com.ly.test;

public class Leet26 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = { 1, 1, 1, 3, 3, 3 };
		System.out.println(removeDuplicates(test, 4));
	}

	static int removeDuplicates(int nums[], int n) {
		//ʱ�临�Ӷ�O��n^2��
		int offset = 0;
		for (int i = 0; i < nums.length - 1 - offset; i++) {
			if (nums[i] == nums[i + 1]) {
				for (int j = i + 1; j < nums.length - 1 - offset; j++) {
					nums[j] = nums[j + 1];
				}
				// �������i--;
				// ��{1��1��1}���������£�ֻ�ܳ�ȥһ��1.
				i--;
				offset++;
			}
		}

		return nums.length - offset;
	}
}
