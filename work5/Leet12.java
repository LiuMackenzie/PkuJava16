package com.ly.test;

public class Leet12 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(intToRoman(3999));
	}

	static public String intToRoman(int num) {
		// ��һ��
		// String[] geNum = { "", "I", "II", "III", "IV", "V", "VI", "VII",
		// "VIII", "IX" };
		// String[] shiNum = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX",
		// "LXXX", "XC" };
		// String[] hundredNum = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC",
		// "DCCC", "CM" };
		// String[] thousandNum = { "", "M", "MM", "MMM" };
		// int ge = num % 10;
		// num = num / 10;
		// int shi = num % 10;
		// num = num / 10;
		// int hundred = num % 10;
		// num = num / 10;
		// int thousand = num % 10;
		// String res = new String();
		// System.out.println(thousand);
		// if (thousand >= 0) {
		// res = thousandNum[thousand] + hundredNum[hundred] + shiNum[shi]
		// + geNum[ge];
		// } else if (hundred >= 0) {
		// res = hundredNum[hundred] + shiNum[shi] + geNum[ge];
		// } else if (shi >= 0) {
		// res = shiNum[shi] + geNum[ge];
		// } else {
		// res = geNum[ge];
		// }
		// return res;
		// �ڶ��� ʱ�临�Ӷȣ���ѭ��������ΪO(1)
		int ge, shi, hundred, thousand;
		String[] geNum = { "", "I", "II", "III", "IV", "V", "VI", "VII",
				"VIII", "IX" };
		String[] shiNum = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX",
				"LXXX", "XC" };
		String[] hundredNum = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC",
				"DCCC", "CM" };
		String[] thousandNum = { "", "M", "MM", "MMM" };
		String res = new String();
		// ��λ
		ge = num % 10;
		num = num / 10;
		res = geNum[ge];
		// ʮλ
		shi = num % 10;
		if (shi < 0)
			return res;
		num = num / 10;
		res = shiNum[shi] + res;
		// ��λ
		hundred = num % 10;
		if (hundred < 0)
			return res;
		num = num / 10;
		res = hundredNum[hundred] + res;
		// ǧλ
		thousand = num % 10;
		if (thousand < 0)
			return res;
		res = thousandNum[thousand] + res;
		return res;

	}
}
