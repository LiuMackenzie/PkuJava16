public class Solution {
    public int maxProfit(int[] prices) {
       

         //最大收益=后一个-前一个 也就是当差值最大的时候是最大收益
        //nlog(n)
        //超时了，其实不用计算每个的差值，只要与当前值之前的 min 相减比较就好
        //int result=0;
        //int delt=0;
        /*for(int i=0;i<prices.length-1;i++)
        {
            for(int j=i+1;j<prices.length;j++)
            {
                delt=prices[j]-prices[i];
                if(delt>result)
                {
                    result=delt;
                }
            }
        }
        return result;
        */
        
        
        //忘记考虑，如果数组为0或1的长度的情况
        if(prices.length<2)
        {
            return 0;
        }
        
        int result=0;
        int min=prices[0];
        
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]<min)
            {
                min=prices[i];
            }
            if(result<prices[i]-min)
            {
                result=prices[i]-min;
            }
        }
        return result;
        
    }
}