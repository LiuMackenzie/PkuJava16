package solution;

import java.util.ArrayList;
import java.util.List;

import solution.Solution144.TreeNode;

public class Solution94 {
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) 
		 { 
			 val = x; 
	     }
	}
    public List<Integer> inorderTraversal(TreeNode root) {
    	//有了前序遍历，中序遍历就比较清晰了，还是需要用栈来记录遍历的节点
    	//需要压入栈的内容，就是暂时扫描到，但不需要加入list中的节点.
    	//循环中，如果左孩子存在，就将其入栈，如果不存在，就输出栈顶的节点，再开始让右孩子入栈（若存在）
        List<Integer> li = new ArrayList<Integer>();
        TreeNode[] tn = new TreeNode[200];
    	int temp = -1 ;
    	TreeNode node;
    	if(root!=null){
    		node = root;
    		while(temp>-1 || node!=null){
    			while(node!=null){
    				temp = temp+1;
    				tn[temp]=node;
    				node = node.left;
    			}
    			if(temp!=-1){
    				node = tn[temp];
    				temp--;
    				li.add(node.val);
    				node = node.right;
    			}
    		}
    	}
        return li;
    }
	
}
