public class Solution {
    public int majorityElement(int[] nums) {
        
        // eg：1 1 1 1 2 2 2  n=7,n/2=3,返回1 
        
		//算法一：2ms
		//俩俩不同的抵消，最后剩下的就是返回值， Moore’s Voting Algorithm，由Robert S.Boyer 和J Strother Moore于1980年发明，是线性时间复杂度
        //循环遍历所有元素，第1个，第2个，第3个，第4个...
        //第1个：count==0,若等于,则count=1，temp=nums[1]
        //第2个：nums[1]==temp,若等于,则count=2,此时temp=nums[1],说明有2个temp
        //第3个：nums[2]==temp,若不等于,则count=1,此时temp=nums[1],说明有2个temp，消掉一个不同的元素
        //第4个：nums[3]==temp,若不等于,则count=0,此时temp=nums[1],说明有2个temp，消掉一个不同的元素，没有了
        //第5个：此时count=0,则count=1,temp=nums[4]
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
		
		
        //算法二：39ms
        //用哈希,key存放元素，value存放出现的次数，当value>n/2时，则返回key值。
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len = nums.length;  //n
          
        for (int i = 0;i < len; i++)  
        {  
            if(!map.containsKey(nums[i]))  //若没有此值，key=元素，并记1次，value=1
            {  
                map.put(nums[i],1);  
            }  
            else{  //若有此值，则在key=此值对应的value在加一次，记录出现的次数;
            	 map.put(nums[i],(map.get(nums[i])+1));
            }  
            if(map.get(nums[i])>len/2)//若出现次数>n/2,则返回nums[i],当前的值
    		 return nums[i];
    	}
            
            return 0;
     }     
        
        

        
        
    }
}