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
        //Ҫ�ȸ㶮BST���������
        //����˵�Ǵ�С��ϵ�� ��<��<��
        //������
        /*�ڶ���������֣�Ѱ�������ڵ����͹������ȡ�
         1�����p��q����rootС�������������еݹ���ҹ����ڵ㡣
         1�����p��q����rootС�������������еݹ���ҹ����ڵ㡣
         3�����p��qһ����root��һ����rootС��������һ������root����rootΪ��͹������ȡ�
        */
        
        if(root==null)
            return null;
        int min=(p.val<q.val?p.val:q.val);
        int max=(p.val<q.val?q.val:p.val);
        //1�����p��q����rootС�������������еݹ���ҹ����ڵ㡣
        if(max<root.val)
            return lowestCommonAncestor(root.left,p,q);
        //2�����p��q����rootС�������������еݹ���ҹ����ڵ㡣
        if(min>root.val)
            return lowestCommonAncestor(root.right,p,q);
        //3�����p��qһ����root��һ����rootС��������һ������root����rootΪ��͹������ȡ�
        return root;
    }
}