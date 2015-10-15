package com.ly.test;

import java.awt.List;
import java.util.ArrayList;

public class Leet234 {
	public static void main(String args[]) {

	}

	public boolean isPalindrome(ListNode head) {

		// ����һ
		// ������һ�α���װ�뵽ArrayList�ڣ�Ȼ�����ͷ�����Ա�Ԫ��
		// ʱ�临�Ӷ�O��n��,�ռ临�Ӷ�O��n��

		// if (head == null || head.next == null)
		// return true;
		// ArrayList comList = new ArrayList();
		// while (head != null) {
		// comList.add(head.val);
		// head = head.next;
		// }
		// for (int i = 0, j = comList.size(); i < j; i++, j--) {
		// if (comList.get(i).equals(comList.get(j)))
		// return false;
		// }
		// return true;
		//------------------------------------------------------------------------
		//������ p.s�ο�����C���Դ���
		//�趨����ָ�룬�õ��е��ת�����ٴ�һһ�ȶ�Ԫ�ء�������Ԫ�غ������м��Ԫ��
		// ʱ�临�Ӷ�O��n��,�ռ临�Ӷ�O��1��
		
		if (head == null || head.next == null)
			return true;
		// ����м�ָ��start
		// ����ָ���趨
		ListNode slow = head;
		ListNode fast = head;
		ListNode preslow = null;
		while (fast != null) {
			fast = fast.next;
			if (fast != null) {
				fast = fast.next;
				preslow = slow;
				slow = slow.next;
			}
		}
		preslow.next = null;
		// ����м�ָ��end
		ListNode head2 = reverse(slow);
		while (head != null && head2 != null) {
			if (head.val != head2.val)
				return false;
			head = head.next;
			head2 = head2.next;

		}
		return true;
	}

	public static ListNode reverse(ListNode slow) {
		if (slow == null || slow.next == null)
			return slow;
		else if (slow.next.next == null) {
			// ֻ������Ԫ��
			ListNode tail = slow.next;
			slow.next = null;
			tail.next = slow;
			return tail;
		} else {
			ListNode pre = slow;
			ListNode cur = pre.next;
			pre.next = null;
			ListNode post = cur.next;
			while (post != null) {
				cur.next = pre;
				pre = cur;
				cur = post;
				post = post.next;
			}
			cur.next = pre;
			return cur;
		}

	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}