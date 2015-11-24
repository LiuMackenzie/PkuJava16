package solution;

public class Solution217b {
	public boolean containsDuplicate(int[] nums) {
		//先排序
		boolean ifDu=false;
		int temp = 0;
		for (int i = 0; i < nums.length - 1; i++) {  
            for (int j = i + 1; j < nums.length; j++) {  
                if (nums[i] > nums[j]) {  
                    temp = nums[i];  
                    nums[i] = nums[j];  
                    nums[j] = temp;  
                }
            }
		}
		//如果出现相邻两个元素相同，直接返回true
		for(int k = 0;k<nums.length-1;k++){
			if(nums[k]==nums[k+1]){
				return true;
			}
		}
		return ifDu;
		//本地测试成功，但是在leetcode上面，如果数组太长会超时
	}
}
