package day0703;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class FileToken_08 {

	public static void fruitread() {
		
		String fileName="C:\\sist0615\\file\\fruit.txt";
		FileReader fr=null;
		BufferedReader br=null;
		
		try {
			fr=new FileReader(fileName);
			br=new BufferedReader(fr);
			
			System.out.println("**과일 목록**");
			System.out.println("상품\t수량\t단가\t총금액");
			System.out.println("-------------------------------");
			
			while(true) {
				String s=br.readLine();
				
				if(s==null)
					break;
				
			/*	//분리1
				StringTokenizer st=new StringTokenizer(s, ",");
				
				//배열 갯수만큼 반복 출력
				String sang=st.nextToken();
				int su=Integer.parseInt(st.nextToken());
				int dan=Integer.parseInt(st.nextToken());
				int total=su*dan;*/

				//분리2
				String[]info=s.split(",");
				
				String sang=info[0];
				int su=Integer.parseInt(info[1]);
				int dan=Integer.parseInt(info[2]);
				int total=su*dan;
				
				System.out.println(sang+"\t"+su+"개\t"+dan+"원\t"+total+"원");
				
				
			}

			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
		}
		
	}
	
	public static void main(String[] args) {
		fruitread();

	}

}
