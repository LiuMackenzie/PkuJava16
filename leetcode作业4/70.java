public class Solution {
    public int climbStairs(int n) {
     
     //��ʵ�ǵݹ�˼�룬����n��
     //�����һ����1��,ʣn-1�ף�����f(n-1)��
     //�����һ����2��,ʣn-2�ף�����f(n-2)��
     //��f(n)=f(n-1)+f(n-2)
     //�Լ������֪ f(1)=1,f(2)=2
     
    //Time Limit Exceeded ??????????????????
    //44����eclipse�����ܹ�result:1134903170������leetcode�ϲ���
    // if(n==1)
    //    return 1;
    // if(n==2)
    //    return 2;
    //  return climbStairs(n-1)+climbStairs(n-2);
   
     //1��...1��
     //2��...2��
     //3��...3��
     //4��...5��
     //5��...8��
     //6��...13��
     //���ֹ��ɡ�����
     //ʵ���ǣ�쳲��������У�0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
     int a = 0;
     int b = 1;
     int sum = 0;

     for(int i = 1; i <= n; i++){
        sum = a + b;
        a = b;
        b = sum;
    }
        return sum;
    }
}