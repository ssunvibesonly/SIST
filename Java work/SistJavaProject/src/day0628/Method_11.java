package day0628;

/*
 * 메서드 작성요령
 * 접근 제한자(ex.public)+지정예약어(static: 없을수도 있음-> 없으면 new객체 생성해줘야함)+결과 리턴형(void or int or String..)+메서드명(){};
 * 1. 반복적인 코드를 줄여서 코드의 관리가 용이하게 표현
 * 2. 하나의 메서드는 한가지 기능ㄴ만을 수행하도록 작성 
 * 
 * */

public class Method_11 {

	public static boolean aaa() {
		return false;
		
	}
	
	public static int bbb() {
		return 719;
	}
	
	public static int ccc(int x,int y) {
		
		int z=x+y;
		return z;
	}
	
	public static void main(String[] args) {

		boolean a=aaa();
		System.out.println("a= "+a);
		
		int b=bbb();
		System.out.println("b= "+b);

		int c=ccc(3,5);
		System.out.println("c= "+c);
	}

}
