package spring.anno.ex6;

import org.springframework.stereotype.Component;

@Component
public class TestDao {

	public void insert(String irum) {
		System.out.println(irum+"�� db�� �߰���");
	}
	
	public void delete(String num) {
		System.out.println(num+"�� ������ ����");
	}
	
	public void select(String irum) {
		System.out.println(irum+"���� ������ ��� 20�� ���� �Դϴ�.");
	}
	
}
