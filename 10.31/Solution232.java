package solution;

import java.util.Stack;

public class Solution232 {
	//ʹ������ջ��ʵ�ֶ���
	
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();
	private int index1 = -1;
	//private int index2 = -1;
	
    // Push element x to the back of queue.
    public void push(int x) {
        s1.push(x);
        index1++;
    }
    //popʱ����Ҫ�����ִ�s1�Ƶ�s2�����ó�s1ջ�����һ��Ԫ��
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
    //peekʱ����Ҫ������ȫ����s1�Ƶ�s2�����ó�s2ջ���������Ԫ��
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
