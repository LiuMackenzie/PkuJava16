public class Solution {
    public String addBinary(String a, String b) {
//计算字符串长度
		int aLength=a.length();
		int bLength=b.length();
		
		int maxNum=0;
		int[] intA;
		int[] intB;
		int j=0;
		//取得最大长度,并将两个字符串转换成int型数组，高位补0
		if(aLength>=bLength)
		{
			maxNum=a.length();
			intA=new int[maxNum];
			intB=new int[maxNum];
			for(int i=0;i<maxNum;i++)
			{				
				intA[i]= Integer.parseInt(String.valueOf(a.charAt(i)));
				if(i>=maxNum-bLength)
					intB[i]=Integer.parseInt(String.valueOf(b.charAt(j++)));
			}
		}
		else
		{
			maxNum=b.length();
			intA=new int[maxNum];
			intB=new int[maxNum];
			for(int i=0;i<maxNum;i++)
			{
				intB[i]=Integer.parseInt(String.valueOf(b.charAt(i)));
				if(i>=maxNum-aLength)
					intA[i]=Integer.parseInt(String.valueOf(a.charAt(j++)));
			}
		}
		int flag=0;
		int[] result=new int[maxNum];
		//逐位想加
		for(int i=maxNum-1;i>=0;i--)
		{
			if(intA[i]+intB[i]+flag>=2)
			{
				result[i]=(intA[i]+intB[i]+flag)%2;
				flag=1;	//进位
			}
			else
			{
				
				result[i]=intA[i]+intB[i]+flag;
				flag=0;
			}			
		}
		//将得到的int[]类型转换成string类型
		String res="";
		for(int i=0;i<maxNum;i++)
		{
			if(flag==1)
			{
				res="1";
				flag=0;
			}
			res=res+String.valueOf(result[i]);
		}
		return res;
    }
}