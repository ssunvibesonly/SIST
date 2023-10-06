package spring.anno.last;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShopMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("annoContext4.xml"); //xml에 등록된 값들을 부를때만 사용
	
		JumunController jumun=(JumunController)app.getBean("jumunController");
		jumun.insertJumun("아이폰", 1000000, "흰색");
		jumun.deleteJumun("2");
		jumun.selectJumun("아이폰", 1000000, "흰색");
	
	}

}
