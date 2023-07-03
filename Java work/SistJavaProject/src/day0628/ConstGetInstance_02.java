package day0628;

class Test{
	
	public Test() {
		System.out.println("디폴트 생성자");
	}
	
	//생성자 대신 인스턴스를 반환해주는 메서드 -> Calendar가 호출되는 원리
	public static Test getInstance() {
		return new Test();
	}
	
	//일반 메서드
	public void writeMessage() {
		System.out.println("안녕?");
	}
}



////////////////////////////////////
public class ConstGetInstance_02 {

	public static void main(String[] args) {
		Test t1=new Test();
		t1.writeMessage();
		/////////////////////////////
	
		Test t2=Test.getInstance();
		t2.writeMessage();
	
	
	}

}
