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
		//时间复杂度：O（n）
		//问题可以转换为一个链表内去除某个元素，主要是指针的指向修改以及考虑末尾元素重复时将前一个元素的指针置空即可
		public ListNode deleteDuplicates(ListNode head) {
			ListNode first = head;
			if (head == null)
				return head;
			while (head.next != null) {
				// 相同
				if (head.val == head.next.val) {
					if (head.next.next != null) {
						head.next = head.next.next;
					} else {
						head.next=null;
					}

				} else {
					// 不同，直接赋值
					head = head.next;
				}
			}
			return first;

		}
	}
}
