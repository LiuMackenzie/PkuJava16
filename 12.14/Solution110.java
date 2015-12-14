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
        //������������������ĸ߶Ȳ����һʱ���ͷ���false
    	if(Math.abs(height(root.left))-Math.abs(height(root.right))>1){
    		return false;
    	}
        return isBalanced(root.left) && isBalanced(root.right);
    }
    //ͨ��height�������ݹ����ĳһ���ڵ�ĸ߶�
    private int height(TreeNode tn){
    	if(tn==null){
    		return 0;
    	}else{
    		return (height(tn.left)>height(tn.right)?height(tn.left):height(tn.right)) +1;
    	}
    }
}
