package solution;

import java.util.ArrayList;
import java.util.List;

import solution.Solution144.TreeNode;

public class Solution145 {
	public List<Integer> postorderTraversal(TreeNode root) {
		//一开始想太简单了。。。以为是前序遍历倒过来就是后序遍历了。。。。。
		/*List<Integer> li = new ArrayList<Integer>();
    	TreeNode[] tn = new TreeNode[200];
    	int temp = -1 ;
    	TreeNode node;
    	if(root!=null){
    		temp = temp+1;
    		tn[temp]=root;
    		while(temp!=-1){
    			node = tn[temp--];
    			li.add(node.val);
    			if(node.left!=null){
    				temp = temp+1;
    				tn[temp]=node.left;
    			}
    			if(node.right!=null){
    				temp = temp+1;
    				tn[temp]=node.right;
    			}
    		}
    	}
    	return li;
		*/
		//因为后续遍历是先输出左右节点，再输出左右结点的父节点，所以需要跟踪右节点，看它下面有没有新的左右结点
		
		List<Integer> li = new ArrayList<Integer>();
		TreeNode[] tn = new TreeNode[100];
		TreeNode node = root;
		if(node == null){
			return li;
		}
		int i=-1;
		TreeNode lastNode = null;
		while(node!=null || i>-1){
			while(node!=null){
				i++;
				tn[i]=node;
				node = node.left;
			}
			node = tn[i];
			//如果右节点为空，或者lastNode已经记录过右节点，那么就将其输出
			if(node.right == null || node.right==lastNode){
				li.add(node.val);
				i--;
				lastNode = node;
				node = null;
			}else{
				node = node.right;
			}
		}
		
    return li;
	}
}
