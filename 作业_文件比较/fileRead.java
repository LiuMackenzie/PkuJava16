package homework;

import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.HashSet;
import java.util.Set;

class Word
{
	String value;	//具体单词
	int geshu;		//出现的个数
	Word next;		//将单词连起来
	public Word(String value,int geshu)
	{
		this.value=value;
		this.geshu=geshu;
		next=null;
	}
	public Word(){
		this.value="";
		this.geshu=0;
		next=null;
	}
}

public class fileword {
	public static void main(String[] args) throws IOException
	{		
		 Set<String> result = new HashSet<String>();	//集合运算后的输出结果
		 Set<String> set1 = new HashSet<String>();		//存放文件1
		 Set<String> set2 = new HashSet<String>();		//存放文件2
	
		 int num1,num2;//两个文件所含单词数
		 int numShare;	//两文件共同的单词的个数
		 
		 String url1="d:/text1.txt";	
		 String url2="d:/text2.txt";
		 
		 readfile(url1, set1);
		 readfile(url2, set2);
		
		 num1=set1.size();
		 num2=set2.size();
		 
		 //1.交集
        result.clear();
        result.addAll(set1);
        result.retainAll(set2);
        System.out.println("交集："+result);
        
        numShare=result.size(); //重复元素的个数
        
        //2.并集
        result.clear();
        result.addAll(set1);
        result.addAll(set2);
        System.out.println("并集："+result);
        
        //3.并集-交集/各自集合的个数
        System.out.println(num1+"*"+num2+"*"+numShare);
        System.out.println(String.format("word∈A且word∉B的个数为%s%%", (num1-numShare)*100.0/num1));//(文件1-重复)/文件1
        System.out.println(String.format("word∈B且word∉A的个数为%s%%", (num2-numShare)*100.0/num2));//(文件2-重复)/文件2
		
//		         //   循环10次
//		         for(int i=1;i<=10;i++)                   
//		         {
//		             xin=new Word("",0);
//		             lian=word.next;
//		             //找到单词链中个数最多的
//		             while(lian!=null)
//		             {
//		                 if(lian.geshu>xin.geshu)
//		                 {
//		                     xin=lian;
//		                 }
//		                 lian=lian.next;
//		             }
//		             //输出单词链中个数最多的
//		             System.out.println("弟"+i+"个 :"+xin.value+"个数："+xin.geshu);
//		             lian=word;
//		             //删除单词链中单词个数最多的
//		             while(lian.next!=null)
//		             {
//		                 if(lian.next.value.equals(xin.value))
//		                 {
//		                     lian.next=lian.next.next;
//		                     break;
//		                 }
//		                 lian=lian.next;
//		             }
//		         }
		
//		 Set<Integer> result = new HashSet<Integer>();
//	        Set<Integer> set1 = new HashSet<Integer>(){{
//	            add(1);
//	            add(3);
//	            add(5);
//	        }};
//
//	        Set<Integer> set2 = new HashSet<Integer>(){{
//	            add(1);
//	            add(2);
//	            add(3);
//	        }};
//

		     }

	private static void readfile(String url, Set<String> set) throws FileNotFoundException, IOException {
		Word word=new Word();
		Word lian;
		Word xin;
		String str="";
		FileReader f=new FileReader(url);
		char[] c=new char[1];	//每次读取一个字母
		int b=0;
		boolean exist=false;	//判断单词是否存在于word链中
		while((b=f.read(c))!=-1)	//每次读取一个字母直到最后
		{
			//如果字符为 换行、空格、单引号、双引号、逗号、句号 则为一个单词的结束和另一个单词的开始
			if(String.valueOf(c).equals("\r")||String.valueOf(c).equals("\n")||
					String.valueOf(c).equals(" ")||String.valueOf(c).equals(",")||String.valueOf(c).equals(".")||String.valueOf(c).equals("\"")||String.valueOf(c).equals("'"))
			{
				lian=word;
				
				while(lian!=null)
				{
					if(lian.value.equals(str))//如果单词在单词链中存在，则单词个数++
					{
						lian.geshu++;
						exist=true;
						break;
					}
					else
					{
						lian=lian.next;
					}
				}
				if(exist==false)//如果不猜在，则向单词链中添加
				{
					System.out.println(str);
					set.add(str);
					xin=new Word(str,1);
					xin.next=word.next;
					word.next=xin;
					str="";
				}
				else
				{
					exist=false;
					str="";
				}
			}
			else//单词
			{
				str+=String.valueOf(c);
			}
		}
	}
		 }
