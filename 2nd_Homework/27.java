public class Solution {
    public int removeElement(int[] nums, int val) {
    	//��������Ŀ��ֻ������Ŀ����û�иı����顣����
//        int len=nums.length;
//        for(int i=0;i<nums.length;i++)
//        {
//        	if(nums[i]==val)
//        	{
//        		len--;
//        	}
//        }
//        return len;
    	
    	//�㷨��ʱ�临�Ӷ�O(n)���������������������¡������飬������������ĳ��ȡ�	
//    	int len=nums.length;	
//    	int  start=0;
//        for(int i=0;i<len;i++)
//        {
//        	//������ֵ����Ҫremove��Ԫ�أ���start++��i++����ֵ����������
//        	 if (val != nums[i])
//        	 {
//        		 nums[start++] = nums[i];
//        	 }
//        }
//        return start;
        
    	//�㷨�Ż�:���û����Ҫremove��Ԫ�ص�����£�����Ҫһһ��ֵ��
        int len=nums.length;
    	int count=0;	
        for(int i=0;i<len;i++)
        {
        	if(nums[i]==val)
        	{
        		count++;
        	}else if(count>0)
        	{
        		nums[i-count]=nums[i];
        	}
        	
        }
        return len-count;
    }
}