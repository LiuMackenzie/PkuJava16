package solution;

import java.util.LinkedList;
import java.util.Queue;

public class Solution225 {
	class MyStack {
		//用循环的方法用队列实现栈
		public Queue<Integer> q = new LinkedList<Integer>();
		public int count = 0;
		
	    // Push element x onto stack.
	    public void push(int x) {
	        q.offer(x);
	        count++;
	    }
	    //依次将将队列中count-1个元素拿出再放到队列的末端
	    //将最后一个元素移除，count-1
	    // Removes the element on top of the stack.
	    public void pop() {
	        for(int i = 0 ;i<count-1;i++){
	        	int temp =q.poll();
	        	q.offer(temp);
	        }
	        q.remove();
	        count--;
	    }
	    //依次将将队列中count-1个元素拿出再放到队列的末端
	    //得到最后一个元素的值，并将其放到队列末端，保持队列原有顺序，并返回该值
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
