package day0627;

public class InfoMain_08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Info_08 in1=new Info_08("장순영",28,"경기도 수원");
	
		//getMethod 변수 지정
		String name=in1.getStuName();
		int age=in1.getage();
		String addr=in1.getaddr();
		
		System.out.println("이름은 "+name+"이고 나이는 "+age+"세이며 주소는 "+addr+"입니다.");
	
		Info_08 in2=new Info_08("강연주", 27, "경기도 성남시");
		System.out.println("이름은 "+in2.getStuName()+"이고 나이는 "+in2.getage()+"세이며 주소는 "+in2.getaddr()+"입니다.");
		
		
		//디폴트 생성자로 생성 => 불러올 순 있으나 인자값있는 생성자처럼 바로 수정할 순 없다(초기값 지정해줘야함)
		Info_08 in3=new Info_08();
		System.out.println("이름: "+in3.getStuName()+"\n나이: "+in3.getage()+"\n주소: "+in3.getaddr());
		in3.stuName="차호성";
		in3.age=27;
		in3.addr="경기도 화성시";
		
		System.out.println("이름: "+in3.getStuName()+"\n나이: "+in3.getage()+"\n주소: "+in3.getaddr());
		
		
	}
	

}
