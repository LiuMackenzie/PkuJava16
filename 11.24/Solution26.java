package solution;

public class Solution26 {
    public int removeDuplicates(int[] nums) {
    	int count = 1;
        int i = 1;
        //���ֻ��һ��Ԫ�أ�ֱ�ӷ���
        if(nums.length==1){
            return 1;
        }
        while(i<nums.length){
        	//�����һ��Ԫ�غ͵�ǰcount-1��¼������Ԫ����ͬ����������±���
        	if(nums[i]==nums[count-1]){
        		i++;
        	}else{//���򣬽���ֵ����count��¼��ֵ��
        		nums[count]=nums[i];
        		i++;
        		count++;
        	}
        }
        return count;
    }
}
