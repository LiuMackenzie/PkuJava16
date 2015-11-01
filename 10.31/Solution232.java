package solution;

import java.util.Stack;

public class Solution232 {
	//使用两个栈来实现队列
	
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();
	private int index1 = -1;
	//private int index2 = -1;
	
    // Push element x to the back of queue.
    public void push(int x) {
        s1.push(x);
        index1++;
    }
    //pop时，需要将数字从s1移到s2，再拿出s1栈中最后一个元素
    // Removes the element from in front of queue.
    public void pop() {
        for(int i=0;i<index1;i++){
        	s2.push(s1.pop());
        	//index2++;
        }
        s1.pop();
        index1--;
        for(int j=0;j<=index1;j++){
        	s1.push(s2.pop());
        	//index2--;
        }
    }
    //peek时，需要将数字全部从s1移到s2，再拿出s2栈中最后上面元素
    // Get the front element.
    public int peek() {
    	for(int i=0;i<=index1;i++){
        	s2.push(s1.pop());
        	//index2++;
        }
    	int res = s2.peek();
    	for(int j=0;j<=index1;j++){
        	s1.push(s2.pop());
        	//index2--;
        }
    	return res;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        if(index1==-1){
        	return true;
        }else{
        	return false;
        }
    }
}
