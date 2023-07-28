package day0629;

import day0629_1.SuperObj;

public class SubObj_03 extends SuperObj { //자식클래스 extends 부모클래스 
	
	String addr;
	
	public SubObj_03(String name, int age, String addr) { //명시적 생성자를 만들었는데 디폴트 생성자를 만들면 오류뜸 , 자식의 String addr 추가
		super(name, age);
		this.addr=addr;
		//this.addr=addr; 상속받은게 우선이기 때문에 자식께 상속받은 것보다 위에있으면 오류남
							//반드시 첫줄-> 부모 생성자 호출
		
	}
	public void write() {
		
		System.out.println("이름: "+this.name);
		System.out.println("나이: "+this.age);
		System.out.println("주소: "+this.addr);
	}
	
	
	
}
