package readFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Union {
	public static void main(String[] args) throws IOException{
		BufferedReader br1 = new BufferedReader(new FileReader("src/readFile/Pride and Prejudice chapter1.txt"));
		BufferedReader br2 = new BufferedReader(new FileReader("src/readFile/Pride and Prejudice chapter2.txt"));
		File newfile = new File("src/readFile/Union.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(newfile));
		String line = br1.readLine();
		List<String> list = new ArrayList<String>();
		while(line!=null){
			String[] str = line.split("[\\s.:;?!,\"]");  //将有“'”的单词 算作一个单词
			for(String splited:str){
				if(!splited.trim().equals("")){
					//System.out.println(1);  just for test
					String temp = splited.toLowerCase();
					if(!list.contains(temp)){
						list.add(temp);
						bw.write(temp);
						bw.write("\r\n");
					}
				}
			}
			line = br1.readLine();
		}
		br1.close();
		line = br2.readLine();
		while(line!=null){
			String[] str = line.split("[\\s.:;?!,\"]");  //将有“'”的单词 算作一个单词
			for(String splited:str){
				if(!splited.trim().equals("")){
					String temp = splited.toLowerCase();
					if(!list.contains(temp)){
						list.add(temp);
						bw.write(temp);
						bw.write("\r\n");
					}
				}
			}
			line = br2.readLine();
		}
		System.out.print("OK");
		br2.close();
		bw.flush();
		bw.close();
	}
}
