class MinStack {
    
        //用list模拟stack，add\remove对应push\pop,
        //求Min时候，需要从头到尾遍历一遍，时间复杂度O(n)
    
 	    List<Integer> list=new ArrayList<Integer>();
 	  
	    public void push(int x) {
	        list.add(x);
	    }

	    public void pop() {
	        list.remove(list.size()-1);
	    }

	    public int top() {
	        return list.get(list.size()-1);
	    }

	    public int getMin() {
	       int Min=list.get(0);
	       for(int i=0;i<list.size();i++)
	       {
	           if(list.get(i)<Min){
	               Min=list.get(i);
	           }
	       }
			return Min;
	    }
}
