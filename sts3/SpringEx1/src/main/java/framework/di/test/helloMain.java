package framework.di.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class helloMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("�ڹ� ������� hello�޼��� ȣ���ϱ�");
		
		hello hello1=new hello();
		System.out.println(hello1.getMessage());
		
		hello hello2=new hello();
		System.out.println(hello2.getMessage());
		
		System.out.println(hello1==hello2); //�ڹٿ����� new�� ������ ������ �ٸ� �ּҿ� ������ �ٸ����̴�.
		
		System.out.println("������ ������� hello �޼��� ȣ���ϱ�");
		//xml���� ��������..������ ����� web.xml�� ������ �Ǿ������Ƿ� �ʿ����.
		
		ApplicationContext app1=new ClassPathXmlApplicationContext("helloContext.xml");
		//hello��ü ����
		hello h1=(hello)app1.getBean("hello"); //���1//helloContext.xml�� �� name�� ���ش�.
		System.out.println(h1.getMessage());
		
		hello h2=app1.getBean("hello", hello.class); //���2
		System.out.println(h2.getMessage());
		
		System.out.println(h1==h2); //�����ּҰ� ����..������������ �⺻�� �̱���
		
	}

}
