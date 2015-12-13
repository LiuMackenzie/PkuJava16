package com.ly.test;

public class Leet226 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode invertTree(TreeNode root) {
		// 在递归先序遍历树的基础上进行扩展；
		// 每次递归到新的父节点时，交换其左右节点即可
		// 时间复杂度O(n)
		TreeNode temp;
		if (root != null) {
			temp = root.left;
			root.left = root.right;
			root.right = temp;
			invertTree(root.left);
			invertTree(root.right);

		}
		return root;
	}

	public static void main(String[] args) {
	}
}
