package day0621;

import java.util.Scanner;

public class ScannerFor_11 {
	
	public static void numSum() {
		//합계를 구할 숫자는? 100
		//1부터 i까지의 합은 (1+2+3+...+i)입니다.
		Scanner sc=new Scanner(System.in);
		
		int i;//키보드로 입력할 수 
		int sum=0;
		
		System.out.println("합계를 구할 숫자는?");
		i=sc.nextInt();
		
		for(int a=1;a<=i;a++) {
			sum+=a;
		}
		System.out.println("1부터 "+i+"까지의 합은: " +sum);
		
	}
	
	public static void factorialTest() {
		//1!=1
		//2!=2
		//3!=6
		
		//10!의 출력
		int result=1;
		for(int i=1;i<=10;i++) {
			result*=i;
			System.out.println(i+"!="+result);}
		
	}
	public static void quizFact() {
		//팩토리얼 구할 숫자를 입력
		//5!=120
		Scanner sc=new Scanner(System.in);
		
		int i;
		int result=1;
		
		System.out.println("팩토리얼 구할 숫자를 입력: ");
		i=sc.nextInt();
		
		for(int a=1;a<=i;a++) {
			result*=a;
		}
		System.out.println(i+"!="+result);
		
	}

	public static void main(String[] args) {
		//numSum();
		//factorialTest();
		quizFact();

	}

}
