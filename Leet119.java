package com.ly.test;

import java.util.ArrayList;
import java.util.List;

public class Leet119 {
	public static void main(String args[]) {
		System.out.println(getRow(2).toString());

	}

	static public List<Integer> getRow(int rowIndex) {
		// ʱ�临�Ӷ���O��n^2��
		List<Integer> list = new ArrayList<Integer>(rowIndex);
		if (rowIndex == 0) {

			list.add(1);
			return list;
		} else if (rowIndex == 1) {
			list.add(1);
			list.add(1);
			return list;

		}

		for (int i = 1; i <= rowIndex; i++) {
			list.add(1);
			for (int j = i - 1; j > 0; --j) {
				//ֻ�õ���һ�е����ݣ�set��add
				list.set(j, list.get(j) + list.get(j - 1));
			}
		}
		list.add(1);
		return list;
	}
}
