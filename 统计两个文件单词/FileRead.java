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
		// ����HashSet���ڼ�¼�����ļ��ڷֱ��ظ��ĵ��ʶ���ʲô
		Set res1 = new TreeSet();
		Set res2 = new TreeSet();
		try {
			// �Ȱ������ļ���ȡ����
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

	// ��һ�� ����
	public static void findAll(Set set1, Set set2) {
		Set allSet = new TreeSet();
		allSet.addAll(set1);
		allSet.addAll(set2);
		Iterator allS = allSet.iterator();
		System.out.println("---------------------��һ��------------------------");
		System.out.println("���е��ʣ�");
		while (allS.hasNext()) {
			System.out.print(allS.next() + "  ");
		}
		System.out.println();

	}

	// �ڶ��� ����
	public static void alreadyExit(Set set1, Set set2) {
		Set mid = new TreeSet();
		int count1 = set1.size();
		int count2 = set2.size();
		// ��֤set1����
		if (set1.size() < set2.size()) {
			mid = set1;
			set1 = set2;
			set2 = mid;
		}
		Iterator it1 = set1.iterator();
		Iterator it2 = set2.iterator();
		String midString = new String();
		int count = 0;
		System.out.println("---------------------�ڶ���------------------------");
		System.out.println("ͬʱ���ֵĵ����У�");
		while (it2.hasNext()) {
			midString = it1.next().toString();
			if (midString.equals(it2.next())) {
				System.out.print(midString + " ");
				count++;
			}
		}

		System.out.println("---------------------������------------------------");
		System.out.println("��һ���ļ��ʻ�����" + count1 + "�����ʡ�");
		System.out.println("�ڶ����ļ��ʻ�����" + count2 + "�����ʡ�");
		
		double resCount1 = 1 - (double) count / (double) count1;
		double resCount2 = 1 - (double) count / (double) count2;
		System.out.println("��һ���ļ����У����ڶ����ļ���û�У�" + resCount1);
		System.out.println("�ڶ����ļ����У�����һ���ļ���û�У�" + resCount2);
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
