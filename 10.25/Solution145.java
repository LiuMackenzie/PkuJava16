package solution;

import java.util.ArrayList;
import java.util.List;

import solution.Solution144.TreeNode;

public class Solution145 {
	public List<Integer> postorderTraversal(TreeNode root) {
		//һ��ʼ��̫���ˡ�������Ϊ��ǰ��������������Ǻ�������ˡ���������
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
		//��Ϊ������������������ҽڵ㣬��������ҽ��ĸ��ڵ㣬������Ҫ�����ҽڵ㣬����������û���µ����ҽ��
		
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
			//����ҽڵ�Ϊ�գ�����lastNode�Ѿ���¼���ҽڵ㣬��ô�ͽ������
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
