package day0620;

import java.util.Scanner;

public class QuizIfOper_05 {

	public static void main(String[] args) {
		/*
		 * 상품명? 아이패드
		 * 수량? 3
		 * 가격? 500000
		 * ===================
		 * 아이패드 3개는 총 1500000원 입니다.
		 * 3개이상은 10프로 DC가 됩니다.
		 * DC된 총 금액:1350000원
		 * */
		
		Scanner sc=new Scanner(System.in);
		
		String name;
		int num,price;
		int total;
		
		//입력	
		System.out.println("상품명?");
		name=sc.nextLine();
		
		System.out.println("수량?");
		num=sc.nextInt();
		
		System.out.println("가격?");
		price=sc.nextInt();
		
		//총금액계산
		total=num*price;
		
		//출력
		System.out.println(name+" "+num+"개는 총 "+total+"원 입니다.");
		
		//수량이 3개 이상이면 10% DC

		if(num>=3)//if문에서 변수앞에 자료형을 쓰고 싶으면 if문 내에서 출력까지 한다. 출력을 if문 외부에서 하려면 변수 작성도 if문 밖에 해줘야 한다.
		{  int dc=(int)(total*0.9); //0.9는 실수이기때문에 dc값이 double 형으로 나오지만 괄호로 묶고 (int)해주면 int형이 된다
			System.out.println("3개 이상은 10프로가 DC됩니다.");
			System.out.println("DC된 총 금액:" +dc+"원 입니다");
			
			 }
		
	}

}
