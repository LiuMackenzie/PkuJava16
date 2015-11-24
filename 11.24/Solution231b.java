package solution;

public class Solution231b {
	public boolean isPowerOfTwo(int n) {
		//方法二：将其看做二进制的数字，如果是2的次幂，二进制中只有最高位会是1，其余位都是0
	    int temp = n;
	    int count = 0;
	    if(temp<0){
	    	return false;
	    }
	    while(temp>0){
	    	count = count + (n&0X01);
	    	n= n>>1;
	    }
	    if (count == 1 ){
	    	return true;
	    }else
	    	return false;
	}

}
