package com.ly.test;

public class Leet151 {
	public static void main(String args[]) {
		String a = reverseWords("hello world!");
		System.out.println(a);
	}

	static public String reverseWords(String s) {
		//ʱ�临�ӶȽ��ΪO(n^2)
		// ""���벻��ͨ��
		if (s.length() <= 0) {
			s = new String();
			return s;
		}
		// ȫ���ǿո�Ĳ���ͨ����ȥ������ո�
		int end = s.length() - 1;
		int begin = 0;
		while (begin <= end && s.charAt(begin) == ' ') {
			begin++;
		}
		while (begin <= end && s.charAt(end) == ' ') {
			end--;
		}
		if (end < begin) {
			// System.out.println("---s-");
			 s = new String();

			return s;
		}
		// StringBuffer��֮Time Limit ����
		StringBuffer res = new StringBuffer();
		// // �м�洢
		String mid = new String();
		int n = end;
		while (n >= begin) {
			// �ַ����ڿո������
			int space = 0;
			if (s.charAt(n) == ' ') {
				int smallC = mid.length() - 1;
				while (smallC >= 0) {

					res = res.append(mid.charAt(smallC));
					smallC--;

				}
				if (mid.length() >= 1) {
					res.append(' ');
				}

				mid = new String();
			} else if (n == begin) {

				space = 0;
				mid = mid + s.charAt(n);
				int smallC = mid.length() - 1;
				while (smallC >= 0) {
					res = res.append(mid.charAt(smallC));
					smallC--;
				}
			} else {
				mid = mid + s.charAt(n);
			}
			n--;
		}
		return res.toString();
	}
	
}
