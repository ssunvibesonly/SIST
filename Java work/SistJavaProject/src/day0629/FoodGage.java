package day0629;

public interface FoodGage {

	//인터페이스는 상수와 추상메서드만 선언이 가능하다.
	String SHOPNAME="보슬보슬";//상수 final을 쓰지 않아도 interface에는 상수만 올 수 있기때문에 final 생략 가능
	
	public void order(); //abstract 생략..어차피 추상메서드만 올 수 있으므로
	public void baedal();
}
