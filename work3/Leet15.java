package com.ly.test;

import java.util.ArrayList;
import java.util.List;

public class Leet15 {


	public static List<List<Integer>> threeSum(int[] nums) {
		// 时间复杂度O（n^2）
		// 1.先将给的数组排序。
		// 2.for循环内从左到右遍历，记最左侧的元素为a,b是从a+1的点开始，c是数组的最后一个元素。
		// 3.由于数组已经自小到大排列好，因此当nums[a] + nums[b] + nums[c] < 0时b向右移动一个元素，
		// 当nums[a] + nums[b] + nums[c] < 0时c向左移动一个元素
		// 4.特别注意：需要考虑测试用例中会给重复的数字，如给的5个-15。要先判断是否已用过这个数字了，否则会超时。
		// 5.可能出现【0，0，0】这种结果，所以在第四步时重复多个0并不跳出。
		List<Integer> insideList;
		List<Integer> numList = new ArrayList<Integer>();
		List<List<Integer>> outsideList = new ArrayList<List<Integer>>();
		if (nums.length < 3)
			return outsideList;
		// 冒泡排序（从小到大）
		int temp = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 1; j < nums.length - i; j++) {
				if (nums[j - 1] > nums[j]) {
					temp = nums[j - 1];
					nums[j - 1] = nums[j];
					nums[j] = temp;
				}
			}
		}

		// start
		int c = nums.length - 1;
		int b = 0;
		for (int a = 0; a < nums.length - 1; a++) {
			// 除0以外的重复元素不考虑，否则超时不通过。
			if (numList.contains(nums[a]) && nums[a] != 0) {

				continue;
			}
			numList.add(nums[a]);
			b = a + 1;
			c = nums.length - 1;
			while (true) {
				// System.out.println("a:"+a+"--b:"+b+"---c:"+c);
				// System.out.println("nums[a]:"+nums[a]+"--nums[b]:"+nums[b]+"---nums[c]:"+nums[c]);
				if (b >= c)
					break;
				if (nums[a] + nums[b] + nums[c] == 0) {
					// System.out.println("----------------a:"+a+"--b:"+b+"---c:"+c);
					insideList = new ArrayList<Integer>();
					insideList.add(nums[a]);
					insideList.add(nums[b]);
					insideList.add(nums[c]);
					if (!outsideList.contains(insideList))
						outsideList.add(insideList);
					if (b < c)
						b++;
					else
						break;

				}
				if (nums[a] + nums[b] + nums[c] < 0) {
					if (b < c)
						b++;
					else
						break;

				}
				if (nums[a] + nums[b] + nums[c] > 0) {
					if (c > b)
						c--;
					else
						break;
				}
			}
		}
		return outsideList;
	}

}
