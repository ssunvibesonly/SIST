package day0703;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileException_04 {
	
	public static void read()
	{
		String fileName="C:\\sist0615\\file\\monday.txt"; //경로 표시할 땐 \\ or /
		BufferedReader br=null;
		FileReader fr=null;
		
		try {
			fr=new FileReader(fileName);
			
			System.out.println("파일을 열었어요!!!");
			
			br=new BufferedReader(fr); //버퍼 리더는 한줄씩 밖에 못읽음
			
			//여러줄 읽어야 하므로 while문
			while(true) {
				
				//메모장에서 내용을 한줄씩 읽어온다.
				String s=br.readLine();
				
				//마지막 줄일 경우 null값을 읽어서, null값일 경우 빠져나가기
				if(s==null)
					break;
				
				System.out.println(s);
			}
			
		} catch (FileNotFoundException e) { //파일이 없을 때 catch문
			
			// e.printStackTrace();
			System.out.println("파일이 없어요: "+e.getMessage());
			
		}catch(IOException e) { // String s=br.readLine(); 예외처리 발생할 때 처리문만 작성해준다.
			
		}finally {
			//자원은 항상 반대로 반납
			try {
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
		System.out.println("메모 정상 종료");
		
	}

}
