package com.ly.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leet144 {

	public List<Integer> preorderTraversal(TreeNode root) {
		// ʱ�临�Ӷȣ�O(n);
		// �ڲ�ʹ�õݹ��������������������ʹ��ջ���ȷ��Һ��ӽڵ���ջ�ٷ����ӽڵ���ջ��
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
