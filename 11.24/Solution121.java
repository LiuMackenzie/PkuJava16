package solution;

public class Solution121 {
    public int maxProfit(int[] prices) {
    	//��Ŀ��ģ�;����ҳ�һ�������в�ֵ�����������Ĳ�ֵ�����Ҵ��������С������֮�����
        int max = 0;
        int min = Integer.MAX_VALUE;
		int temp = 0; 
		//�õ�Ŀǰ��С��ֵ������ǰ��������ֵ��ȥ��Сֵ�������ֵ�����ģ����¼����
		for (int i = 0 ;i<prices.length;i++) {
			if (prices[i] < min)
				min = prices[i];
			temp = prices[i] - min;
			if (temp > max)
				max = temp;
		}
		return max;
    }
}
