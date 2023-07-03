package day0629;

// class가 class : extends
// class가 interface : implements
// interface가 interface : extends
// implements 다중 구현 가능하다.
public class Food implements FoodGage {

	@Override
	public void order() {
		
		System.out.println(SHOPNAME);
		//SHOPNAME="돈까스집"; (final이라 변경이 안됨)
		System.out.println("음식을 주문합니다.");
		
	}

	@Override
	public void baedal() {

		System.out.println(SHOPNAME);
		System.out.println("음식을 배달합니다.");
		
		
	}


}
