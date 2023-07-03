package day0629;


/*
 * 추상클래스는 new로 생성 못함
 * 추상메서드가 하나라도 존재하는 클래스를 추상 클래스라고 한다.
 * 추상클래스-일반 메서드, 추상 메서드 둘다 존재 가능
 * 0 */
abstract class Fruit{
	
	static final String MESSAGE="오늘은 비 많이 오는 날"; 
	
	//일반메서드
	public void getTitle() {
		
		System.out.println("우리는 추상클래스 공부중!!");
		
	}
	//추상메서드(미완성 메서드...선언문만 있고 구현부인 몸통이 없음)
	abstract public void showMessage(); //오버라이딩이 목적
}
	////////////////////////////////////////////////////////
	class Apple extends Fruit{
		
	@Override
	public void showMessage() {
		System.out.println("Apple_Message");
		System.out.println(Fruit.MESSAGE);
		
	}
		
	}
	///////////////////////////////////////////////////////
	class Banana extends Fruit{
		
		
		
		@Override
		public void showMessage() {
			System.out.println("Banana_Message");
			
		}
		
	}
	//////////////////////////////////////////////////////////////////
	class Orange extends Fruit{
		
		@Override
		public void showMessage() {
			System.out.println("Orange_Message");
			
		}
		
		
	}


//////////////////////////////////
public class ExAbstrict_08 {

	public static void main(String[] args) {

		//일반 생성 메서드 호출
		Apple apple=new Apple();
		Banana banana=new Banana();
		Orange orange=new Orange();		
		
		apple.showMessage();
		banana.showMessage();
		orange.showMessage();
		
		//다형성 : 상속받는 자식클래스가 많을 때 주로 사용
		//다형성은 하나의 변수로 여러가지 일을 처리할 때 이용
		//부모클래스명 변수명=new 자식클래스명();
		Fruit fruit=new Apple();
		fruit.showMessage();
		
		fruit=new Banana();
		fruit.showMessage();
		
		fruit=new Orange();
		fruit.showMessage();
		
		fruit.getTitle();
		
		
	}

}
