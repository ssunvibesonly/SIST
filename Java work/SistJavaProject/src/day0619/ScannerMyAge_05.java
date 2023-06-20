package day0619;

import java.util.Calendar;
import java.util.Scanner;

public class ScannerMyAge_05 {

	public static void main(String[] args) {
		/*당신의 이름은? 김민희
		 * 당신의 출생년도는? 1997
		 * =============================
		 * 이름: 김민희
		 * 현재년도: 2023년
		 * 나이: 26세*/
		
		Scanner sc=new Scanner(System.in);
		Calendar cal=Calendar.getInstance();
		
		String name;
		int born;
		
		
		System.out.println("당신의 이름은?");
		name=sc.nextLine();
		
		System.out.println("당신의 출생년도는?");
		born=sc.nextInt();
		
		int age=cal.get(cal.YEAR)-born;
		
		System.out.println("===================");
		System.out.println("이름: "+name);
		System.out.println("현재년도: "+cal.get(cal.YEAR)+"년");
		System.out.println("나이: "+age+"세");
		

		/* 선생님 풀이(현재년도를 변수에 대입해서 작성하셨다)
	 	//생성
		Scanner sc=new Scanner(System.in);
		Calendar cal=Calendar.getInstance();
		
		//변수
		String name;
		int born;
		int age;
				
		int curYear=cal.get(cal.YEAR); //2023 -> 현재년도를 변수로 설정해서 할 수도 있음
		
		//입력
		System.out.print("당신의 이름은? ");
		name=sc.nextLine();
		System.out.print("당신의 출생년도는? ");
		myYear=sc.nextInt(); 
		
		//나이계산
		age=curYear-born; -> 현재 년도를 curYear로 만들어 줬기때문에 curYear-born=나이
		
		//최종출력
		System.out.println("===============================");
		System.out.println("이름: "+name);
		System.out.println("현재년도 "+curYear+"년도");
		System.out.println("나이: "+age+"세");*/
	}

}
