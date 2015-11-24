package solution;

import java.util.HashSet;
import java.util.Set;

public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
    	//将遍历到的数放到集合中
        boolean ifDu = false;
        int i = 0;
        Set<Integer> set = new HashSet<Integer>();
        //每次遍历新的数，在集合中查找是否出现重复
        while(i<nums.length){
        	if(set.contains(nums[i])){
        		return true;
        	}
        	else{
        		set.add(nums[i++]);
        	}
        }
        return ifDu;
    }
}
