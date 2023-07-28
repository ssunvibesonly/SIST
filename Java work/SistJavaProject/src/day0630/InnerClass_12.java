package day0630;

class Outer{
	
	String name="이민규";
	int age=22;
	
	
	class Inner{
	
		//내부에서는 외부클래스 사용 가능
		public void disp() {
			System.out.println("**Inner내부 클래스**");
			System.out.println("이름: "+name+" ,나이: "+age);
		}
		
		
	}
	
	class Inner2{
		
		//내부에서는 외부클래스 사용 가능
		public void disp2() {
			System.out.println("**Inner2내부 클래스**");
			System.out.println("이름: "+name+" ,나이: "+age);

		}
	
	}	
	//외부의 메서드 추가	
	public void write() {
		
		//외부에서 내부 클래스 선언
		Inner in1=new Inner();
		in1.disp();
		
		Inner2 in2=new Inner2();
		in2.disp2();
		
	}
}


public class InnerClass_12 {
	
	public static void main(String[] args) {
		
		Outer out =new Outer();
		out.write();
		
		System.out.println("========================");

		System.out.println("다른 클래스 통하지 않고 직접 내부 클래스 메서드 호출");
		
		Outer.Inner outin=new Outer().new Inner();
		outin.disp();
		
		Outer.Inner2 outin2=out.new Inner2();
		outin2.disp2();

		
		
	}

}
