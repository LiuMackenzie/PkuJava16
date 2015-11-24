package solution;

public class Solution231 {
    public boolean isPowerOfTwo(int n) {
    	//����һ����ͣ����n���Զ����������Ϊһ�ͷ��ز���
        boolean ipot = true;
        if(n == 0){
        	return false;
        }
        if(n==Integer.MIN_VALUE){
        	return false;
        }
        int temp = n;
        if(temp<0){
        	return false;
        }
        while(temp!=1){
        	if(temp%2==1){
        		return false;
        	}
        	temp = temp/2;
        }
        return ipot;

        
    }
}
