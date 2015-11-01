package solution;

public class Solution169 {
    public int majorityElement(int[] nums) {
    	//之前去微软面试的时候遇到过这个题，所以就没什么难度了，提交一遍就过了。。。
    	//没有用到hash来存数（这里就不写那个版本了），本题的方法可以使空间复杂度为O（1）
    	//当nums元素个数为奇数时，majority element的个数一定大于nums.length/2
    	//当nums元素个数为偶数时，majority element的个数一定大于或等于nums.length/2+1
    	//majority element的个数总是比不是majority element的个数多
    	//所以设置变量me，遍历nums，当一个数字出现时，将me设为这个数字，并计数，当下一个数字不是me的当前数字时
    	//若count大于0，则减一，若等于零，之前的数字只出现过一次，则将me设为一个新的数字
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
