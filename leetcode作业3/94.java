/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.lang.*;
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
            //中序遍历： 左孩子->根->右孩子
            //先序遍历： 根->左孩子->右孩子
            //后序遍历： 左孩子->右孩子->根
        
            List<Integer> list=new ArrayList<Integer>(); //存放返回结果的列表
	        Stack<TreeNode> stack=new Stack<TreeNode>();//新建一个栈，用来存放待再次遍历的节点
	        
	        //只有当 当前节点不是空&&栈里面没有待遍历的元素，才说明遍历结束，返回list表
	        while(!(root==null&&stack.size()==0)){
	            //遍历左孩子
	            //先把遍历的节点放到stack，然后继续遍历左子树，直至左子树为null
	            while(root!=null){ 
	            	stack.push(root);
	                root=root.left;
	            }
                //在list中加上左孩子，根，然后遍历右孩子
                //如果stack中有元素，且当前节点是空！
	            while(stack.size()>0&&root==null){
	                root=stack.pop();
	                list.add(root.val);
	                root=root.right;
	            }
	        }
	        return list;
    }
}