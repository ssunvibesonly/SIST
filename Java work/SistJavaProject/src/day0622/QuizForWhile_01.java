package day0622;

public class QuizForWhile_01 {

	
	//메서드 오버로딩 : ()인자값이 다르면 변수명이 같아도 오류가 안난다.(상관 없움)
/*	public static void quiz1() {
		//가로로 출력_for_1 2 3 4 5 그리고 다음줄에 종료라고 출력하시오
		
		int a;
		for(a=1;a<=5;a++) {
			System.out.print(a+" ");
		}
		System.out.println();
		System.out.println("종료");//\n해도 된다.
		
		
	}*/
	
	public static void quiz2() {
		//가로로 출력_for_1 2 4 5 7 8 10 (3의배수 제외)_continue사용
		int a;
		for(a=1;a<=10;a++) {
			//3의 배수는 빼고 출력
			if(a%3==0)
				continue;
			System.out.print(a+" ");
		}
		System.out.println();
		System.out.println("종료");
		
	}
	
	public static void quiz3() {
		
		//안녕 을 가로로 3번 출력하세요
		for(int a=1;a<=3;a++) {
			System.out.printf("안녕 " );
		}	
	}
	
	public static void quiz4() {
		 
		//1부터 10까지 중 짝수만 가로로 출력하세요
		for(int a=1;a<=10;a++) {
			if(a%2==0)
				System.out.print(a+ " ");
		}
	}
	
	public static void quiz5() {
		
		//1부터 10까지의 합은 55입니다.
		int sum=0;
		
		for(int i=1;i<=10;i++) { //i를 지역변수로 쓰면 for문에서만 i를 쓸 수 있다. 
			sum+=i;				//for문 바깥에 i를 사용해 출력해야 된다면 for문 위에 int i;를 선언해준다.
	}
	System.out.println("1부터 10까지의 합은 "+sum);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//quiz1();
		//quiz2();
		//quiz3();
		//quiz4();
		quiz5();
		
	}

}
