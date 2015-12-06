package solution;

public class Solution235 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	//已知这是一个二叉排序树
    	//如果两个节点的值都小于根节点的值，那么他们的共同父节点一定是在根节点的左子树上
    	//同理如果都大于根节点，他们的共同父节点就在根节点的左子树上
    	//除去以上两种情况之外，如果两个节点的值一个比根节点大一个比根节点小，说明这两个节点一定在根节点的左右两个子树上
    	//还有一种情况
    	//当某个节点等于根节点的值，说明这个节点就是共同的父节点，也可以直接返回根节点的值
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
