package day0627;

class ObTestA{
	
	private int x;
	private static int y; //static은 자기 자신을 가르키는 this(레퍼런스 변수)가 없다. 공용으로 쓰기 때문에 
	
	//x
	public void setX(int xx) { //set 메서드는 수정을 목적으로 만듦으로 반드시 인자값을 보내줘야 한다 
								//인자값을 보내서 수정할 것이기 때문에 public void setX(int or String 변수)
		//this.x=xx; //이름이 같을 땐 this
		x=xx; //이름이 다를 땐 this 생략 가능
		
	}
	
	//x
	public void getX() { //get은 돌려받아야 하는 값이기 때문에 인자값이 없다.
						// 대신 돌려받는 값에 따라 void 대신 public int or String getX(); 도 사용 가능하다
		
		System.out.println("x= "+this.x);
		
	}
	
	
	//static y (static 변수는 static 메서드만 만들 수 있다.)
	public static void setY(int yy) {
		
		//this.y=yy; static 변수(레퍼런스 변수)는 this를 가지고 있지 않다.
		//static에서는 일반 멤버 변수 호출 못함...static변수만 호출 가능
		ObTestA.y=yy; //같은 클래스에 있기 때문에 ObTestA. 생략 가능
	
	}
	public static void getY() {
		
		System.out.println("y= "+ObTestA.y);
	}
	
}

///////////////////////////////////////////////
public class ExObTest_06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*x는 생성..private 붙이는 순간 에러...메서드로 접근해야 함
		ObTestA oa1=new ObTestA();
		System.out.println(oa1.x);;
		
		//y는 클래스명으로 호출
		System.out.println(ObTestA.y);*/
		
		// private 변수이므로 메서드 만들어서 호출 가능..변수에 직접 접근이 안됨
		ObTestA oa1=new ObTestA();
		oa1.setX(20);
		oa1.getX();
		
		ObTestA oa2=new ObTestA();
		oa2.setX(50);
		oa2.getX();
		
		//ObTestA.y=200; private이므로 접근 불가 => static은 생성 안하고 호출해도 
		//y호출... 클래스명으로 호출
		ObTestA.setY(100);
		ObTestA.getY();
		
		
		
	}

}
