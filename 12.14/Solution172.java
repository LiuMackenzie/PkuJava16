package solution;

public class Solution172 {
    public int trailingZeroes(int n) {
    	/*������
    	 * ��n�Ľ׳˵�ĩβ0�ĸ�������n�ֽ��֪��ֻ�е�2��5��˵�ʱ�����ʹ��ĩλ��0������ֻ��Ҫͳ��2��5���ֵĴ�������
    	 * ����Ϊ����n��������2���ֵĴ�����Ȼ����5������0�ĸ�����ȡ����5���ֵĴ���������ֻ��Ҫn�ܱ����ٸ�5�������ɡ�
    	*/
        int res = 0;
        while(n!=0){
        	res = res+n/5;
        	n = n/5;
        }
        return res;
    }
}
