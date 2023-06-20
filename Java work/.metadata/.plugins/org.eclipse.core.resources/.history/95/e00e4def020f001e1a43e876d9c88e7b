package day0620;

import java.util.Calendar;
import java.util.Scanner;

public class ScannerReview_01 {

	public static void main(String[] args) {
		/*
		 * 태어난 연도 : 1997
		 * 이름 : 홍길동 
		 * 핸드폰번호 : 010-1234-5678
		 * 주소 : 서울시 동작구
		 * 
		 * ============================
		 * 		[개인정보]
		 * 이름 : 홍길동
		 * 나이 : 26세
		 * 연락처 : 010-1234-5678
		 * 주소 : 서울시 동작구
		 * */
		
		//import
		Scanner sc=new Scanner(System.in);
		Calendar cal=Calendar.getInstance();
		
		//변수선언
		String name,addr,ph;
		int born,age;
		
		//입력
		System.out.print("태어난 년도 : ");
		born=Integer.parseInt(sc.nextLine());//born=sc.nextInt();
		//Integer.parseInt("1997")=>1997 String => int
		
		System.out.println("이름 : ");
		name=sc.nextLine();
		
		System.out.println("핸드폰 번호 : ");
		ph=sc.nextLine();
		
		System.out.println("주소: ");
		addr=sc.nextLine();
		
		age=cal.get(cal.YEAR)-born;
		
		System.out.println("======================");
		System.out.println("\t[개인정보]");
		System.out.println("이름 : "+name);
		System.out.println("나이: "+age+"세");
		System.out.println("핸드폰번호 : "+ph);
		System.out.println("주소 : "+addr);
		
		
		
		
	}

}
