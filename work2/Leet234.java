package com.ly.test;

import java.awt.List;
import java.util.ArrayList;

public class Leet234 {
	public static void main(String args[]) {

	}

	public boolean isPalindrome(ListNode head) {

		// 方法一
		// 将输入一次遍历装入到ArrayList内，然后从两头遍历对比元素
		// 时间复杂度O（n）,空间复杂度O（n）

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
		//方法二 p.s参考网上C语言代码
		//设定快慢指针，得到中点后反转链表，再次一一比对元素。奇数个元素忽略最中间的元素
		// 时间复杂度O（n）,空间复杂度O（1）
		
		if (head == null || head.next == null)
			return true;
		// 获得中间指针start
		// 快慢指针设定
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
		// 获得中间指针end
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
			// 只有两个元素
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