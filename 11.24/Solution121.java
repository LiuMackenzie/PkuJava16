package solution;

public class Solution121 {
    public int maxProfit(int[] prices) {
    	//题目的模型就是找出一个数组中差值最大的两个数的差值，并且大的数字在小的数字之后出现
        int max = 0;
        int min = Integer.MAX_VALUE;
		int temp = 0; 
		//得到目前最小的值，将当前遍历到的值减去最小值，如果差值是最大的，则记录下来
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
