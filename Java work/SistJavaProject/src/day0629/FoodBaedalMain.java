package day0629;

public class FoodBaedalMain {

	public static void main(String[] args) {
		//일반
		Food food=new Food();
		food.order();
		food.baedal();
		System.out.println();
		
		//다형성
		FoodGage gage=new Food();
		gage.order();
		gage.baedal();
		
		

	}

}
