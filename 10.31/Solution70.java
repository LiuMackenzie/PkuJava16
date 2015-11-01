package solution;

public class Solution70 {
    public int climbStairs(int n) {
    	int ways = 0;
    	int first=1;
    	int second=2;
    	int count=n-2;
    	//当是0,1,2阶时不进入循环，直接返回结果
    	if(n==0){
    		return 0;
    	}
    	if(n==1){
    		return first;
    	}
    	if(n==2){
    		return second;
    	}
    	//没有使用数组存储已经算出的值，直接进行替换赋值，走n阶的方法相当于走n-1阶的方法加上走n-2阶的方法
    	while(n>2 && count>0){
    		ways = first+second;
    		first = second;
    		second = ways;
    		count--;
    	}
    	return ways;
    }
}
