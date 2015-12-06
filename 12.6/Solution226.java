package solution;

public class Solution226 {
	
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	 
    public TreeNode invertTree(TreeNode root){
    	//ʹ�����������ģ������������Ľ�������
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
