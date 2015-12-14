package solution;

public class Solution204 {
    public int countPrimes(int n) {
    	//采用了提示中的方法：Sieve of Eratosthenes
    	//将2--n数列中第一次出现的数字标为素数，并删除这个数字的倍数，
    	//一直遍历，直到遍历到的数字的平方大于n
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
