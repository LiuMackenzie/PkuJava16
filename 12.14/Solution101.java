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
    //为了确定树是不是对称的，就要通过递归的方式比较左子节点的左子节点和右子节点的右子节点，
    //以及左子结点的右子结点和右子结点的左子结点
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
