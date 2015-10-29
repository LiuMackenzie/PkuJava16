package com.ly.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet18 {


	public List<List<Integer>> fourSum(int[] nums, int target) {
		// 时间复杂度是O（n^3）
		// 1.参考15题，3Sum。加一重循环，修改判定条件即可。
		// 2.当target=4可以有【2，2，0，0】这种情况，故不需判重。
		List<Integer> insideList;
		List<List<Integer>> outsideList = new ArrayList<List<Integer>>();
		if (nums.length < 3)
			return outsideList;
		Arrays.sort(nums);
		// for (int i = 0; i < nums.length; i++) {
		// if(midList.add(e))
		// midList.add(nums[i]);
		// }
		// start
		int c = nums.length - 1;
		int b = 0;
		int d = 0;
		for (int a = 0; a < nums.length - 1; a++) {
			// 除0以外的重复元素不考虑，否则超时不通过。
			// if (numList.contains(nums[a]) && nums[a] != 0) {
			//
			// continue;
			// }
			// numList.add(nums[a]);
			for (d = a + 1; d < nums.length - 2; d++) {
				b = d + 1;
				c = nums.length - 1;
				while (true) {
					// System.out.println("a:"+a+"--b:"+b+"---c:"+c);
					// System.out.println("nums[a]:"+nums[a]+"--nums[b]:"+nums[b]+"---nums[c]:"+nums[c]);
					if (b >= c)
						break;
					if (nums[a] + nums[b] + nums[c] + nums[d] == target) {
						// System.out.println("----------------a:"+a+"--b:"+b+"---c:"+c);
						insideList = new ArrayList<Integer>();

						insideList.add(nums[a]);
						insideList.add(nums[d]);
						insideList.add(nums[b]);
						insideList.add(nums[c]);

						if (!outsideList.contains(insideList))
							outsideList.add(insideList);
						if (b < c)
							b++;
						else
							break;

					}
					if (nums[a] + nums[b] + nums[c] + nums[d] < target) {
						if (b < c)
							b++;
						else
							break;

					}
					if (nums[a] + nums[b] + nums[c] + nums[d] > target) {
						if (c > b)
							c--;
						else
							break;
					}
				}
			}
		}
		return outsideList;
	}
}
