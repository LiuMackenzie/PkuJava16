public class Solution {
    public int[] twoSum(int[] nums, int target) {
	  
	    	//�㷨1��ʱ�临�Ӷȣ�O^2������ͷ��β�����������Ϊtarget�������index������result
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
	    	

	    	
	    	//�㷨2.1��ʱ�临�Ӷ�O(n),�ȱ���һ���ֵ����hashmap���ڱ���hashmap����target-map.get(��ǰֵ)
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
	    	
	    	//�㷨2.2��ʱ�临�Ӷ�O(n),�����2.1��ֻ����һ�飬��map�д�ŵ��� ����ֵ-��ǰֵ�������ǰֵ��map�д��ڣ���˵���������Ϊtarget
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