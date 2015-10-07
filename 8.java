public class Solution {
    public int myAtoi(String str) {
        //注意特殊情况，空字符串、正负号、非法字符、如果越界，应返回最大值、最小值
        //时间复杂度O(n)，空间复杂度O(1)
        int i = 0;  
        //空字符串
        if (str.length() == 0) {  
            return 0;  
        }  
        while (i < str.length() && str.charAt(i) == ' ') {  
            i++;  
        }  
        int sign = 1;  
        //判断正负号
        if (str.charAt(i) == '+') {  
            i++;  
        } else if (str.charAt(i) == '-') {  
            i++;  
            sign = -1;  
        }  
  
        int number = 0;  
        while (i < str.length()) {  
            if (str.charAt(i) < '0' || str.charAt(i) > '9') { //非法字符 
                return sign * number;  
            }  
            if (Integer.MAX_VALUE / 10 < number||(Integer.MAX_VALUE / 10 == number&& (str.charAt(i) - '0') > Integer.MAX_VALUE % 10)) 
            {  
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;  
            }  
            number = 10 * number + str.charAt(i) - '0';  //-'0'减去0的ASCII值，即将字符转成int
            i++;  
        }  
        return sign * number;  
    }
}