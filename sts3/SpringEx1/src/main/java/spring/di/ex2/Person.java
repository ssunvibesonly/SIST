package spring.di.ex2;

public class Person {

	String schoolName;
	Myinfo info;
	
	public Person(Myinfo info) {
		super();//super()�� ���൵ �ǰ� �Ƚ��൵ �ȴ�. ���� �ʾҴٸ� �׳� �����Ǿ��ִ� ���̴�.
		this.info=info;
	}

	//setter
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	//���
	public void writeData() {
		
		System.out.println("**�л� ���� ���**");
		System.out.println("�б���: "+schoolName);
		System.out.println("�л���: "+info.name);
		System.out.println("����: "+info.age);
		System.out.println("�ּ�: "+info.addr);
	}
	
}
