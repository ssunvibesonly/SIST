package spring.anno.last;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShopMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("annoContext4.xml"); //xml�� ��ϵ� ������ �θ����� ���
	
		JumunController jumun=(JumunController)app.getBean("jumunController");
		jumun.insertJumun("������", 1000000, "���");
		jumun.deleteJumun("2");
		jumun.selectJumun("������", 1000000, "���");
	
	}

}
