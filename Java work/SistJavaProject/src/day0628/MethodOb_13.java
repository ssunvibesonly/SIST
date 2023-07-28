package day0628;

public class MethodOb_13 {

	public static void hello(int age,double height){
		
		System.out.println("안녕");
		System.out.println("제 나이는 "+age+"세 입니다.");
		System.out.println("저의 키는 "+height+"cm 입니다.");
	}
	
	
	public static void main(String[] args) {


		System.out.println("메서드 연습 시작!!!");
		
		
		hello(28, 167.5);
		goodbye();
		System.out.println("메서드 연습 끝!");
		hello(22, 175.4);
		
	}
	
	public static void goodbye() {
		System.out.println("담에 봬요");
	}

}
