public class Solution {
    public int myAtoi(String str) {
        //ע��������������ַ����������š��Ƿ��ַ������Խ�磬Ӧ�������ֵ����Сֵ
        //ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(1)
        int i = 0;  
        //���ַ���
        if (str.length() == 0) {  
            return 0;  
        }  
        while (i < str.length() && str.charAt(i) == ' ') {  
            i++;  
        }  
        int sign = 1;  
        //�ж�������
        if (str.charAt(i) == '+') {  
            i++;  
        } else if (str.charAt(i) == '-') {  
            i++;  
            sign = -1;  
        }  
  
        int number = 0;  
        while (i < str.length()) {  
            if (str.charAt(i) < '0' || str.charAt(i) > '9') { //�Ƿ��ַ� 
                return sign * number;  
            }  
            if (Integer.MAX_VALUE / 10 < number||(Integer.MAX_VALUE / 10 == number&& (str.charAt(i) - '0') > Integer.MAX_VALUE % 10)) 
            {  
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;  
            }  
            number = 10 * number + str.charAt(i) - '0';  //-'0'��ȥ0��ASCIIֵ�������ַ�ת��int
            i++;  
        }  
        return sign * number;  
    }
}