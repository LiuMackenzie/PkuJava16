package solution;

import java.util.ArrayList;
import java.util.List;

public class Solution144 {
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) 
		 { 
			 val = x; 
	     }
	}
    public List<Integer> preorderTraversal(TreeNode root) {
    	//��ʼ˼·��������˲�α�����������
        /*int count = 100;
        List<Integer> li = new ArrayList<Integer>();
        TreeNode tn = root;
    	TreeNode[] a = new TreeNode[count];
    	int front = 0;
    	int end = 1;
    	int i = 0;
    	a[i]=tn;
    	i++;
    	while(front != end){
    		if(tn.left==null){
    			front++;
    			li.add(tn.val);
    			if(tn.right!=null){
    				tn=tn.right;
    			}else{
    				//front++;
    				li.add(a[front].val);
    			}
    			
    		}else{
    			a[i]=tn;
    			i++;
    			end++;
    			if(tn.right!=null){
    				a[i]=tn.right;
    				i++;
    				end++;
    			}
    			li.add(tn.val);
    			front++;
    			tn= tn.left ;
    		}	
    	}
        return li;*/

    	/*List<Integer> li = new ArrayList<Integer>();
    	if(root==null){
    		return li;
    	}
    	int count = 100;
    	TreeNode[] tnode = new TreeNode[count];
    	int i = 1;
    	tnode[0]=root;
    	int front = 0;
    	int end = 1;
    	TreeNode tn = root;
    	while(front<end){
    		if(tn.left!=null){
    			tnode[i]=tn.left;
    			i++;
    			end++;
    			if(tn.right!=null){
    				tnode[i]=tn.right;
    				i++;
    				end++;
    			}
    			li.add(tn.val);
    			front++;
    			tn=tnode[front];
    		}
    		if(tn.left==null){
    			if(tn.right==null){
    				li.add(tn.val);
    				front++;
    				tn = tnode[front];
    			}else{
    				tnode[i]=tn.right;
    				i++;
    				end++;
    				li.add(tn.val);
    				front++;
    				tn = tnode[front];
    			}
    		}
    	}
    	return li;*/
    	//����һ��ջ����¼��������
    	//�ȼ�¼��ʼ�ڵ㣬Ȼ���ջ�����������Һ��ӣ����ֽ��Һ���ѹ��ջ�У���Ϊ������������������Һ��������棬���������档
    	//���������Ļ����ȳ�ջ�������ӡ�
    	//���ڵ�ΪҶ�ӽڵ������ջ��
    	List<Integer> li = new ArrayList<Integer>();
    	TreeNode[] tn = new TreeNode[200];
    	int temp = -1 ;
    	TreeNode node;
    	if(root!=null){
    		temp = temp+1;
    		tn[temp]=root;
    		while(temp!=-1){
    			node = tn[temp--];
    			li.add(node.val);
    			if(node.right!=null){
    				temp = temp+1;
    				tn[temp]=node.right;
    			}
    			if(node.left!=null){
    				temp = temp+1;
    				tn[temp]=node.left;
    			}
    		}
    	}
    	return li;
    }
}












