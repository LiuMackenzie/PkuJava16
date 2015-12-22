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
    public boolean isSymmetric(TreeNode root) {
        /*
        if(root==null)
        {
            return true;
        }
        
        if(root.left.right==null)
        
        if(root.left.right==root.right.left&&root.left.left==root.right.right)
        {
            if(isSymmetric(root.left)&&isSymmetric(root.right))
            {
                return true;
            }
        }
        else
        {
            return false;
        }
        
        return true;
     */
     //考虑特殊情况 空树、只有一个节点的情况，均是对称树
    if(root==null||(root.left==null&&root.right==null))
        return true;
    
    //如果是存在左右子树，则要递归判断，两边是否相等
    return isMirror(root.left,root.right);
    }
    
    public boolean isMirror(TreeNode tree1,TreeNode tree2)
    {
        //两个树均为空，则对称
        if(tree1==null&&tree2==null)
            return true;
        //有一个为空，不对称
        else if(tree1==null||tree2==null)
            return false;
        //均不为空，则比较两节点的值,若不相等，则返回false
        if(tree1.val!=tree2.val)
            return false;
        else//若相等，则要继续递归，他的左右子树
            return isMirror(tree1.left,tree2.right)&&isMirror(tree1.right,tree2.left);
        
    }
    
}