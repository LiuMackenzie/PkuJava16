package solution;

public class Solution283 {
	public void moveZeroes(int[] nums) {
		int len = nums.length;
		int i = 0;
		int count=0; //�������0�ĸ������Ա����nums[i+1]��ǰ�ƶ���λ
		int flag=0;
		while(i<len-1){
			if(nums[i]==0){
				if(flag==1){//�������֮ǰ�Ƿ��Ѿ���λ
					flag=0;
				}else
					count++;//���û����0�ĸ�����һ
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
