package com.ly.test;

import java.util.ArrayList;
import java.util.List;

public class Leet118 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generate(4);

	}

	static public List<List<Integer>> generate(int numRows) {
		// 时间复杂度是O（n^2）
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> smallRes = null;
		// 先初始化特殊的1
		if (numRows == 1) {
			smallRes = new ArrayList<Integer>();
			smallRes.add(1);
			res.add(smallRes);
			return res;
		} else {
			smallRes = new ArrayList<Integer>();

			// 大循环内填充List<List<Integer>> res
			for (int i = 1; i <= numRows; i++) {
				// 小循环内填充List<Integer> smallRes
				smallRes = new ArrayList<Integer>();
				for (int j = 0; j < i; j++) {
					// // 取出来res内上一级的内容

					if (j == 0 || j == i - 1) {
						smallRes.add(1);
					} else {
						// 这里错写过j-1
						List<Integer> last = res.get(i - 2);
						System.out.println(last.toString());
						Integer count = 0;
						int a = last.get(j - 1);
						System.out.println("---i" + i);
						System.out.println("--j--" + j);
						int b = last.get(j);
						count = a + b;
						System.out.println(" " + count + " ");
						smallRes.add(count);
					}
				}

				System.out.println("-------------");
				res.add(smallRes);
			}
		}
		return res;

	}
}
