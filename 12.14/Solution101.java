package solution;

public class Solution101 {
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
        	return true;
        }else{
        	return compare(root.left,root.right);
        }
    }
    //Ϊ��ȷ�����ǲ��ǶԳƵģ���Ҫͨ���ݹ�ķ�ʽ�Ƚ����ӽڵ�����ӽڵ�����ӽڵ�����ӽڵ㣬
    //�Լ����ӽ������ӽ������ӽ������ӽ��
    private boolean compare(TreeNode left, TreeNode right){
    	if(left == null && right == null){
    		return true;
    	}else if(left != null && right == null || left == null && right != null){
    		return false;
    	}else{
    		return left.val == right.val && compare(left.left, right.right) && compare(left.right, right.left);
    	}
    		
    	
    }
}
