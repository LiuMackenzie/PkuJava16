package solution;

public class Solution110 {
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
    public boolean isBalanced(TreeNode root) {
        if(root==null){
        	return true;
        }
        if(root.left==null && root.right==null){  
            return true;  
        }
        //如果左子树和右子树的高度差大于一时，就返回false
    	if(Math.abs(height(root.left))-Math.abs(height(root.right))>1){
    		return false;
    	}
        return isBalanced(root.left) && isBalanced(root.right);
    }
    //通过height函数来递归计算某一个节点的高度
    private int height(TreeNode tn){
    	if(tn==null){
    		return 0;
    	}else{
    		return (height(tn.left)>height(tn.right)?height(tn.left):height(tn.right)) +1;
    	}
    }
}
