package solution;

public class Solution13 {
    public int romanToInt(String s) {
        int res = 0;
        int len = s.length();
        int i = 0;
        //�Ӹ�λ����λ���δ����ַ������չ���M����ʾ1000��CM��ʾ900��CD��ʾ400��C��ʾ100��
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
        	//��CΪ���һλ ѭ������ ����res
        	if(s.charAt(i)=='C' && i+1==len){
        		res = res + 100;
        		break;
        	}
        	//D��ʾ500��XC��ʾ90��XL��ʾ40��X��ʾ10,
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
        	//��XΪ���һλ������ѭ�� ����res
        	if(s.charAt(i)=='X' && i+1==len){
        		res = res + 10;
        		break;
        	}
        	//L��ʾ50��IX��ʾ9��IV��ʾ4��I��ʾ1
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
        	//��IΪ���һλ��������ѭ��
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
