package solution;

import java.util.Arrays;

public class Solution242 {
    public boolean isAnagram(String s, String t) {
        /*��������
         * boolean res = false;
        if(s.length()!=t.length()){
        	return res;
        }else{
        	for(int i = 0;i<s.length();i++){
        		if(s.charAt(i)!=t.charAt(s.length()-1-i)){
        			return res;
        		}
        	}
        	return true;
        }*/
    	//˼·�ܼ򵥣������򣬺�Ƚ�����array�Ƿ�һ�����ɡ�
    	boolean res = false;
    	if(s.length()!=t.length()){
        	return res;
        }
    	char[] sa = s.toCharArray();
    	char[] ta = t.toCharArray();
    	Arrays.sort(sa);
    	Arrays.sort(ta);
    	for(int i = 0;i<t.length();i++ ){
    		if(sa[i]!=ta[i]){
    			return res;
    		}
    	}
    	return true;
    }
}
