public class Solution {
    public String addBinary(String a, String b) {
//�����ַ�������
		int aLength=a.length();
		int bLength=b.length();
		
		int maxNum=0;
		int[] intA;
		int[] intB;
		int j=0;
		//ȡ����󳤶�,���������ַ���ת����int�����飬��λ��0
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
		//��λ���
		for(int i=maxNum-1;i>=0;i--)
		{
			if(intA[i]+intB[i]+flag>=2)
			{
				result[i]=(intA[i]+intB[i]+flag)%2;
				flag=1;	//��λ
			}
			else
			{
				
				result[i]=intA[i]+intB[i]+flag;
				flag=0;
			}			
		}
		//���õ���int[]����ת����string����
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