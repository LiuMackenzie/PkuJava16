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
     //����������� ������ֻ��һ���ڵ����������ǶԳ���
    if(root==null||(root.left==null&&root.right==null))
        return true;
    
    //����Ǵ���������������Ҫ�ݹ��жϣ������Ƿ����
    return isMirror(root.left,root.right);
    }
    
    public boolean isMirror(TreeNode tree1,TreeNode tree2)
    {
        //��������Ϊ�գ���Գ�
        if(tree1==null&&tree2==null)
            return true;
        //��һ��Ϊ�գ����Գ�
        else if(tree1==null||tree2==null)
            return false;
        //����Ϊ�գ���Ƚ����ڵ��ֵ,������ȣ��򷵻�false
        if(tree1.val!=tree2.val)
            return false;
        else//����ȣ���Ҫ�����ݹ飬������������
            return isMirror(tree1.left,tree2.right)&&isMirror(tree1.right,tree2.left);
        
    }
    
}