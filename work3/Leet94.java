package com.ly.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.ly.test.Leet145.TreeNode;

public class Leet94 {
	public List<Integer> inorderTraversal(TreeNode root) {
		// 时间复杂度O（n^2）
		// 将某节点入栈后，先将他的左孩
		// 1.先将树内最左侧的分支存到栈内，再将右节点付给root。
		// 2.重复第一步，直到栈空。
		Stack<TreeNode> temp = new Stack<TreeNode>();
		List<Integer> resList = new ArrayList();
		if (root == null)
			return resList;
		while (!temp.empty() || root != null) {
			while (root != null) {
				temp.push(root);
				root = root.left;
			}
			root = temp.pop();
			resList.add(root.val);
			root = root.right;
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
