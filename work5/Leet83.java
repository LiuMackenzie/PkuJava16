package com.ly.test;

public class Leet83 {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public class Solution {
		//ʱ�临�Ӷȣ�O��n��
		//�������ת��Ϊһ��������ȥ��ĳ��Ԫ�أ���Ҫ��ָ���ָ���޸��Լ�����ĩβԪ���ظ�ʱ��ǰһ��Ԫ�ص�ָ���ÿռ���
		public ListNode deleteDuplicates(ListNode head) {
			ListNode first = head;
			if (head == null)
				return head;
			while (head.next != null) {
				// ��ͬ
				if (head.val == head.next.val) {
					if (head.next.next != null) {
						head.next = head.next.next;
					} else {
						head.next=null;
					}

				} else {
					// ��ͬ��ֱ�Ӹ�ֵ
					head = head.next;
				}
			}
			return first;

		}
	}
}
