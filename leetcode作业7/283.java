public class Solution {
    public void moveZeroes(int[] nums) {
        //ð�ݡ�����wrong....
        /*int count=0;
        for(int i=0;i<nums.length-count;i++){
            if(nums[i]==0)
            {
                //��������һλ�������0
                for(int j=i+1;j<nums.length-count;j++)
                {
                    nums[j-1]=nums[j];
                }
                count++;
                nums[nums.length-count]=0;
            }
            
        }*/
        
        //input [0, 1, 0, 3, 12]
        //output[1, 3, 12, 0, 0] 
        //˼·�����¸��ƣ���������ľ����¸�ֵ,����ĩβ�ĸ�0
        int cur=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=0)
            {
                nums[cur]=nums[i];
                cur++;
            }
        }
        for(int j=cur;j<nums.length;j++)
        {
            nums[j]=0;
        }
    }
}
