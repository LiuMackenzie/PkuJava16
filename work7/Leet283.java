package com.ly.test;

public class Leet283 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void moveZeroes(int[] nums) {
		//ʱ�临�Ӷȣ�O��n^2��
		 int tag = 0;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] == 0&&i<nums.length - tag) {
					for (int j = i; j < nums.length - 1; j++) {
					nums[j]=nums[j+1];
					}
					tag++;
					nums[nums.length-tag]=0;
					//��һ���������[0��0��1].��ʱҪ����һλ����������ڶ���0�Ͳ����Ƶ�����β����
					i--;
				}
			}
	}
}
