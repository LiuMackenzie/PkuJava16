package solution;

public class Solution191 {
	public int hammingWeight(int n){
		int count=0;
        /*if(n==0){         第一个方案没有考虑到接受的数字是无符号的整数，
            return 0;       但是java没有无符号整数的数据类型。
        }					第二个方案又考虑到大于2147483648的数字实际上
        if(n>=2147483647+1){在存储的时候实际上是占用了int的符号位，
            n=n/2;			所以想把大于2147483647的数字当做负数来处理，
            count++;		但是没有行得通，所以又尝试了第三个方案也是最简单
        }*/					//的办法
        /*if(n<0){			第三个方案使用了移位运算，思路也很简单，很容易的就
            count++;		解决了
            n=0-n;
        }
		while(n>0){
			if(n%2==1){
				count++;
			}
			n=n/2;
		}*/
		while(n!=0){
		    if((n&1)==1){
		        count++;
		    }
		    n>>>=1;
		}
		return count;
	}
}
