package com.ly.test;

import java.util.Arrays;

public class Leet217 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = { 6, 5, 1, 2, 3, 4 };
		System.out.println(sth(test));
	}

	static boolean sth(int[] nums) {
		// ����һ�� ģ��26��
		// ���������˳����������ظ���Ԫ�����Ϸ���true,�����ٶȽϿ�
		// ʱ�临�Ӷ�O��n��
		 Arrays.sort(nums);
		 for (int i = 0; i < nums.length - 1; i++) {
		 if (nums[i] == nums[i + 1]) {
		 return true;
		 }
		 }
		 return false;
		// ��������a[][]
		// ǰ�ᣬ��������Ԫ�ش���0������������Ԫ���и������˷�������AC
		// int res[] = new int[10000];
		// int temp=0;
		// for (int i = 0; i < nums.length; i++) {
		// if(nums[i]<0){
		// temp=10000-nums[i];
		// }else{
		// temp=nums[i];
		// }
		// if (res[temp] == 0) {
		// res[temp]++;
		// } else {
		// return true;
		// }
		// }
		// return false;
		// ��������Set
		// ʱ�临�Ӷ�O(n),�����ڵ���ϵͳHashSet����ʱ��ϳ���
		// HashSet res = new HashSet();
		// for (int i = 0; i < nums.length; i++) {
		// if (!res.contains(nums[i])) {
		// res.add(nums[i]);
		// } else {
		// return true;
		// }
		// }
		// return false;
	}
}
