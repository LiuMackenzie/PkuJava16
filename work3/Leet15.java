package com.ly.test;

import java.util.ArrayList;
import java.util.List;

public class Leet15 {


	public static List<List<Integer>> threeSum(int[] nums) {
		// ʱ�临�Ӷ�O��n^2��
		// 1.�Ƚ�������������
		// 2.forѭ���ڴ����ұ�������������Ԫ��Ϊa,b�Ǵ�a+1�ĵ㿪ʼ��c����������һ��Ԫ�ء�
		// 3.���������Ѿ���С�������кã���˵�nums[a] + nums[b] + nums[c] < 0ʱb�����ƶ�һ��Ԫ�أ�
		// ��nums[a] + nums[b] + nums[c] < 0ʱc�����ƶ�һ��Ԫ��
		// 4.�ر�ע�⣺��Ҫ���ǲ��������л���ظ������֣������5��-15��Ҫ���ж��Ƿ����ù���������ˣ�����ᳬʱ��
		// 5.���ܳ��֡�0��0��0�����ֽ���������ڵ��Ĳ�ʱ�ظ����0����������
		List<Integer> insideList;
		List<Integer> numList = new ArrayList<Integer>();
		List<List<Integer>> outsideList = new ArrayList<List<Integer>>();
		if (nums.length < 3)
			return outsideList;
		// ð�����򣨴�С����
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
			// ��0������ظ�Ԫ�ز����ǣ�����ʱ��ͨ����
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
