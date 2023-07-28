package day0703;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileExcep_06 {
	
	public static void read() { //클래스에서는 안줘도 되지만 메서드에서는 초기값 반드시!!!!줘야함 
	
	String fileName="C:\\sist0615\\file\\score.txt";
	FileReader fr=null;
	BufferedReader br=null;
	int cnt=0;//총갯수
	int total=0;//총합계
	double avg=0;//평균

	//파일 읽기
	try {
		fr=new FileReader(fileName);
		
		System.out.println("파일 정상적으로 읽음");
	
		br=new BufferedReader(fr);
		
		while(true) {
			
			String s=br.readLine();
			
			//더이상 값이 없으면 종료
			if(s==null)
				break;
			
			cnt++;//읽은 갯수
			total+=Integer.parseInt(s);//합계
			
			System.out.println(s);
			
	} 
		//평균 구하기
		avg=(double)total/cnt;
		System.out.println("총갯수: "+cnt);
		System.out.println("총점: "+total);
		System.out.printf("평균: %.2f",avg);
		
	}catch (FileNotFoundException e) {
		// TODO: handle exception
		e.printStackTrace();
	
	}catch (IOException e) {
		// TODO: handle exception
	}finally {
		try {
			//자원은 오픈한 순서 반대로 닫기
			br.close();
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	}
	public static void main(String[] args) {
		read();
		

}
}
