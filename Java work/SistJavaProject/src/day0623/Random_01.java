package day0623;

public class Random_01 {

	public static void main(String[] args) {
		/*
		 * 자바에서 난수를 구하는 방법 2가지
		 * 1. Math.random() 메서드를 이용하는 방법 Math:클래스 .random:Math클래스 안의 랜덤, 기본이 double형
		 * 2. Random이라는 클래스를 생성해서 구하는 방법
		 */
		
		System.out.println("기본 난수 5개 발생");

		for(int i=1;i<=5;i++) {
			double a=Math.random();//random 수: 0.xxxxx~0.9xxxxxx
			System.out.println(a);
		}
		
		System.out.println("0~9사이의 난수 5개 발생");
		
		for(int i=1;i<=5;i++) {
			
			int a=(int)(Math.random()*10);//Math.random은 태생 자체가 double형이다. 따라서 int로 형변환을 위해
			System.out.println(a);//Math.random앞에 (int)해주고 Math.random에 대한 수식을 괄호처리 한다.
											//(Math.random()*10)
			
		}
		
		System.out.println("1~10사이의 난수 5개 발생");
		
		for(int i=1;i<=5;i++) {
			int a=(int)(Math.random()*10)+1;//1~10까지란 뜻
			System.out.println(a);
		}
		
		System.out.println("1~100사이의 난수 5개 발생");
		
		for(int i=1;i<=5;i++) {
			int a=(int)(Math.random()*100)+1;//1~100까지란 뜻
			System.out.println(a);
	
	}
		System.out.println("0~99사이의 난수 5개 발생");
		
		for(int i=1;i<=5;i++) {
			int a=(int)(Math.random()*100);//1~100까지란 뜻
			System.out.println(a);
	
}
}
}