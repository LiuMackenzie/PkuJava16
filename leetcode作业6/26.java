public class Solution {
    public int removeDuplicates(int[] nums) {
        
        //思路：
        //  1 1 1 2 2 3 5...
        // 因为是有序的，故只要比较相邻两个就行，
        //如果i和i-1相等，就继续往后遍历，用start记录新数组的指针，每次发现不相等的，则进行新的赋值nums[start]=nums[i]
        int count=0;
        int length=nums.length;
        count=length;
        int start=0;//新的 开始指针，nums[0]代表第一个元素
        for(int i=1;i<length;i++)
        {
            if(nums[i]==nums[i-1])
            {
                count--;    //无重复元素的新数组个数
            }
            else
            {
                start++;    
                nums[start]=nums[i];
            }
        }
        return count;
        
    }
}