public class Solution {
    List<List<Integer>> result=new ArrayList<List<Integer>>();//��Ž����list
    public List<List<Integer>> threeSum(int[] nums) {
        
        //��һ��û����������� �������������Ϊ��or���鳤�Ȳ���3�����򷵻ؿյ�list
        if(nums == null || nums.length< 3)
        	return result;
        
        //���򣬷������Ƚϴ�С����
        Arrays.sort(nums); //T.T ��ʼд����Array.Sort....
       
        int len=nums.length; //����Ԫ�ظ���
       
        //��������ͷ��ʼ ������������
        for(int i=0;i<len-2;i++){
            
            //�Ż�!!��һ�����г�ʱ�ˣ����Ż�һ�¡���Ϊ������õģ������������������ȣ��������˴�ѭ��
            if(i>0&&nums[i]==nums[i-1])continue;
            
            //�ӵ�i����ʼ�����ң����Ƿ����������nums[i]�ĺ�Ϊ0
            find(nums[i],i+1,len-1,nums);
        }
        return  result;
        
    }
    public void find(int target,int begin,int end,int[] nums)
    {
        
        //ͷβ��ָ���������м��ƶ���֪��begin>=end,�����
        while(begin<end){
            //1.����������=0����������������뵽�����
            if(target+nums[begin]+nums[end]==0){
                List<Integer> item=new ArrayList<Integer>(); //T.T ArrayList����Arraylist...
                item.add(target);
                item.add(nums[begin]);
                item.add(nums[end]);
                result.add(item);   //���뵽�����
                
                //�Ż�
                //����������ȵ����������
    			while(begin<end&&nums[begin]==nums[begin+1]) begin++;
    			while(begin<end&&nums[end]==nums[end-1]) end--;
    			
    			//T.T...��һ����������β�ƶ���...����˳�ʱ
    			begin++;
    			end--;
                
            }
            //2.����������<0,���С�ˣ�Ҫͷָ�������ƶ�
            else if(target+nums[begin]+nums[end]<0){
                begin++;
            }
            //3.����������>0,��ʹ��ˣ�Ҫβָ�������ƶ�
            else
            {
                end--;
            }
        }
    }
}