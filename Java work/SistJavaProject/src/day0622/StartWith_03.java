package day0622;

import java.util.Scanner;

public class StartWith_03 {

	public static void main(String[] args) {
		// 이름을 반복해서 입력하여 이씨가 몇명인지 알아보자
		// 종료==끝 
		Scanner sc=new Scanner(System.in);
		
		String name;
		int cnt=0;
		
		while(true) {
			System.out.println("이름을 입력하시오(끝==종료): ");
			name=sc.nextLine();
			
			//break문
			if(name.equals("끝"))
				break;
			
			//조건
			if(name.startsWith("이"))
				cnt++;
		}
		
		System.out.println("이씨 성을 가진 사람은 총 : "+cnt+"명 입니다.");

	}

}
