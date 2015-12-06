package solution;

import java.util.Arrays;

public class Solution242 {
    public boolean isAnagram(String s, String t) {
        /*审题有误
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
    	//思路很简单，先排序，后比较两个array是否一样即可。
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
