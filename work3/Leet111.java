package com.ly.test;

import java.util.LinkedList;
import java.util.List;

public class Leet111 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int minDepth(TreeNode root) {
		// ʱ�临�Ӷ�:O(N^2)
		// ʹ�ö��н����������
		// 1
		// / \
		// 2 3
		// �ο� ��102��Binary Tree Level Order Traversal
		// 1�浽��һ������cur�У���1���ӽڵ�ŵ�����sub�ڣ�������1�ӽڵ�洢�󣬽���cur��sub��
		// ��ʼ�����ڶ���Ԫ�أ����������ӽڵ����sub��.ÿ�ν���cur��sub�Ľ�����ʾ��������һ�㣬flag++��
		// ��ĳ���ڵ����ӽڵ�ʱ������flag��
		if (root == null) {
			return 0;
		}
		List<TreeNode> cur = new LinkedList<TreeNode>();
		List<TreeNode> sub = new LinkedList<TreeNode>();
		List<TreeNode> exc;
		TreeNode node;
		int flag = 1;
		cur.add(root);
		while (!cur.isEmpty()) {
			while (!cur.isEmpty()) {
				node = cur.remove(0);
				if (node.left != null) {
					sub.add(node.left);
				}
				if (node.right != null) {
					sub.add(node.right);
				}
				if (node.right == null && node.left == null) {
					return flag;
				}
			}
			exc = cur;
			cur = sub;
			sub = exc;
			flag++;

		}
		return 0;

	}

}