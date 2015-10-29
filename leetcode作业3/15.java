public class Solution {
    List<List<Integer>> result=new ArrayList<List<Integer>>();//存放结果的list
    public List<List<Integer>> threeSum(int[] nums) {
        
        //第一次没考虑特殊情况 ，若输入的数组为空or数组长度不足3个，则返回空的list
        if(nums == null || nums.length< 3)
        	return result;
        
        //排序，方便后面比较大小计算
        Arrays.sort(nums); //T.T 开始写成了Array.Sort....
       
        int len=nums.length; //数组元素个数
       
        //遍历，从头开始 到倒数第三个
        for(int i=0;i<len-2;i++){
            
            //优化!!第一次运行超时了，故优化一下。因为是排序好的，所以如果相邻两个相等，则跳出此次循环
            if(i>0&&nums[i]==nums[i-1])continue;
            
            //从第i个开始往后找，看是否存在两数与nums[i]的和为0
            find(nums[i],i+1,len-1,nums);
        }
        return  result;
        
    }
    public void find(int target,int begin,int end,int[] nums)
    {
        
        //头尾的指针慢慢往中间移动，知道begin>=end,则结束
        while(begin<end){
            //1.若三个数和=0，则把这三个数加入到结果集
            if(target+nums[begin]+nums[end]==0){
                List<Integer> item=new ArrayList<Integer>(); //T.T ArrayList不是Arraylist...
                item.add(target);
                item.add(nums[begin]);
                item.add(nums[end]);
                result.add(item);   //加入到结果集
                
                //优化
                //相邻两数相等的情况，跳过
    			while(begin<end&&nums[begin]==nums[begin+1]) begin++;
    			while(begin<end&&nums[end]==nums[end-1]) end--;
    			
    			//T.T...第一次忘记让首尾移动了...造成了超时
    			begin++;
    			end--;
                
            }
            //2.若三个数和<0,则和小了，要头指针往右移动
            else if(target+nums[begin]+nums[end]<0){
                begin++;
            }
            //3.若三个数和>0,则和大了，要尾指针往左移动
            else
            {
                end--;
            }
        }
    }
}