package solution;

public class Solution70 {
    public int climbStairs(int n) {
    	int ways = 0;
    	int first=1;
    	int second=2;
    	int count=n-2;
    	//����0,1,2��ʱ������ѭ����ֱ�ӷ��ؽ��
    	if(n==0){
    		return 0;
    	}
    	if(n==1){
    		return first;
    	}
    	if(n==2){
    		return second;
    	}
    	//û��ʹ������洢�Ѿ������ֵ��ֱ�ӽ����滻��ֵ����n�׵ķ����൱����n-1�׵ķ���������n-2�׵ķ���
    	while(n>2 && count>0){
    		ways = first+second;
    		first = second;
    		second = ways;
    		count--;
    	}
    	return ways;
    }
}
