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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       /*
        if((root.left==p || root.left==q)&&(root.right==p || root.right==q))
            return root;
        else if(root.left==p || root.left==q)
            return root.left;
        else if(root.right==p || root.right==q)
            return root.right;
        lowestCommonAncestor(root.left,p,q);
        lowestCommonAncestor(root.left,p,q);
        return root;
        */
        //要先搞懂BST二叉查找树
        //简单来说是大小关系是 左<根<右
        //分析：
        /*在二叉查找树种，寻找两个节点的最低公共祖先。
         1、如果p、q都比root小，则在左子树中递归查找公共节点。
         1、如果p、q都比root小，则在左子树中递归查找公共节点。
         3、如果p、q一个比root大，一个比root小，或者有一个等于root，则root为最低公共祖先。
        */
        
        if(root==null)
            return null;
        int min=(p.val<q.val?p.val:q.val);
        int max=(p.val<q.val?q.val:p.val);
        //1、如果p、q都比root小，则在左子树中递归查找公共节点。
        if(max<root.val)
            return lowestCommonAncestor(root.left,p,q);
        //2、如果p、q都比root小，则在左子树中递归查找公共节点。
        if(min>root.val)
            return lowestCommonAncestor(root.right,p,q);
        //3、如果p、q一个比root大，一个比root小，或者有一个等于root，则root为最低公共祖先。
        return root;
    }
}