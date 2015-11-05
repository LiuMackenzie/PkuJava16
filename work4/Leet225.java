package com.ly.test;

import java.util.ArrayDeque;
import java.util.Queue;

public class Leet225 {
	// ʹ���������У�queue2�����ò������ǰ���queue1ȡ������Ԫ�ء�queue2��queue1��������ݣ���ÿ�γ�ջʱ�򽻻���
	Queue queue1 = new ArrayDeque();
	Queue queue2 = new ArrayDeque();

	// Push element x onto stack.
	public void push(int x) {
		if (queue1.isEmpty() && queue2.isEmpty()) {
			queue1.add(x);
		} else if (!queue1.isEmpty()) {
			queue1.add(x);
		} else if (!queue2.isEmpty()) {
			queue2.add(x);
		}
	}

	// Removes the element on top of the stack.
	public void pop() {
		int size = 0;
		if (!queue1.isEmpty()) {
			size = queue1.size() - 1;
			for (int i = 0; i < size; i++)
			// ����queue1��ѭ�����ڻ���remove���������queue1�ĳ��Ȼ�ı䡣��ѭ�������޶�ʱ������ֱ����queue1.size()
			// for (int i = 0; i < queue1.size()-1; i++)
			{
				queue2.add(queue1.remove());
			}
			queue1.remove();
		} else if (!queue2.isEmpty()) {
			size = queue2.size() - 1;
			for (int i = 0; i < size; i++)
			// for (int i = 0; i < queue2.size()-1; i++)
			{
				queue1.add(queue2.remove());
			}
			queue2.remove();
		}
	}

	// Get the top element.
	public int top() {
		int x = 0;
		if (!queue1.isEmpty()) {
			while (!queue1.isEmpty()) {
				x = Integer.parseInt(queue1.peek().toString());
				queue2.add(queue1.remove());
			}
		} else if (!queue2.isEmpty()) {
			while (!queue2.isEmpty()) {
				x = Integer.parseInt(queue2.peek().toString());
				queue1.add(queue2.remove());
			}
		}
		return x;
	}

	// Return whether the stack is empty.
	public boolean empty() {
		if (queue1.isEmpty() && queue2.isEmpty())
			return true;
		else
			return false;
	}
}
