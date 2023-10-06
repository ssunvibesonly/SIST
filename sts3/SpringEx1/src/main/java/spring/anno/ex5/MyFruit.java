package spring.anno.ex5;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyFruit {
	
	//@Autowired
	//single match�� �ϳ��� ���� �� Autowired���.
	//��Ȯ�ϰ� bean�� �̸����� �����Ϸ���?
	@Resource(name="kfruit")
	Fruit fruit;
	
	public void writeFruit() {
		System.out.println("���� �����ϴ� ������ **");
		fruit.writeFruiteName();
	}
	
}