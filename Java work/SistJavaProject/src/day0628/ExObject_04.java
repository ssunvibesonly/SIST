package day0628;

class MyInfo{
	
	private String name;
	private int age;
	private String hp;
	public static final String  ADDR="Seoul";
	
	
	public void setName(String name) {
		this.name=name;
}
	public void setAge(int age) {
		this.age=age;
	}
	
	public void setHp(String hp) {
		this.hp=hp;	
	}

	public String getName() {
		return name;

	}

	public int getAge() {
		return age;
		
	}
	public String getHp() {
		return hp;
	}
	
	
	//3개의 멤버를 한번에 변경할 메서드
	public void setData(String name,int age,String hp) {
		this.name=name;
		this.age=age;
		this.hp=hp;
	}
	
	
	//3개의 멤버를 한번에 출력
	public void getData() {
		System.out.println("이름: "+this.name+", 나이: "+age+", 핸드폰: "+hp);
	}
	
}
////////////////////////////////
public class ExObject_04 {

	public static void main(String[] args) {
		
		MyInfo in1=new MyInfo();
		//setter
		in1.setName("이소용");
		in1.setAge(22);
		in1.setHp("010-111-2222");
		
		//getter
		String name=in1.getName();
		int age=in1.getAge();
		String hp=in1.getHp();
		
		//출력
		System.out.println("사는지역:"+MyInfo.ADDR);
		System.out.println("이름: "+name+", 나이: "+age+", 핸드폰: "+hp);
		System.out.println("---------------------------------");
		
		
		//생성2
		
		MyInfo in2=new MyInfo();
		
		//set Data
		in2.setData("이성신", 22, "010-111-2222");//==MyInfo in2=new Myinfo("이성신", 22, "010-111-2222") : 명시적 생성자 생성시
		in2.getData();
	}
		

	}


