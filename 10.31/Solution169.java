package solution;

public class Solution169 {
    public int majorityElement(int[] nums) {
    	//֮ǰȥ΢�����Ե�ʱ������������⣬���Ծ�ûʲô�Ѷ��ˣ��ύһ��͹��ˡ�����
    	//û���õ�hash������������Ͳ�д�Ǹ��汾�ˣ�������ķ�������ʹ�ռ临�Ӷ�ΪO��1��
    	//��numsԪ�ظ���Ϊ����ʱ��majority element�ĸ���һ������nums.length/2
    	//��numsԪ�ظ���Ϊż��ʱ��majority element�ĸ���һ�����ڻ����nums.length/2+1
    	//majority element�ĸ������ǱȲ���majority element�ĸ�����
    	//�������ñ���me������nums����һ�����ֳ���ʱ����me��Ϊ������֣�������������һ�����ֲ���me�ĵ�ǰ����ʱ
    	//��count����0�����һ���������㣬֮ǰ������ֻ���ֹ�һ�Σ���me��Ϊһ���µ�����
        int me = 0;
        int i = 0;
        int len = nums.length;
        int count=0;
        me = nums[i];
        for(i=1;i<len;i++){
        	if(nums[i]==me){
        		count++;
        	}else{
        		if(count>0){
        			count--;
        		}else{
        			me=nums[i];
        		}
        	}
        }
        return me;
    }
}
