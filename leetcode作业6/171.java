public class Solution {
    public int titleToNumber(String s) {
        //ASCII���� A--65  
        //A->1 B->2 C-> 3......Z->26 AA->27
        //�൱��26����
        int result=0;
        for(int i=0;i<s.length();i++)
        {
            //result+=(s.charAt(i)-64)*(int)Math.pow(26,i);
            //ע��s���ַ�i�������˳��
            result+=(s.charAt(i)-64)*(int)Math.pow(26,s.length()-1-i);
        }
        return result;
    }
}