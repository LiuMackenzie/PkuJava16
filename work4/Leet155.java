package com.ly.test;

import java.util.Stack;

public class Leet155 {
	// 超时
	// Stack sta = new Stack();
	// Stack sta2 = new Stack();
	// int min = -2147483648;
	//
	// public void push(int x) {
	// sta.push(x);
	// if (min == -2147483648) {
	// sta2.push(x);
	// min = x;
	// } else if (x < min) {
	// // x更小，x入栈，修改min值
	// sta2.push(x);
	// min = x;
	// } else {
	// sta2.push(min);
	// }
	// }
	//
	// public void pop() {
	// sta.pop();
	// sta2.pop();
	// }
	//
	// public int top() {
	// return Integer.parseInt(sta.peek().toString());
	//
	// }
	//
	// public int getMin() {
	// int x = 0;
	// while (!sta2.isEmpty()) {
	// x = Integer.parseInt(sta2.peek().toString());
	//
	// }
	// return x;

	Stack<Integer> sta = new Stack<Integer>();
	Stack<Integer> sta2 = new Stack<Integer>();

	public void push(int x) {
		if (sta2.isEmpty() || x <= sta2.peek()) {
			sta2.push(x);
		}
		sta.push(x);
	}

	public void pop() {
		if (sta.peek().equals(sta2.peek())) {
			sta2.pop();
		}
		sta.pop();
	}

	public int top() {
		return sta.peek();

	}

	public int getMin() {

		return sta2.peek();

	}
}
