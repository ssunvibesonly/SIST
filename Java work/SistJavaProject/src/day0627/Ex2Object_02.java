package day0627;

public class Ex2Object_02 {
	
	
	//2개의 인스턴스 변수, 2개의 static변수(클래스 변수)_4개의 멤버 변수
	String kind; //카드의 무늬
	int num; //카드의 숫자
	
	//클래스 변수: 같은 클래스의 모든 인스턴스들이 공유
	//인스턴스 생성없이 클래스 이름.클래스 변수명으로 접근 가능
	//클래스가 로딩될 때 생성, 종료하면 소멸
	static int width; //카드의 폭
	static int height;//카드의 높이

	
}
