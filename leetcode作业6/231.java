public class Solution {
    public boolean isPowerOfTwo(int n) {
        /*��ʱ�ˡ�������
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
        //�ο�����
        //1   2��0��      0001
        //2   2��1��      0010
        //4   2��2��      0100
        //....
        //���ɣ�����ֻ��һ��1����n �� n-1 =0,eg:100&011=000
        return  n > 0 && ( n & (n-1))==0 ;

    }
}