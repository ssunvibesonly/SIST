package day0629;

class Point{
	int x;
	int y;
	
	
	//디폴트 생성자
	public Point() {
		System.out.println("super_디폴트 생성자");
	}
	//명시적 생성자
	public Point(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	//메서드
	public void write(){
		
		System.out.println("x좌표="+x+"y좌표="+y);
	}
}
////////////////////////////////
class SubPoint extends Point{
	
	String msg;
	
	public SubPoint(int x, int y, String msg) {
		super(x,y);
		this.msg=msg;
		
	}
	public SubPoint() {
		super();//생략 되어있음
		System.out.println("sub_디폴트 생성자");
	}

	//오버라이딩...부모의 메서드 재구현할 목적
	@Override
	public void write() {
		super.write();
		System.out.println("메세지: "+msg);
	}
}



	
/////////////////////////////////
public class ExObjTest_05 {

	public static void main(String[] args) {
		SubPoint sp=new SubPoint();
		sp.write();
		
		SubPoint sp1=new SubPoint(100, 200, "배고파");
		sp1.write();
	}

}
