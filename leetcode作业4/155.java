class MinStack {
    
        //��listģ��stack��add\remove��Ӧpush\pop,
        //��Minʱ����Ҫ��ͷ��β����һ�飬ʱ�临�Ӷ�O(n)
    
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
