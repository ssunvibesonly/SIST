package day0627;


public class Ex2Main_02 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//클래스 변수(static변수)에 값을 지정해주지 않으면 초기값은 0이다.
		System.out.println(Ex2Object_02.width);
		System.out.println(Ex2Object_02.height);
		
		//클래스변수
		Ex2Object_02.width=10;
		Ex2Object_02.height=20;
		
		System.out.println(Ex2Object_02.width);
		System.out.println(Ex2Object_02.height);
		
		//인스턴스 생성 후 변수 호출가능
		Ex2Object_02 card1=new Ex2Object_02();//Ex2Object_02 card1;
											//card1=new ExObject_02();
		
		System.out.println(card1.kind); //null
		System.out.println(card1.num); //0
		
		card1.kind="Heart";
		card1.num=4;
		
		System.out.println(card1.kind);
		System.out.println(card1.num);
		
		//인스턴스 변수 생성 후 변경 후 출력
		
		Ex2Object_02 card2=new Ex2Object_02();
		card2.kind="Space";
		card2.num=7;
		
		System.out.println(card2.kind);
		System.out.println(card2.num);
		
		
		
		
	}

}
