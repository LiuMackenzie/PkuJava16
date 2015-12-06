package solution;

public class Solution235 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	//��֪����һ������������
    	//��������ڵ��ֵ��С�ڸ��ڵ��ֵ����ô���ǵĹ�ͬ���ڵ�һ�����ڸ��ڵ����������
    	//ͬ����������ڸ��ڵ㣬���ǵĹ�ͬ���ڵ���ڸ��ڵ����������
    	//��ȥ�����������֮�⣬��������ڵ��ֵһ���ȸ��ڵ��һ���ȸ��ڵ�С��˵���������ڵ�һ���ڸ��ڵ����������������
    	//����һ�����
    	//��ĳ���ڵ���ڸ��ڵ��ֵ��˵������ڵ���ǹ�ͬ�ĸ��ڵ㣬Ҳ����ֱ�ӷ��ظ��ڵ��ֵ
        TreeNode tn = root;
        if(p.val<root.val && q.val<root.val){
        	return lowestCommonAncestor(root.left, p, q);
        }else
        if(p.val>root.val && q.val>root.val){
        	return lowestCommonAncestor(root.right, p, q);
        }else
        return tn;
    }
}
