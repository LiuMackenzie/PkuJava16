public class Solution {
    public int removeDuplicates(int[] nums) {
        
        //˼·��
        //  1 1 1 2 2 3 5...
        // ��Ϊ������ģ���ֻҪ�Ƚ������������У�
        //���i��i-1��ȣ��ͼ��������������start��¼�������ָ�룬ÿ�η��ֲ���ȵģ�������µĸ�ֵnums[start]=nums[i]
        int count=0;
        int length=nums.length;
        count=length;
        int start=0;//�µ� ��ʼָ�룬nums[0]�����һ��Ԫ��
        for(int i=1;i<length;i++)
        {
            if(nums[i]==nums[i-1])
            {
                count--;    //���ظ�Ԫ�ص����������
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