package day0628;

class Member{
	
	private String stuname;//학생명
	private String gender;//성별
	private String addr;//주소
	
	static String ban;
	static int cnt=0;//cnt=0; 해주지 않아도 초기값은 0이다.
	
	//수정용 메서드 
	public void setMembers(String name,String gd,String addr) {
		stuname=name; //this.stuname=name 
		gender=gd; //this.gender=gd
		this.addr=addr;
	}
	
	//출력용 메서드
	public void getMembers() {
		
		cnt++;
		
		System.out.println("**학생"+cnt+"정보***");
		System.out.println("학생명: "+stuname);
		System.out.println("소속학급: "+Member.ban);//같은 클래스에서 출력이므로 그냥 ban이라고 해도 된다
		System.out.println("성별: "+this.gender);//gender==this.gender
		System.out.println("주소: "+addr);
		System.out.println("--------------------------------------");
		
	}
		
}



/////////////////////////////////////////////
public class ExObject_06 {

	public static void main(String[] args) {
		Member.ban="쌍용 자바 7강의장";//static이므로 공통적으로 사용하기 때문에 한번만 호출하면 된다.
		
		Member m1=new Member();
		m1.setMembers("최성현", "남자", "서울시 강동구");
		m1.getMembers();
		
		Member m2=new Member();
		m2.setMembers("장신영", "여자", "인천시");
		m2.getMembers();
		

	}

}
