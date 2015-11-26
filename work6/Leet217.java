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
		// 方法一： 模仿26题
		// 数组排序后，顺序遍历，有重复的元素马上返回true,运行速度较快
		// 时间复杂度O（n）
		 Arrays.sort(nums);
		 for (int i = 0; i < nums.length - 1; i++) {
		 if (nums[i] == nums[i + 1]) {
		 return true;
		 }
		 }
		 return false;
		// 方法二：a[][]
		// 前提，给的数组元素大于0；测试用例中元素有负数，此方法不能AC
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
		// 方法三：Set
		// 时间复杂度O(n),但由于调用系统HashSet方法时间较长。
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
