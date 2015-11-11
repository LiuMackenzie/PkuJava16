public class Solution {
    public String intToRoman(int num) {
        //罗马数字
        //1~9: {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        //~90: {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        //100~900: {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        //1000~3000: {"M", "MM", "MMM"}.
        
        //eg: 213-->百：CC 十：X 个：III
        
        //拆分各位，对应用string拼接起来
        
        String[][] roman={
             {"","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
             {"","X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
             {"","C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
             {"","M", "MM", "MMM"}
        };
        
        String result="";
        int digit=0;//位数，个位十位百位....
        while(num!=0){
            int value=num%10; //最后一位的值
            result=roman[digit][value]+result;//字符串拼接，把个十百千拼接起来
            num=num/10; //左移一位
            digit++;
        }
        return result;
    }
}