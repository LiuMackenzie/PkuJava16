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
    	//����ǰ���������������ͱȽ������ˣ�������Ҫ��ջ����¼�����Ľڵ�
    	//��Ҫѹ��ջ�����ݣ�������ʱɨ�赽��������Ҫ����list�еĽڵ�.
    	//ѭ���У�������Ӵ��ڣ��ͽ�����ջ����������ڣ������ջ���Ľڵ㣬�ٿ�ʼ���Һ�����ջ�������ڣ�
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
