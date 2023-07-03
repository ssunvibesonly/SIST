package day0627;

public class Info_08 {

	String stuName;
	int age;
	String addr;
	
	//생성자
	public Info_08() {
		
	}
	
	
	
	//명시적 생성자..생성과 동시에 멤버 초기화 => 명시적 생성자가 있으면 디폴트 생성자는 자동으로 생성되지 않는다.
	public Info_08(String name,int age,String addr) {
		
		stuName=name;
		this.age=age;
		this.addr=addr;
		
	}
	
	//getter메서드
	public String getStuName() {
		
		return stuName;
		
	}
	
	public int getage() {
		
		return age;
		
	}
	
	public String getaddr() {
		
		return addr;
	}
	
	
	
	
	
	
}
