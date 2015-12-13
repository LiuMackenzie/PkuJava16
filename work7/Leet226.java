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
		// �ڵݹ�����������Ļ����Ͻ�����չ��
		// ÿ�εݹ鵽�µĸ��ڵ�ʱ�����������ҽڵ㼴��
		// ʱ�临�Ӷ�O(n)
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
