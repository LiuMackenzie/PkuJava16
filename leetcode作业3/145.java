/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) { 
        //后序：左 右 根
        List<Integer> list=new ArrayList<Integer>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode node=root;
        while(root!=null){
        //左子树入栈,直到没有左孩子的节点之前。
        while(root.left!=null)
        {
           stack.push(root);   //把左孩子一次压入栈
            root=root.left;
        }
        //如果当前节点的右子树为null 或 右子树已经遍历过了，则把当前点加入list
        while(root!=null&&(root.right==null||root.right==node))
        {
            list.add(root.val); //如果该节点没有右子树or右子树已经加入到list了，则把该点加入list
            node=root;  //记录已经遍历过的节点
            if(stack.empty())   //如果栈中元素为空，说明已经遍历完全部，当前root为根，已经遍历完了，则返回list，结束
	            		return list;;
            root=stack.pop();//继续从栈中取出元素进行遍历。
        }
        //把没有左孩子 但是有右孩子 的节点压入
        stack.push(root);
        root=root.right;
        }
        return list;
    }
}