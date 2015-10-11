package solution;

public class Solution189 {
	public void rotate(int[] nums, int k) {
		//由于之前见过这道题，所以不费功夫就AC了，将前半段数字倒叙
		//再将后半段数字倒叙，最后将整个数组倒叙，时间复杂度为O(n)
        //最直白的方法就是挨个移动，做循环，这样时间复杂度是O(n^2)
        int len = nums.length;	
        int temp;
        for(int i = 0, j= len-1-k;i<j;i++,j--){
        	temp = nums[i];
        	nums[i] = nums[j];
        	nums[j] = temp;
        }
        for(int i = len-k, j=len-1;i<j;i++,j--){
        	temp = nums[i];
        	nums[i] = nums[j];
        	nums[j] = temp;
        }
        for(int i = 0,j = len-1;i<j;i++,j--){
        	temp = nums[i];
        	nums[i] = nums[j];
        	nums[j] = temp;
        }
    }
}
