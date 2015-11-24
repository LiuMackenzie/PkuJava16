package solution;

public class Solution171 {
    public int titleToNumber(String s) {
    	//假设给出的s为AHDU
    	//则res的公式为：26^3*('A'-'A')+26^2('H'-'A')+26*('D'-'A')+'U'-'A'
        int res = 0;
        int len = s.length();
        int i = 0;
        while(i<len){
        	res = (int) (res + Math.pow(26, i)*(s.charAt(len-i-1)-'A'+1));
        	i++;
        }
        return res;
    }
}
