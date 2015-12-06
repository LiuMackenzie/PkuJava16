package solution;

public class Solution283 {
	public void moveZeroes(int[] nums) {
		int len = nums.length;
		int i = 0;
		int count=0; //用来标记0的个数，以便决定nums[i+1]向前移多少位
		int flag=0;
		while(i<len-1){
			if(nums[i]==0){
				if(flag==1){//用来标记之前是否已经移位
					flag=0;
				}else
					count++;//如果没有则0的个数加一
				if(nums[i+1]!=0){
					nums[i+1-count]=nums[i+1];
					nums[i+1]=0;
					flag=1;
				}
			}
			i++;
		}
	}
}
