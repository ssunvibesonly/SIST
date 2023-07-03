package day0622;

import java.util.Scanner;

public class QuizForWhile_08 {
	
	public static void quiz1() {
		/*
		 * 나이를 반복해서 입력받는다.
		 * 0이되면 빠져 나와서 출력한다.
		 * 나이가 50이상일 경우 a변수 증가
		 * 나이가 30이상일 경우 b변수 증가
		 * 그 나머지는 c변수를 증가 
		 * 
		 * ===================
		 * 50세 이상: 3명
		 * 30세 이상: 2명
		 * 그 이외: 1명
		 */
		
		Scanner sc=new Scanner(System.in);
		
		int age;
		int a=0,b=0,c=0;
		
		while(true) {
			System.out.println("나이를 입력: ");
			age=sc.nextInt();
			
			if(age==0) { // 제약 조건에 걸리기 때문에 whil(trune)문 조건 작성 전 반드시 break!
				System.out.println("프로그램 종료");
				break;
			}
			
			if(age>=50)
				a++;
			else if(age>=30)
				b++;
			else 
				c++;
	
		}
		System.out.println("===============");
		System.out.println("50세 이상: "+a+"명");
		System.out.println("30세 이상: "+b+"명");
		System.out.println("그 이외: "+c+"명");
	}
	
	public static void quiz2() {
		//Q.총 10개의 다양한 숫자(양수, 음수)를 입력받아 양수의 갯수와 음수의 갯수를 구하시오
		/*
		 * 1:45
		 * 2:-23
		 * .
		 * .
		 * .=============
		 * 양수 갯수: 6개
		 * 음수 갯수: 10개
		 */
		
		//1. import
		Scanner sc=new Scanner(System.in);
		
		//2. 변수
		int a; //입력할 수 
		int ynum=0,unum=0;//양수, 음수의 갯수 변수
		
		for(int i=0;i<10;i++) {
			System.out.println("숫자 입력: ");
			a=sc.nextInt();
			
			//양수 조건
			if(a>0) 
				ynum++;
			
			else if(a<0) //a==0도 있으므로 else if를 해주었다., a==0에 대한 조건은 명시하지 않았으므로 0은 카운트 되지 않는다.
				unum++;
			
		}
			System.out.println("==================");
			System.out.println("양수갯수: "+ynum);
			System.out.println("음수갯수: "+unum);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//quiz1();
		quiz2();
	}

	}
