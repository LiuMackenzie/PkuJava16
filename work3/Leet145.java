package com.ly.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leet145 {
	public List<Integer> preorderTraversal(TreeNode root) {
		// ʱ�临�Ӷȣ�O(n)
		//  1
		// / \
		// 2 3
		// ʹ������ջ��ɺ��������ջ1������ɵ�һ�α��������ڵ㰴1��3��2����������˳��浽ջ2��.
		// ��ջ2��ջ�������ó�������������
		Stack<TreeNode> temp1 = new Stack<TreeNode>();
		Stack<TreeNode> temp2 = new Stack<TreeNode>();
		List<Integer> resList = new ArrayList();
		if (root == null)
			return resList;
		temp1.push(root);
		while (temp1 != null) {
			root = temp1.pop();
			temp2.push(root);
			if (root.left != null)
				temp2.push(root.left);
			if (root.right != null)
				temp2.push(root.right);
		}
		while (temp2 != null) {
			root = temp2.pop();
			resList.add(root.val);
		}
		return resList;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
