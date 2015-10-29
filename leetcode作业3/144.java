
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        //�����������������������stack��¼��������Ԫ�ء�����
        //���򣺸�->����->�Һ���
        
        List<Integer> list=new ArrayList<Integer>();//�淵�ؽ��
        Stack<TreeNode> stack=new Stack<TreeNode>();//���������Ԫ��
        
        while(!(stack.size()==0&&root==null)){
            //add������������
            while(root!=null){
                list.add(root.val);
                stack.push(root);
                root=root.left;
            }
            //��һ����stack��Ԫ�ص��Һ���
            while(stack.size()>0&&root==null)
            {
                root=stack.pop();
                root=root.right;
            }
        }
        return list;
    }
}