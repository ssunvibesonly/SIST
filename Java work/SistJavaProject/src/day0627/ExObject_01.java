package day0627;

public class ExObject_01 {

	//초기값 안주면 String형의 경우 잠정적으로 Null값을 갖는다,int형은 0, boolean은 거짓
	
	String name; //instance 변수..일반 인스턴스 멤버 변수는 객체 생성 후 각각 다른 값을 가질 수 있다. (꼭 객체 생성을 해주어야 한다.)
	static final String MESSAGE="Happy Day!!!"; 
	// static 변수는 대문자로 보통 나타내고 주로 상수로 선언할 때 사용하며 인스턴스 변수없이 클래스명으로 접근 가능하다.
	// 여러객체가 같은 값을 가져야 할 경우 주로 static으로 선언한다. / final은 static이라고 완전하게 표시할 때 주로 사용
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("static변수는 new로 생성없이 호출가능");
		System.out.println(ExObject_01.MESSAGE);
		System.out.println(MESSAGE);//같은 클래스기 때문에 MESSAGE만으로도 호출가능
		
		//MESSAGE="Nice Day!!!"; // final이라서 값변경 안됨(final 지우면 오류 안뜸)
		
		//클래스명 참조변수명=new 클래스명();
		ExObject_01 ex1=new ExObject_01(); //인스턴스 변수를 가져오기 위해 객체를 생성 해주었다.(생성자가 숨어있기 때문에 생성 가능)
		System.out.println(ex1.name);//null
		
		ex1.name="김철수";
		System.out.println(ex1.name);
		
		ExObject_01 ex2=new ExObject_01();
		ex2.name="홍길동";
		System.out.println(ex2.name);
		
		ExObject_01 ex3=new ExObject_01();
		ex3.name="장순영";
		System.out.println(ex3.name);
		
		System.out.println("다같이 사용하는 메세지: "+MESSAGE);
		
		
		
	}

}
