package solution;

import java.util.HashSet;
import java.util.Set;

public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
    	//�������������ŵ�������
        boolean ifDu = false;
        int i = 0;
        Set<Integer> set = new HashSet<Integer>();
        //ÿ�α����µ������ڼ����в����Ƿ�����ظ�
        while(i<nums.length){
        	if(set.contains(nums[i])){
        		return true;
        	}
        	else{
        		set.add(nums[i++]);
        	}
        }
        return ifDu;
    }
}
