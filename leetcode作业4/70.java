public class Solution {
    public int climbStairs(int n) {
     
     //其实是递归思想，设有n阶
     //假设第一次迈1阶,剩n-1阶，则有f(n-1)种
     //假设第一次迈2阶,剩n-2阶，则有f(n-2)种
     //故f(n)=f(n-1)+f(n-2)
     //自己计算可知 f(1)=1,f(2)=2
     
    //Time Limit Exceeded ??????????????????
    //44，在eclipse运行能过result:1134903170，但在leetcode上不行
    // if(n==1)
    //    return 1;
    // if(n==2)
    //    return 2;
    //  return climbStairs(n-1)+climbStairs(n-2);
   
     //1阶...1种
     //2阶...2种
     //3阶...3种
     //4阶...5种
     //5阶...8种
     //6阶...13种
     //发现规律。。。
     //实际是：斐波那契数列：0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
     int a = 0;
     int b = 1;
     int sum = 0;

     for(int i = 1; i <= n; i++){
        sum = a + b;
        a = b;
        b = sum;
    }
        return sum;
    }
}