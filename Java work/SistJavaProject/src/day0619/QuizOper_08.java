package day0619;

import java.util.Scanner;

public class QuizOper_08 {

	public static void main(String[] args) {
		// 월 급여를 입력해서 만원,천원,십원,일원의 갯수를 출력해보자
		// 예: 금액을 입력하시오
		/*
		 * 2565325
		 * 
		 * =======
		 * 만원: 256
		 * 천원: 5
		 * 백원: 3
		 * 십원: 2
		 * 일원: 5
		 * */
		
		Scanner sc=new Scanner(System.in);
		
		int money;
		
		System.out.println("금액을 입력하시오");
		money=sc.nextInt();
		
		System.out.println("=============");
		System.out.println("만원: "+(money/10000));
		System.out.println("천원: "+(money%10000)/1000);
		System.out.println("백원: "+(money%1000)/100);
		System.out.println("십원: "+(money%100)/10);
		System.out.println("일원: "+(money%10));

	}

}
