package solution;

public class Solution12 {
	public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int temp = num;
        int cur = 0; //当前需要处理的位
        //for循环用来确定num的位数
        for(int i = 3;i>=0;i--){
        	StringBuilder sb1 = new StringBuilder();
        	if(temp>=Math.pow(10.0,i)){
        		//cur记录当前处理的最高位的数值
        		cur = temp/(int)(Math.pow(10, i));
        		//如果有四位会做如下处理，因为不会大于3999，所以最高位只能是由M组成
        		if(i==3){
        			for(int j=0;j<cur;j++){
        				sb1.append("M");
        			}
        		}
        		//如果有三位会做如下处理
        		if(i==2){
    				if(cur<=3)
    					for(int j=0;j<cur;j++){
            				sb1.append("C");
            			}
    				if(cur==4)
    					sb1.append("CD");
    				if(cur>=5 && cur <9){
    					sb1.append("D");
    					for(int k = 0 ; k<cur-5;k++){
    						sb1.append("C");
    					}
    				}
    				if(cur==9){
    					sb1.append("CM");
    				}
        		}
        		//如果有二位会做如下处理
        		if(i==1){
        			if(cur<=3)
    					for(int j=0;j<cur;j++){
            				sb1.append("X");
            			}
    				if(cur==4)
    					sb1.append("XL");
    				if(cur>=5 && cur <9){
    					sb1.append("L");
    					for(int k = 0 ; k<cur-5;k++){
    						sb1.append("X");
    					}
    				}
    				if(cur==9){
    					sb1.append("XC");
    				}
        		}
        		//如果有一位会做如下处理
        		if(i==0){
        			if(cur<=3)
    					for(int j=0;j<cur;j++){
            				sb1.append("I");
            			}
    				if(cur==4)
    					sb1.append("IV");
    				if(cur>=5 && cur <9){
    					sb1.append("V");
    					for(int k = 0 ; k<cur-5;k++){
    						sb1.append("I");
    					}
    				}
    				if(cur==9){
    					sb1.append("IX");
    				}
        		}	
        	}
        	else {
        		continue;
        	}
        	temp = temp-cur*(int)Math.pow(10.0,i);
        	sb.append(sb1);
        }
        
        return sb.toString();
    }
}
