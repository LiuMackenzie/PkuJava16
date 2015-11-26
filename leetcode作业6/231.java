public class Solution {
    public boolean isPowerOfTwo(int n) {
        /*超时了。。。。
        if(n<1)
            return false;
        //int powerOfTwo=1;
        //for(int i=0;i<n/2;i++)
        for(int i=0;i<n/2;i++)
        { 
                int powerOfTwo=1;
                for(int j=0;j<=i;j++)
                {
                    powerOfTwo*=2;
                } 
                if(powerOfTwo>n)
                return false;
         }
        return true;
        */
        //参考做法
        //1   2的0次      0001
        //2   2的1次      0010
        //4   2的2次      0100
        //....
        //规律，有且只有一个1，即n 并 n-1 =0,eg:100&011=000
        return  n > 0 && ( n & (n-1))==0 ;

    }
}