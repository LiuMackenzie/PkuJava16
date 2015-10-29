package com.ly.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.ly.test.Leet145.TreeNode;

public class Leet94 {
	public List<Integer> inorderTraversal(TreeNode root) {
		// ʱ�临�Ӷ�O��n^2��
		// ��ĳ�ڵ���ջ���Ƚ�������
		// 1.�Ƚ����������ķ�֧�浽ջ�ڣ��ٽ��ҽڵ㸶��root��
		// 2.�ظ���һ����ֱ��ջ�ա�
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
