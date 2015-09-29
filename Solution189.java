package solution;

public class Solution189 {
	public void rotate(int[] nums, int k) {
		//����֮ǰ��������⣬���Բ��ѹ����AC�ˣ���ǰ������ֵ���
		//�ٽ��������ֵ�������������鵹��ʱ�临�Ӷ�ΪO(n)
        //��ֱ�׵ķ������ǰ����ƶ�����ѭ��������ʱ�临�Ӷ���O(n^2)
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
