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
		// 时间复杂度:O(N^2)
		// 使用队列将按层遍历。
		// 1
		// / \
		// 2 3
		// 参考 ：102题Binary Tree Level Order Traversal
		// 1存到第一个队列cur中，将1的子节点放到队列sub内，结束对1子节点存储后，交换cur和sub。
		// 开始遍历第二层元素，并将他的子节点放入sub内.每次进行cur和sub的交换表示遍历更深一层，flag++。
		// 当某个节点无子节点时，返回flag。
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