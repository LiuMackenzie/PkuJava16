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
        //��Ϊ��
        if(root == null) return 0;  
        //��ǰ��Ľڵ㼯��cur
        ArrayList<TreeNode> cur = new ArrayList<TreeNode>();  
        //�Ѹ����ӵ���ǰ��ڵ㼯��cur
        cur.add(root);  
        //��¼���
        int count =1;
        
        while(!cur.isEmpty()){  
            //��һ������Ľڵ㼯��next
            ArrayList<TreeNode> next = new ArrayList<TreeNode>();  
            //������ǰ���еĽڵ㣬����Ҷ�ӽڵ��򷵻����ֵcount��
            //�������򽫸ýڵ���뵽��һ������Ҫ�����Ľڵ㼯��next��
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