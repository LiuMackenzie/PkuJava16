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
		// ʱ�临�Ӷȣ�O��n��,����java��Map����������ʱ�䳤��
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

		// ��������ʹ�� Moore's voting algorithm
		// ÿ�ζ��ҳ�һ�Բ�ͬ��Ԫ�أ���������ɾ����ֱ������Ϊ�ջ�ֻ��һ��Ԫ�ء�
		// ����֤�����������Ԫ��e����Ƶ�ʳ�����������ô���������ʣ�µľ�ֻ��e��
		// ʱ�临�Ӷ�ΪO��n��;
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
