package solution;

public class Solution231b {
	public boolean isPowerOfTwo(int n) {
		//�����������俴�������Ƶ����֣������2�Ĵ��ݣ���������ֻ�����λ����1������λ����0
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
