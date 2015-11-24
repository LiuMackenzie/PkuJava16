package solution;

public class Solution26 {
    public int removeDuplicates(int[] nums) {
    	int count = 1;
        int i = 1;
        //如果只有一个元素，直接返回
        if(nums.length==1){
            return 1;
        }
        while(i<nums.length){
        	//如果下一个元素和当前count-1记录的最新元素相同，则继续往下遍历
        	if(nums[i]==nums[count-1]){
        		i++;
        	}else{//否则，将新值赋给count记录的值。
        		nums[count]=nums[i];
        		i++;
        		count++;
        	}
        }
        return count;
    }
}
