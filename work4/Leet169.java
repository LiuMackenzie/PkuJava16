package com.ly.test;

import java.util.HashMap;
import java.util.Map;

public class Leet169 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 6, 5, 5 };
		System.out.println(majorityElement(nums));
	}

	static public int majorityElement(int[] nums) {
		// 时间复杂度：O（n）,调用java的Map方法，运行时间长。
		// Map mapList = new HashMap();
		// int value = 0;
		// for (int i = 0; i < nums.length; i++) {
		//			    
		// if (mapList.get(nums[i]) != null) {
		// value = Integer.parseInt(mapList.get(nums[i]).toString());
		//					
		// value+=1;
		// // System.out.println(nums[i]);
		// // System.out.println(value+"---");
		// }else{value=1;}
		// mapList.put(nums[i], value);
		// if (value > nums.length / 2)
		// return nums[i];
		// }
		// return 0;

		// 网上资料使用 Moore's voting algorithm
		// 每次都找出一对不同的元素，从数组中删掉，直到数组为空或只有一种元素。
		// 不难证明，如果存在元素e出现频率超过半数，那么数组中最后剩下的就只有e。
		// 时间复杂度为O（n）;
		int majority = 0;
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (count == 0) {
				majority = nums[i];
				count++;
			} else {
				if (majority == nums[i]) {
					count++;
				} else {
					count--;
				}
				if (count >= nums.length / 2 + 1)
					return majority;
			}
		}
		return 0;

	}
}
