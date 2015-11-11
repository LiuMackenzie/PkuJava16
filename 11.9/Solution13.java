package solution;

public class Solution13 {
    public int romanToInt(String s) {
        int res = 0;
        int len = s.length();
        int i = 0;
        //从高位到低位依次处理字符，按照规则‘M’表示1000，CM表示900，CD表示400，C表示100，
        while(i<len){
        	
        	if(s.charAt(i)=='M'){
        		res = res + 1000;
        		i++;
        		continue;
        	}
        	if(s.charAt(i)=='C' && i+1<len && s.charAt(i+1)=='M'){
        		res = res + 900;
        		i=i+2;
        		continue;
        	}
        	if(s.charAt(i)=='C' && i+1<len && s.charAt(i+1)=='D'){
        		res = res + 400;
        		i=i+2;
        		continue;
        	}
        	if(s.charAt(i)=='C' && i+1<len && s.charAt(i+1)!='D'){
        		res = res + 100;
        		i++;
        		continue;
        	}
        	//若C为最后一位 循环结束 返回res
        	if(s.charAt(i)=='C' && i+1==len){
        		res = res + 100;
        		break;
        	}
        	//D表示500，XC表示90，XL表示40，X表示10,
        	if(s.charAt(i)=='D'){
        		res = res + 500;
        		i++;
        		continue;
        	}
        	if(s.charAt(i)=='X' && i+1<len && s.charAt(i+1)=='C'){
        		res = res + 90;
        		i = i+2;
        		continue;
        	}
        	if(s.charAt(i)=='X' && i+1<len && s.charAt(i+1)=='L'){
        		res = res + 40;
        		i=i+2;
        		continue;
        	}
        	if(s.charAt(i)=='X' && i+1<len && s.charAt(i+1)!='L'){
        		res = res + 10;
        		i++;
        		continue;
        	}
        	//若X为最后一位则跳出循环 返回res
        	if(s.charAt(i)=='X' && i+1==len){
        		res = res + 10;
        		break;
        	}
        	//L表示50，IX表示9，IV表示4，I表示1
        	if(s.charAt(i)=='L'){
        		res = res + 50;
        		i++;
        		continue;
        	}
        	if(s.charAt(i)=='I' && i+1<len && s.charAt(i+1)=='X'){
        		res = res + 9;
        		i = i+2;
        		continue;
        	}
        	if(s.charAt(i)=='I' && i+1<len && s.charAt(i+1)=='V'){
        		res = res + 4;
        		i=i+2;
        		continue;
        	}
        	if(s.charAt(i)=='I' && i+1<len && s.charAt(i+1)!='V'){
        		res = res + 1;
        		i++;
        		continue;
        	}
        	//若I为最后一位，则跳出循环
        	if(s.charAt(i)=='I' && i+1==len){
        		res = res + 1;
        		break;
        	}
        	if(s.charAt(i)=='V'){
        		res = res + 5;
        		i++;
        		continue;
        	}
        }
        return res;
    }
}
