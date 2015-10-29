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
        //������ �� ��
        List<Integer> list=new ArrayList<Integer>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode node=root;
        while(root!=null){
        //��������ջ,ֱ��û�����ӵĽڵ�֮ǰ��
        while(root.left!=null)
        {
           stack.push(root);   //������һ��ѹ��ջ
            root=root.left;
        }
        //�����ǰ�ڵ��������Ϊnull �� �������Ѿ��������ˣ���ѵ�ǰ�����list
        while(root!=null&&(root.right==null||root.right==node))
        {
            list.add(root.val); //����ýڵ�û��������or�������Ѿ����뵽list�ˣ���Ѹõ����list
            node=root;  //��¼�Ѿ��������Ľڵ�
            if(stack.empty())   //���ջ��Ԫ��Ϊ�գ�˵���Ѿ�������ȫ������ǰrootΪ�����Ѿ��������ˣ��򷵻�list������
	            		return list;;
            root=stack.pop();//������ջ��ȡ��Ԫ�ؽ��б�����
        }
        //��û������ �������Һ��� �Ľڵ�ѹ��
        stack.push(root);
        root=root.right;
        }
        return list;
    }
}