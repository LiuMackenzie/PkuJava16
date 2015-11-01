package solution;

import java.util.ArrayList;
import java.util.List;

public class Solution155 {

	class MinStack {
		private int i=-1;  //作为栈存储的List索引
		private int minNum = -1;  //用来存储最小值索引的list索引
		private int min = Integer.MAX_VALUE; //最小整数
		private List<Integer> list = new ArrayList<Integer>();  //作为栈存储的List
		private List<Integer> minlist = new ArrayList<Integer>();  //用来存储最小值索引的list
		//向存储数据的list中添加x，若x比min小，将x赋给min，并将x在list中的索引作为元素存入minlist
	    public void push(int x) {
	    	i++;
	    	list.add(x);
	    	if(x<min){
	    		min=x;
	    		//minNum=i;
	    		minNum++;
	    		minlist.add(i);
	    	}
	    }
	    //当存最小值索引的数组中最上面的一个元素等于要被pop出去的元素的索引时，相当于当前列表中最小的一个值被pop出，所以要将
	    //minlist中最上面一个元素拿出，并将min的值设为最上面一个元素，也就是list索引对应的值。之后再将list中最上面的元素拿出
	    //若两个list都为空时，将min设为Integer.MAX_VALUE
	    public void pop() {
	    	//i--;
	    	if(i>-1){
	    		if(minlist.get(minNum)==i){
		    		minlist.remove(minNum);
		    		minNum--;
		    		if(minNum!=-1){
		    		    min=list.get(minlist.get(minNum));
		    		}
	    		}
		    	list.remove(i);
		    	i--;
		    	//min=list.get(minlist.get(i));
		    	if(i==-1){
		    		min=Integer.MAX_VALUE;
		    	}
	    	}
	    }
	    
	    public int top() {
	        return list.get(i);
	    }
	    
	    /*public int getMin() {
	        int min = Integer.MAX_VALUE;
	        for(int j = 0 ; j<i; j++){
	        	if(list.get(j)<min){
	        		min=list.get(j);
	        	}
	        }
	        return min;
	        
	    }*/
	    public int getMin(){
	        if(minNum==-1){
	            return Integer.MAX_VALUE;
	        }else{
	    	    return list.get(minlist.get(minNum));
	        }
	    }
	}
}
