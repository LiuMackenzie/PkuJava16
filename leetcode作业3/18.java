public class Solution {
    List<List<Integer>> result=new ArrayList<List<Integer>>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //特殊情况
        if(nums.length<4||nums==null)
            return result;
        
        //排序
        Arrays.sort(nums);
        
        int len=nums.length;
        
        //4sum-->3sum-->2sum
        for(int i=0;i<len-3;i++){
            //错误：出现重复的，进行如下修改，当有相同的，则continue
            if(i>0&&nums[i]==nums[i-1])
    			continue;
            for(int j=i+1;j<len-2;j++){
                //错误：if(j>1&&nums[j]==nums[j-1]) continue;//优化，若相邻的数相等，则跳出此次循环，继续下一次
                if(j>i+1&&nums[j]==nums[j-1]) continue; //应该改为j>i+2,
                int begin=j+1,end=len-1;
                //List<Integer> item=new ArrayList<Integer>();这个应该放到while里面，否则出现了item内有超过4个的情况
                while(begin<end)
                {
                    int sum=nums[begin]+nums[end]+nums[i]+nums[j];
                    //若和=target,则加到结果集
                    if(sum==target){
                        List<Integer> item=new ArrayList<Integer>();
                        item.add(nums[i]);
                        item.add(nums[j]);
                        item.add(nums[begin]);
                        item.add(nums[end]);
                        result.add(item);
                        
                        //防止重复
                        while(begin<end&&nums[begin]==nums[begin+1]) begin++;
		            	while(begin<end&&nums[end]==nums[end-1]) end--;
                        
                        begin++;
                        end--;
                    }
                    //若和<0,则begin右移
                    else if(sum<target)
                        begin++;
                    //若和<0,则end左移
                    else
                        end--;
                        
		        	
                }
                
            }
        }
        
        return result;
    }
}