package com.ly.test;

public class Leet283 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void moveZeroes(int[] nums) {
		//时间复杂度：O（n^2）
		 int tag = 0;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] == 0&&i<nums.length - tag) {
					for (int j = i; j < nums.length - 1; j++) {
					nums[j]=nums[j+1];
					}
					tag++;
					nums[nums.length-tag]=0;
					//有一种情况，如[0，0，1].此时要后退一位遍历，否则第二个0就不能移到数组尾部了
					i--;
				}
			}
	}
}
