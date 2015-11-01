package solution;

import java.util.LinkedList;
import java.util.Queue;

public class Solution225 {
	class MyStack {
		//��ѭ���ķ����ö���ʵ��ջ
		public Queue<Integer> q = new LinkedList<Integer>();
		public int count = 0;
		
	    // Push element x onto stack.
	    public void push(int x) {
	        q.offer(x);
	        count++;
	    }
	    //���ν���������count-1��Ԫ���ó��ٷŵ����е�ĩ��
	    //�����һ��Ԫ���Ƴ���count-1
	    // Removes the element on top of the stack.
	    public void pop() {
	        for(int i = 0 ;i<count-1;i++){
	        	int temp =q.poll();
	        	q.offer(temp);
	        }
	        q.remove();
	        count--;
	    }
	    //���ν���������count-1��Ԫ���ó��ٷŵ����е�ĩ��
	    //�õ����һ��Ԫ�ص�ֵ��������ŵ�����ĩ�ˣ����ֶ���ԭ��˳�򣬲����ظ�ֵ
	    // Get the top element.
	    public int top() {
	    	int temp;
	    	for(int i = 0 ;i<count-1;i++){
	        	temp=q.poll();
	        	q.offer(temp);
	        }
	    	int a=q.peek();
	    	temp=q.poll();
	    	q.offer(temp);
	        return a;
	        
	    }

	    // Return whether the stack is empty.
	    public boolean empty() {
	    	if(count==0){
	    		return true;
	    	}else{
	    		return false;
	    	}
	        
	    }
	}
}
