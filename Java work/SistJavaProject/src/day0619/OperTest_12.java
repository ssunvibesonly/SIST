package day0619;

import java.util.Calendar;
import java.util.Scanner;

public class OperTest_12 {

	public static void main(String[] args) {
		// 삼항연산자로 조건 12...태어난 년도로 띠 구해보기
		// 로직에서 언제나 시작은 원숭이띠
		
		Scanner sc=new Scanner(System.in);
		Calendar cal=Calendar.getInstance();
		
		String name,ddi;
		int myYear;
		
		
		System.out.println("이름 입력:");
		name=sc.nextLine();
		
		System.out.println("태어난 년도 입력:");
		myYear=sc.nextInt();
		
		int age=cal.get(cal.YEAR)-myYear;//나이 출력 시 현재년도 - 태어난 년도
		
		ddi=myYear%12==0?"원숭이":
			myYear%12==1?"닭":
				myYear%12==2?"개":
					myYear%12==3?"돼지":
						myYear%12==4?"쥐":
							myYear%12==5?"소":
								myYear%12==6?"호랑이":
									myYear%12==7?"토끼":
										myYear%12==8?"용":
											myYear%12==9?"뱀":
												myYear%12==10?"말":"양";
		
		System.out.println("**나이와 띠 구하기**");
		System.out.println("이름: "+name);
		System.out.println("나이: "+age+"세");
		System.out.println("띠: "+ddi);
		

	}

}
