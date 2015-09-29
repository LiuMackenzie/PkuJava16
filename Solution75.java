package solution;

public class Solution75 {
	public void sortColors(int[] nums){
		int len = nums.length;
		int front = 0;
		int end = len-1;
		int mark = 0;
		int temp;
		while(mark<=end){
			if(nums[mark]==0){
				temp=nums[front];
				nums[front]=0;
				nums[mark]=temp;
				mark++;
				front++;
			}else if(nums[mark]==2){
				temp = nums[end];
				nums[end]=2;
				end--;
				nums[mark]=temp;
			}else{
				mark++;
			}
		}
	}
}
