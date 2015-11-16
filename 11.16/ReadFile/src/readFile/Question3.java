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
			String[] str = line.split("[\\s.:;?!,\"]"); //���С�'���ĵ��� ����һ������
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
			String[] str = line.split("[\\s.:;?!,\"]"); //���С�'���ĵ��� ����һ������
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
		System.out.println("�ļ�A����"+countA+"������");
		System.out.println("�ļ�B����"+countB+"������");
		System.out.println("wd����A��wd������B�ĵ���ռA�ļ��İٷֱ�Ϊ"+wdBelongToA*100+"%");
		System.out.println("wd����B��wd������A�ĵ���ռB�ļ��İٷֱ�Ϊ"+wdBelongToB*100+"%");
		
		
	}
}
