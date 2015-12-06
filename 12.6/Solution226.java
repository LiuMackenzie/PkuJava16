package solution;

public class Solution226 {
	
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	 
    public TreeNode invertTree(TreeNode root){
    	//使用先序遍历的模板进行两子树的交换操作
    	TreeNode tn = root;
    	if(tn==null){
    		return null;
    	}
    	TreeNode temp;
    	if(tn!=null){
    		temp=tn.left;
    		tn.left=tn.right;
    		tn.right=temp;
    	}
    	invertTree(tn.left);
    	invertTree(tn.right);
    	return tn;
    }
}
