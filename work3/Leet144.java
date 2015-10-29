package com.ly.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leet144 {

	public List<Integer> preorderTraversal(TreeNode root) {
		// 时间复杂度：O(n);
		// 在不使用递归的条件下完成先序遍历，使用栈。先放右孩子节点入栈再放左孩子节点入栈。
		Stack<TreeNode> temp = new Stack<TreeNode>();
		List<Integer> resList = new ArrayList();
		if (root == null)
			return resList;
		temp.push(root);
		while (!temp.empty()) {
			root = temp.pop();
			resList.add(root.val);
			if (root.right != null) {
				temp.push(root.right);
			}
			if (root.left != null) {

				temp.push(root.left);
			}

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
