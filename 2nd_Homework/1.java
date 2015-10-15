public class Solution {
    public int[] twoSum(int[] nums, int target) {
	  
	    	//算法1：时间复杂度（O^2），从头到尾遍历，若相加为target，则记下index，返回result
//	    	int[] result=new int[2];
//	    	for(int i=0;i<nums.length-1;i++)
//	    	{
//	    		for(int j=i+1;j<nums.length;j++)
//	    		{
//	    			if(nums[i]+nums[j]==target)
//	    			{
//	    					result[0]=i+1;
//	    					result[1]=j+1;
//					    	return result;
//	    			}
//	    		}
//	    	}
//	        return result;
	    	

	    	
	    	//算法2.1：时间复杂度O(n),先遍历一遍把值放入hashmap，在便利hashmap，找target-map.get(当前值)
//	    	 int[] res = new int[2];
//	    	 Map mymap = new HashMap();
//	    	 for(int i = 0; i < nums.length; i++){
//	    	 mymap.put(nums[i], i);
//	    	 }
//	    	 for(int i = 0; i < nums.length; i++){
//	    	 int gap = target - nums[i];
//	    	 if(mymap.get(gap)!= null && (int)mymap.get(gap)!= i){
//	    	 res[0] = i+1;
//	    	 res[1] = (int)mymap.get(gap) + 1;
//	    	 break;
//	    	 }
//	    	 }
//	    	 return res;
	    	
	    	//算法2.2：时间复杂度O(n),相较于2.1，只遍历一遍，在map中存放的是 期望值-当前值，如果当前值在map中存在，则说明两数相加为target
	    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    	int[] result = new int[2];
	    	 
	    	for (int i = 0; i < nums.length; i++) {
	    		if (map.containsKey(nums[i])) {
	    			int index = map.get(nums[i]);
	    			result[0] = index+1 ;
	    			result[1] = i+1;
	    			break;
	    		} else {
	    			map.put(target - nums[i], i);
	    		}
	    	}
	    	return result;

    }
}