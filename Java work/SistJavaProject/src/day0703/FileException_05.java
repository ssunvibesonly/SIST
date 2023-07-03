package day0703;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class FileException_05 {

	public static void read() {
		
		String fileName="C:\\sist0615\\file\\memo.txt";
		BufferedReader br=null;
		FileReader fr=null;
		
		try {
			fr=new FileReader(fileName);
			
			System.out.println("파일 안녕!");
			
			br=new BufferedReader(fr);
			
			while(true) {
				
				String s=br.readLine();
			
				if(s==null)
					break;
				
				System.out.println(s);
			}
		} catch(FileNotFoundException e) {
			
			System.out.println("파일이 없어요: "+e.getMessage());
		} catch(IOException e) {
			
		}finally {
			try {
				br.close();
				fr.close();
			} catch(IOException e) {
			e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		read();
		System.out.println("메모 종료");

	}

}
