public class Solution {
    public int romanToInt(String s) {
        // �������ֹ���7������I��1����V��5����X��10����L��50����C��100����D��500����M��1000��
        //�ظ�������һ��������������ظ�3�Ρ�
        //1~9: {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        //10~90: {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        //100~900: {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        //1000~3000: {"M", "MM", "MMM"}.
        //�Ҽ������
            //�ڽϴ���������ֵ��ұ߼��Ͻ�С���������֣���ʾ�����ּ�С���֡�
            //�ڽϴ���������ֵ���߼��Ͻ�С���������֣���ʾ�����ּ�С���֡�
            //��������-->����������
            //eg:IV-->4,���V-I=4 ; VI-->6,�Ҽ�V+I=6
        
        //��ǰ�������������֣����ĳ������ǰһ����С������ϸ�������֮����ȥǰһ����������Ȼ����ϸ���
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