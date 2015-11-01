package solution;

import java.util.ArrayList;
import java.util.List;

public class Solution155 {

	class MinStack {
		private int i=-1;  //��Ϊջ�洢��List����
		private int minNum = -1;  //�����洢��Сֵ������list����
		private int min = Integer.MAX_VALUE; //��С����
		private List<Integer> list = new ArrayList<Integer>();  //��Ϊջ�洢��List
		private List<Integer> minlist = new ArrayList<Integer>();  //�����洢��Сֵ������list
		//��洢���ݵ�list�����x����x��minС����x����min������x��list�е�������ΪԪ�ش���minlist
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
	    //������Сֵ�������������������һ��Ԫ�ص���Ҫ��pop��ȥ��Ԫ�ص�����ʱ���൱�ڵ�ǰ�б�����С��һ��ֵ��pop��������Ҫ��
	    //minlist��������һ��Ԫ���ó�������min��ֵ��Ϊ������һ��Ԫ�أ�Ҳ����list������Ӧ��ֵ��֮���ٽ�list���������Ԫ���ó�
	    //������list��Ϊ��ʱ����min��ΪInteger.MAX_VALUE
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
