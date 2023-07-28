package day0628;

class Apple{
	
	private String writer;
	private String subject;
	private static String msg="Happy Day!!"; //private면 static도 그냥 멤버변수로 접근안됨
	
	//각각의 set, get
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public static String getMsg() {
		return msg;
	}
	public static void setMsg(String msg) { //static은 참조변수 this가 없으므로 클래스명.변수=파라메터 변수명;
		Apple.msg = msg;
	}
	

	
}


//////////////////////////////////
public class ExObject_08 {

	public static void writeApple(Apple apl) {//Apple이라는 클래스 통째로 가져와서 Apple클래스 자체의 변수를 apl로 지정
												//공통으로 적용되는 내용들이기 때문에 static 메소드
		
		System.out.println("***Apple클래스 출력***");
		
		System.out.println("작성자: "+apl.getWriter());
		System.out.println("제목: "+apl.getSubject()); //출력만 다른 클래스에서 하기위해 작성한 것이고, 결국 main부에 apple클래스에 해당하는걸 생성하지 않으면 못가져옴
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("Apple클래스의 메세지 출력");
		System.out.println(Apple.getMsg());
		
		Apple a1=new Apple();
		a1.setWriter("김은희");
		a1.setSubject("악귀 재밌더라구요");
		
		Apple a2=new Apple();
		a2.setWriter("김동수");
		a2.setSubject("초보 개발자의 하루");
		
		//writeApple 호출
		writeApple(a1);
		writeApple(a2);
		
		
		
		
	}

}
