public class Solution {
    public String intToRoman(int num) {
        //��������
        //1~9: {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        //~90: {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        //100~900: {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        //1000~3000: {"M", "MM", "MMM"}.
        
        //eg: 213-->�٣�CC ʮ��X ����III
        
        //��ָ�λ����Ӧ��stringƴ������
        
        String[][] roman={
             {"","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
             {"","X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
             {"","C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
             {"","M", "MM", "MMM"}
        };
        
        String result="";
        int digit=0;//λ������λʮλ��λ....
        while(num!=0){
            int value=num%10; //���һλ��ֵ
            result=roman[digit][value]+result;//�ַ���ƴ�ӣ��Ѹ�ʮ��ǧƴ������
            num=num/10; //����һλ
            digit++;
        }
        return result;
    }
}