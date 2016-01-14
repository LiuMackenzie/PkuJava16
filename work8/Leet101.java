package com.ly.test;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Leet101 {
	public boolean isSymmetric(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return true;
		if ((root.left == null && root.right != null)
				|| (root.left != null && root.right == null))
			return false;
		return isMirror(root.left, root.right);

	}

	public static boolean isMirror(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null && root2 != null)
			return false;
		if (root1 != null && root2 == null)
			return false;
		if (root1.val != root2.val)
			return false;
		return isMirror(root1.left, root2.right)
				&& isMirror(root1.right, root2.left);

	}
}
