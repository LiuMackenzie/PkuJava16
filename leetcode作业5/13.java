public class Solution {
    public int romanToInt(String s) {
        // 罗马数字共有7个，即I（1）、V（5）、X（10）、L（50）、C（100）、D（500）和M（1000）
        //重复次数：一个罗马数字最多重复3次。
        //1~9: {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        //10~90: {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        //100~900: {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        //1000~3000: {"M", "MM", "MMM"}.
        //右加左减：
            //在较大的罗马数字的右边记上较小的罗马数字，表示大数字加小数字。
            //在较大的罗马数字的左边记上较小的罗马数字，表示大数字减小数字。
            //分析罗马-->阿拉伯数字
            //eg:IV-->4,左减V-I=4 ; VI-->6,右加V+I=6
        
        //从前向后遍历罗马数字，如果某个数比前一个数小，则加上该数。反之，减去前一个数的两倍然后加上该数
        int result;
        result=toNumber(s.charAt(0));
        //error:for(int i=1;i<s.length;i++){
        for(int i=1;i<s.length();i++){
            if(toNumber(s.charAt(i))>toNumber(s.charAt(i-1))){
                result+=toNumber(s.charAt(i))-2*toNumber(s.charAt(i-1));
            }else
            {
                result+=toNumber(s.charAt(i));
            }
        }
        return result;
    }
    
    public int toNumber(char ch)
    {
        switch (ch)
        {
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
        }
        return 0;
    }
    
}