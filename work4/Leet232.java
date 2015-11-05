package com.ly.test;

import java.util.Stack;

public class Leet232 {
	// ʹ������ջ��ջ2������ʹ�ã���ֹ��ʱ��
	Stack stack1 = new Stack();
	Stack stack2 = new Stack();

	// Push element x to the back of queue.
	public void push(int x) {
		stack1.push(x);

	}

	// Removes the element from in front of queue.
	public void pop() {

		if (!stack2.isEmpty()) {
			stack2.pop();
		} else {
			// С�Ż�������stack1��ȫ���ŵ�stack2�ڣ����µ����һ����ֱ��pop
			for (int i = 0; i < stack1.size() - 1; i++) {
				stack2.push(stack1.pop());
			}
			stack1.pop();
		}
	}

	// Get the front element.
	public int peek() {
		int x = 0;
		if (!stack2.isEmpty()) {
			x = Integer.parseInt(stack2.peek().toString());
		} else {
			for (int i = 0; i < stack1.size(); i++) {
				x = Integer.parseInt(stack1.peek().toString());
			}
		}
		return x;

	}

	// Return whether the queue is empty.
	public boolean empty() {
		// System.out.println(stack1.size());
		if (stack1.isEmpty())
			return true;
		else
			return false;

	}
}
