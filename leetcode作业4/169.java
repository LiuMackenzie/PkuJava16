public class Solution {
    public int majorityElement(int[] nums) {
        
        // eg��1 1 1 1 2 2 2  n=7,n/2=3,����1 
        
		//�㷨һ��2ms
		//������ͬ�ĵ��������ʣ�µľ��Ƿ���ֵ�� Moore��s Voting Algorithm����Robert S.Boyer ��J Strother Moore��1980�귢����������ʱ�临�Ӷ�
        //ѭ����������Ԫ�أ���1������2������3������4��...
        //��1����count==0,������,��count=1��temp=nums[1]
        //��2����nums[1]==temp,������,��count=2,��ʱtemp=nums[1],˵����2��temp
        //��3����nums[2]==temp,��������,��count=1,��ʱtemp=nums[1],˵����2��temp������һ����ͬ��Ԫ��
        //��4����nums[3]==temp,��������,��count=0,��ʱtemp=nums[1],˵����2��temp������һ����ͬ��Ԫ�أ�û����
        //��5������ʱcount=0,��count=1,temp=nums[4]
        //......
//        int count=0;
//        int temp=nums[0];
//        for(int i=0;i<nums.length;i++)
//        {
//            if(count==0)
//            {
//                temp=nums[i];
//                count=1;
//            }
//            else
//            {
//                if(nums[i]==temp)
//                {
//                    count++;
//                }
//                else
//                {
//                    count--;
//                }
//            }
//        }
//        return temp;
		
		
        //�㷨����39ms
        //�ù�ϣ,key���Ԫ�أ�value��ų��ֵĴ�������value>n/2ʱ���򷵻�keyֵ��
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len = nums.length;  //n
          
        for (int i = 0;i < len; i++)  
        {  
            if(!map.containsKey(nums[i]))  //��û�д�ֵ��key=Ԫ�أ�����1�Σ�value=1
            {  
                map.put(nums[i],1);  
            }  
            else{  //���д�ֵ������key=��ֵ��Ӧ��value�ڼ�һ�Σ���¼���ֵĴ���;
            	 map.put(nums[i],(map.get(nums[i])+1));
            }  
            if(map.get(nums[i])>len/2)//�����ִ���>n/2,�򷵻�nums[i],��ǰ��ֵ
    		 return nums[i];
    	}
            
            return 0;
     }     
        
        

        
        
    }
}