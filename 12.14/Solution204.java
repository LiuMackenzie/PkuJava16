package solution;

public class Solution204 {
    public int countPrimes(int n) {
    	//��������ʾ�еķ�����Sieve of Eratosthenes
    	//��2--n�����е�һ�γ��ֵ����ֱ�Ϊ��������ɾ��������ֵı�����
    	//һֱ������ֱ�������������ֵ�ƽ������n
        boolean[] prime = new boolean[n];
        for(int i = 0;i<n;i++){
        	prime[i] = true;
        }
        for(int j = 0; j<n;j++){
        	if(prime[j]==false)
        		continue;
        	int k = j * j;
        	while(k<n){
        		prime[k] = false;
        		k = k + j;
        	}
        }
        int count = 0;
        for(int i = 2; i<n;i++){
        	if(prime[i])
        		count++;
        }
        return count;
    }
}
