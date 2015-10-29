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
            //��������� ����->��->�Һ���
            //��������� ��->����->�Һ���
            //��������� ����->�Һ���->��
        
            List<Integer> list=new ArrayList<Integer>(); //��ŷ��ؽ�����б�
	        Stack<TreeNode> stack=new Stack<TreeNode>();//�½�һ��ջ��������Ŵ��ٴα����Ľڵ�
	        
	        //ֻ�е� ��ǰ�ڵ㲻�ǿ�&&ջ����û�д�������Ԫ�أ���˵����������������list��
	        while(!(root==null&&stack.size()==0)){
	            //��������
	            //�Ȱѱ����Ľڵ�ŵ�stack��Ȼ�����������������ֱ��������Ϊnull
	            while(root!=null){ 
	            	stack.push(root);
	                root=root.left;
	            }
                //��list�м������ӣ�����Ȼ������Һ���
                //���stack����Ԫ�أ��ҵ�ǰ�ڵ��ǿգ�
	            while(stack.size()>0&&root==null){
	                root=stack.pop();
	                list.add(root.val);
	                root=root.right;
	            }
	        }
	        return list;
    }
}