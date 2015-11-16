package readFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Question3 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br1 = new BufferedReader(new FileReader("src/readFile/Pride and Prejudice chapter1.txt"));
		BufferedReader br2 = new BufferedReader(new FileReader("src/readFile/Pride and Prejudice chapter2.txt"));
		String line = br1.readLine();
		int countA = 0;
		int countB = 0;
		int countIntersection = 0;
		String temp = null;
		List<String> listA = new ArrayList<String>();
		List<String> listB = new ArrayList<String>();
		List<String> listI = new ArrayList<String>();
		while(line!=null){
			String[] str = line.split("[\\s.:;?!,\"]"); //将有“'”的单词 算作一个单词
			for(String splited:str){
				if(!splited.trim().equals("")){
					temp = splited.toLowerCase();
					if(!listA.contains(temp)){
						listA.add(temp);
						countA++;
					}
				}
			}
			line = br1.readLine();
		}
		br1.close();
		line = br2.readLine();
		while(line!=null){
			String[] str = line.split("[\\s.:;?!,\"]"); //将有“'”的单词 算作一个单词
			for(String splited:str){
				if(!splited.trim().equals("")){
					temp = splited.toLowerCase();
					if(!listB.contains(temp)){
						listB.add(temp);
						countB++;
					}
					if(listA.contains(temp) && listB.contains(temp) && !listI.contains(temp)){
						countIntersection++;
						listI.add(temp);
						//System.out.println(temp); just for test
					}
				}
			}
			line = br2.readLine();
		}
		br2.close();
		float wdBelongToA = (float)(countA-countIntersection)/(float)countA;
		float wdBelongToB = (float)(countB-countIntersection)/(float)countB;
		System.out.println("文件A中有"+countA+"个单词");
		System.out.println("文件B中有"+countB+"个单词");
		System.out.println("wd属于A且wd不属于B的单词占A文件的百分比为"+wdBelongToA*100+"%");
		System.out.println("wd属于B且wd不属于A的单词占B文件的百分比为"+wdBelongToB*100+"%");
		
		
	}
}
