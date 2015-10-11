package solution;

public class Solution258 {
	public int addDigits(int num) {
        int res;
        res = num - 9*(int)((num-1)/9);
        return res;
    }
}
