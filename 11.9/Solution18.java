package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Solution18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
    	//基于2sum，先设置两个循环，分别固定前两个点a、b，再用2sum的方法来移动c、d。
        List<List<Integer>> li = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        if(nums.length<4){
        	return li;
        }
        for(int a = 0; a<nums.length-3;a++){
        	for(int b =a+1;b<nums.length-2;b++){
        		int c = b+1;
        		int d = nums.length-1;
        		while(c<d){
        			int temp = nums[a]+nums[b]+nums[c]+nums[d];
        			if(temp<target){
        				c++;
        			}else if(temp==target){
        				List<Integer> list = new ArrayList<Integer>();
        				list.add(nums[a]);
        				list.add(nums[b]);
        				list.add(nums[c]);
        				list.add(nums[d]);
        				if(!li.contains(list)){
        					li.add(list);
        				}
        				c++;
        				d--;
        			}else if(temp>target){
        				d--;
        			}
        		}
        	}
        }
        return li;
    }
    public static void main(String [] args){
    	List<List<Integer>> li = new ArrayList<List<Integer>>();
    	int[] a = {1,-2,-5,-4,-3,3,3,5};
    	li = fourSum(a, -11);
    	for(Iterator<List<Integer>> it2 = li.iterator();it2.hasNext();){
    		List<Integer> ll = it2.next();
    		for(Iterator<Integer> it1 = ll.iterator();it1.hasNext();){
    			System.out.print(it1.next());
    		}
    		System.out.println();
    	}
    }
}
