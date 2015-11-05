package com.ly.test;

public class Leet141 {
	public boolean hasCycle(ListNode head) {
		//  ±º‰∏¥‘”∂»£∫O£®n£© 
		ListNode fast = head;
		ListNode slow = head;
		while (true) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == null) {
				return false;
			}
			if (slow == fast) {
				return true;
			}
		}

	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
