public class Solution {
    public boolean containsDuplicate(int[] nums) {
        //从头到尾挨着比较
        //冒泡..
        /*超时了?????为啥
        for(int i=0;i<nums.length-1;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[i]==nums[j])
                {
                    return true;
                }
            }
        }
        return false;
        */
        
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]==nums[i-1])
            {
                return true;
            }
        }
        return false;
        
    }
}