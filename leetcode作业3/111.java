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
    public int minDepth(TreeNode root) {
        //树为空
        if(root == null) return 0;  
        //当前层的节点集合cur
        ArrayList<TreeNode> cur = new ArrayList<TreeNode>();  
        //把根结点加到当前层节点集合cur
        cur.add(root);  
        //记录深度
        int count =1;
        
        while(!cur.isEmpty()){  
            //下一层遍历的节点集合next
            ArrayList<TreeNode> next = new ArrayList<TreeNode>();  
            //遍历当前层中的节点，若是叶子节点则返回深度值count，
            //若不是则将该节点加入到下一层中需要遍历的节点集合next中
            for (TreeNode treeNode : cur) {  
                if(treeNode.left == null && treeNode.right == null) return count;  
                if(treeNode.left != null) next.add(treeNode.left);  
                if(treeNode.right != null) next.add(treeNode.right);  
            }  
            count++;  
            cur = next;  
        }  
        return count;  
    }
}