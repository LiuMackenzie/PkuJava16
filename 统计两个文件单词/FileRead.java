package com.ly.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class FileRead {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 两个HashSet用于记录两个文件内分别不重复的单词都有什么
		Set res1 = new TreeSet();
		Set res2 = new TreeSet();
		try {
			// 先把两个文件读取出来
			Scanner fileInOne = new Scanner(new File("c:/work/first.txt"));
			Scanner fileInTwo = new Scanner(new File("c:/work/second.txt"));
			while (fileInOne.hasNext()) {
				String str = fileInOne.nextLine();
				res1 = splitt(str);
			}
			while (fileInTwo.hasNext()) {
				String str = fileInTwo.nextLine();
				res2 = splitt(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		findAll(res1, res2);
		alreadyExit(res1, res2);
	}

	// 第一问 并集
	public static void findAll(Set set1, Set set2) {
		Set allSet = new TreeSet();
		allSet.addAll(set1);
		allSet.addAll(set2);
		Iterator allS = allSet.iterator();
		System.out.println("---------------------第一问------------------------");
		System.out.println("所有单词：");
		while (allS.hasNext()) {
			System.out.print(allS.next() + "  ");
		}
		System.out.println();

	}

	// 第二问 交集
	public static void alreadyExit(Set set1, Set set2) {
		Set mid = new TreeSet();
		int count1 = set1.size();
		int count2 = set2.size();
		// 保证set1更长
		if (set1.size() < set2.size()) {
			mid = set1;
			set1 = set2;
			set2 = mid;
		}
		Iterator it1 = set1.iterator();
		Iterator it2 = set2.iterator();
		String midString = new String();
		int count = 0;
		System.out.println("---------------------第二问------------------------");
		System.out.println("同时出现的单词有：");
		while (it2.hasNext()) {
			midString = it1.next().toString();
			if (midString.equals(it2.next())) {
				System.out.print(midString + " ");
				count++;
			}
		}

		System.out.println("---------------------第三问------------------------");
		System.out.println("第一个文件词汇表包含" + count1 + "个单词。");
		System.out.println("第二个文件词汇表包含" + count2 + "个单词。");
		
		double resCount1 = 1 - (double) count / (double) count1;
		double resCount2 = 1 - (double) count / (double) count2;
		System.out.println("第一个文件中有，但第二个文件中没有：" + resCount1);
		System.out.println("第二个文件中有，但第一个文件中没有：" + resCount2);
	}

	public static Set splitt(String str) {
		// String str = str.trim();
		HashSet res = new HashSet();
		String[] strr = str.split("[\\p{Space}]+");
		int temp = 0;
		while (temp < strr.length) {
			res.add(strr[temp]);
			temp++;
		}
		return res;
	}
}
