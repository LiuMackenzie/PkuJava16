public class Solution {
    public int removeElement(int[] nums, int val) {
    	//理解错了题目，只算了数目，并没有改变数组。。。
//        int len=nums.length;
//        for(int i=0;i<nums.length;i++)
//        {
//        	if(nums[i]==val)
//        	{
//        		len--;
//        	}
//        }
//        return len;
    	
    	//算法：时间复杂度O(n)，设置两个变量来遍历新、旧数组，并计算新数组的长度。	
//    	int len=nums.length;	
//    	int  start=0;
//        for(int i=0;i<len;i++)
//        {
//        	//如果这个值不是要remove的元素，则start++，i++，赋值并继续遍历
//        	 if (val != nums[i])
//        	 {
//        		 nums[start++] = nums[i];
//        	 }
//        }
//        return start;
        
    	//算法优化:针对没有需要remove的元素的情况下，则不需要一一赋值。
        int len=nums.length;
    	int count=0;	
        for(int i=0;i<len;i++)
        {
        	if(nums[i]==val)
        	{
        		count++;
        	}else if(count>0)
        	{
        		nums[i-count]=nums[i];
        	}
        	
        }
        return len-count;
    }
}