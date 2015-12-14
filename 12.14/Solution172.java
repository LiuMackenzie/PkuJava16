package solution;

public class Solution172 {
    public int trailingZeroes(int n) {
    	/*分析：
    	 * 求n的阶乘的末尾0的个数，将n分解得知，只有当2和5相乘的时候才能使得末位是0，所以只需要统计2和5出现的次数即可
    	 * 又因为随着n的增长，2出现的次数必然多于5，所以0的个数就取决于5出现的次数，所以只需要n能被多少个5整除即可。
    	*/
        int res = 0;
        while(n!=0){
        	res = res+n/5;
        	n = n/5;
        }
        return res;
    }
}
