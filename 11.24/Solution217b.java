package solution;

public class Solution217b {
	public boolean containsDuplicate(int[] nums) {
		//������
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
		//���������������Ԫ����ͬ��ֱ�ӷ���true
		for(int k = 0;k<nums.length-1;k++){
			if(nums[k]==nums[k+1]){
				return true;
			}
		}
		return ifDu;
		//���ز��Գɹ���������leetcode���棬�������̫���ᳬʱ
	}
}
