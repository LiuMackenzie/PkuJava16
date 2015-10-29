public class Solution {
    List<List<Integer>> result=new ArrayList<List<Integer>>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //�������
        if(nums.length<4||nums==null)
            return result;
        
        //����
        Arrays.sort(nums);
        
        int len=nums.length;
        
        //4sum-->3sum-->2sum
        for(int i=0;i<len-3;i++){
            //���󣺳����ظ��ģ����������޸ģ�������ͬ�ģ���continue
            if(i>0&&nums[i]==nums[i-1])
    			continue;
            for(int j=i+1;j<len-2;j++){
                //����if(j>1&&nums[j]==nums[j-1]) continue;//�Ż��������ڵ�����ȣ��������˴�ѭ����������һ��
                if(j>i+1&&nums[j]==nums[j-1]) continue; //Ӧ�ø�Ϊj>i+2,
                int begin=j+1,end=len-1;
                //List<Integer> item=new ArrayList<Integer>();���Ӧ�÷ŵ�while���棬���������item���г���4�������
                while(begin<end)
                {
                    int sum=nums[begin]+nums[end]+nums[i]+nums[j];
                    //����=target,��ӵ������
                    if(sum==target){
                        List<Integer> item=new ArrayList<Integer>();
                        item.add(nums[i]);
                        item.add(nums[j]);
                        item.add(nums[begin]);
                        item.add(nums[end]);
                        result.add(item);
                        
                        //��ֹ�ظ�
                        while(begin<end&&nums[begin]==nums[begin+1]) begin++;
		            	while(begin<end&&nums[end]==nums[end-1]) end--;
                        
                        begin++;
                        end--;
                    }
                    //����<0,��begin����
                    else if(sum<target)
                        begin++;
                    //����<0,��end����
                    else
                        end--;
                        
		        	
                }
                
            }
        }
        
        return result;
    }
}