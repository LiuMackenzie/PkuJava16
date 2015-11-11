package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Solution15 {
    public static List<List<Integer>> threeSum(int[] nums) {
    	//方法一：使用递归的方法，每次标记数组的头a或尾部b向中间移动，中间标记c一次遍历头尾中间的数字，
    	//若遇到和等于0则返回，如果不为零就递归调用这个函数，让头或尾部的标记向中间移动一个位置，截取这个数组作为
    	//递归调用的传入值。在leetcode上测试，如果是数字比较少的话，可以运行成功，若数字多的话就会超时。
    	Arrays.sort(nums);
    	List<List<Integer>> ll = new ArrayList<List<Integer>>();
    	int a,b,c;
    	int len = nums.length;
    	if (len<=2){
    		return ll;
    	}
    	a = 0;
    	c = len-1;
        if(nums[a]+nums[c]>=0){
        	b=a+1;
        	if(nums[a]>0 && nums[c]>0){
        		return null;
        	}
        	if(nums[a]+nums[c]>Math.abs(nums[a])){
        		return null;
        	}
        	while(b<len-1 && nums[b]<=0){
            	List<Integer> ls = new ArrayList<Integer>();
        		if(nums[a]+nums[b]+nums[c]==0){
        			ls.add(nums[a]);
        			ls.add(nums[b]);
        			ls.add(nums[c]);
        			if(!ll.contains(ls)){
        				ll.add(ls);
        			}else{
        				ls.clear();
        			}
        			List<List<Integer>> temp1 = threeSum(Arrays.copyOfRange(nums, a+1, c+1));
        			if(temp1!=null){
        				for(Iterator<List<Integer>> i = temp1.listIterator();i.hasNext();){
        					List<Integer> tm=i.next();
        					if(!ll.contains(tm)){
        						ll.add((List<Integer>) tm);
        					}
        				}
        			}
        			List<List<Integer>> temp2 = threeSum(Arrays.copyOfRange(nums, a, c));
        			if(temp2!=null){
        				for(Iterator<List<Integer>> i = temp2.listIterator();i.hasNext();){
        					List<Integer> tm=i.next();
        					if(!ll.contains(tm)){
        						ll.add((List<Integer>) tm);
        					}
        				}
        			}
        			return ll;
        		}
        		b++;
        	}
        	if (b<len-1 && nums[b]>0){
        		return null;
        	}
        }
        if(nums[a]+nums[c]<0){
        	b=c-1;
        	if(nums[a]<0 && nums[c]<0){
        		return null;
        	}
        	if(Math.abs(nums[a]+nums[c])>Math.abs(nums[c])){
        		return null;
        	}
        	while(b<len-1 && nums[b]>0){
            	List<Integer> ls = new ArrayList<Integer>();
        		if(nums[a]+nums[b]+nums[c]==0){
        			ls.add(nums[a]);
        			ls.add(nums[b]);
        			ls.add(nums[c]);
        			if(!ll.contains(ls)){
        				ll.add(ls);
        			}else{
        				ls.clear();
        			}
        			//在这里递归调用a向后移位之后的数组，将它与本次调用的结果相连
        			List<List<Integer>> temp1 = threeSum(Arrays.copyOfRange(nums, a+1, c+1));
        			if(temp1!=null){
        				for(Iterator<List<Integer>> i = temp1.listIterator();i.hasNext();){
        					List<Integer> tm=i.next();
        					if(!ll.contains(tm)){
        						ll.add((List<Integer>) tm);
        					}
        				}
        			}
        			//在这里递归调用c向前移位之后的数组，将它与本次调用的结果相连
        			List<List<Integer>> temp2 = threeSum(Arrays.copyOfRange(nums, a, c));
        			if(temp2!=null){
        				for(Iterator<List<Integer>> i = temp2.listIterator();i.hasNext();){
        					List<Integer> tm=i.next();
        					if(!ll.contains(tm)){
        						ll.add((List<Integer>) tm);
        					}
        				}
        			}
        			return ll;
        		}
        		b++;
        	}
        	if (b<len-1 && nums[b]<0){
        		return null;
        	}
        }
		return null;
    	//方法2：这个方法使用的比较容易想到，先排序，再设置三个循环嵌套，依次遍历，相加。其中设置条件可以减少运算时间
		//比如当三个数都大于等于零时，直接跳出循环。这段代码在提交的时候提示超时，将超时的例子在run code中测试时可以
		//运行出结果，并且和网站上给出的运行结果一致。详情请见截图。
    	Arrays.sort(nums);
    	List<List<Integer>> ll = new ArrayList<List<Integer>>();
    	if (nums.length<=2){
    		return ll;
    	}
    	int mid=1;
    	int end = nums.length-1;
    	for(;end>0 && nums[end]>=0;end--){
    		int front = 0;
    		for(;nums[front]<=0 && front<nums.length-2 ;front++){
    			for(mid=front+1;mid<end;mid++){
    				if((nums[front]>=0 && nums[mid]>0 && nums[end]>0)||(nums[front]<0 && nums[mid]<0 && nums[end]<=0)){
    					break;
    				}
    				if(nums[front]+nums[mid]+nums[end]==0){
    					List<Integer> li = new ArrayList<Integer>();
    					li.add(nums[front]);
    					li.add(nums[mid]);
    					li.add(nums[end]);
    					if(!ll.contains(li)){
    						ll.add(li);
    					}
    					break;
    				}
    			}
    		}
    	}
    	return ll;*/
    }
}








