package day0627;

public class QuizMain_10 {

	public static void main(String[] args) {
		System.out.println("**상품입고**");
		System.out.println("-------------------------");
		
		Quiz_10.SHOPNAME="롯데마트";
		
		System.out.println("입고된 상점: "+Quiz_10.SHOPNAME);
		System.out.println("-------------------------");
		
		//1
		Quiz_10 s1=new Quiz_10();
		s1.setSangpum("딸기");
		s1.su=5000;
		s1.dan=10000;
		System.out.println("상품명: "+s1.getSangpum());
		System.out.println("가격: "+s1.dan+"원");
		System.out.println("수량: "+s1.su+"팩");
		System.out.println("-------------------------");
		
		//2
		Quiz_10 s2=new Quiz_10();
		s2.setSangpum("쵸코파이");
		s2.su=10;
		s2.dan=5000;
		System.out.println("상품명: "+s2.getSangpum());
		System.out.println("가격: "+s2.su+"상자");
		System.out.println("수량: "+s2.dan+"원");
		System.out.println("-------------------------");
		
		//3
		Quiz_10 s3=new Quiz_10();
		s3.setSangpum("요거트");
		s3.su=100;
		s3.dan=2500;
		System.out.println("상품명: "+s3.getSangpum());
		System.out.println("가격: "+s3.dan+"원");
		System.out.println("수량: "+s3.su+"팩");
		
		

	}

}
