package com.ly.test;

public class Leet292 {
	public boolean canWinNim(int n) {
		//ʱ�临�Ӷȣ�O��1��
		//�ο����Ϸ���д����
		//��������Ϸ ��ֻҪ1-3��ʯͷ�����������һ��ȡ����ʤ����
		//4��ʯͷʱ��һ�����䡣5��ʱ��ȡ1�ţ��öԷ��䡣6��ʱ��ȡ2�ţ�7��ȡ3��
		if (n % 4 == 0)
			return false;
		else
			return true;
	}
}
