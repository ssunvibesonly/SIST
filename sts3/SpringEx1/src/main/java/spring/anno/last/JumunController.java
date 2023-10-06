package spring.anno.last;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JumunController {
	
	@Autowired
	Shopinter shopInter;
	
	int cnt=10;
	String name="홍성경";
	
	//결국 shopinter를 사용하기 위해서 컨트롤러에서 다시 메소드 만들어준거임 (컨트롤러에서 dao를 호출해서 사용함)
	public void insertJumun(String sang,int price,String color) {
		shopInter.insertSangpum(sang, price, color);
		System.out.println(name+"님이 "+cnt+"개를 주문함!");
	}
	
	public void deleteJumun(String num) {
		shopInter.deleteSangpum(num);
	}
	
	public void selectJumun(String sang,int price,String color) {
		System.out.println("주문자: "+name);
		shopInter.selectShop(sang, price, color);
		System.out.println("주문 갯수: "+cnt);
	}
}
