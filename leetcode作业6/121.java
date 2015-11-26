public class Solution {
    public int maxProfit(int[] prices) {
       

         //�������=��һ��-ǰһ�� Ҳ���ǵ���ֵ����ʱ�����������
        //nlog(n)
        //��ʱ�ˣ���ʵ���ü���ÿ���Ĳ�ֵ��ֻҪ�뵱ǰֵ֮ǰ�� min ����ȽϾͺ�
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
        
        
        //���ǿ��ǣ��������Ϊ0��1�ĳ��ȵ����
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