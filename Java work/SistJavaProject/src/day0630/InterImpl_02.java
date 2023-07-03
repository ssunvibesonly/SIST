package day0630;

interface InterA{//인터페이스는 상수와 추상메서드만 담을 수 있다.
	
	public void draw(); //추상메서드는 구현부{}가 없다.
	public void write();
	
	
}
/////////////////////////////
interface InterB{ //인터페이스 extends 인터페이스
	
	public void play();
	
	
}
///////////////////////////////2개의 인터페이스를 구현하는 클래스
class Impl implements InterA,InterB{

	@Override
	public void play() {
		System.out.println("축구를 합니다.");
		
	}

	@Override
	public void draw() {
		System.out.println("그림을 그립니다");
		
	}

	@Override
	public void write() {
		System.out.println("일기를 씁니다.");
		
	} 
	
	
}
////////////////////////////////
public class InterImpl_02 {

	public static void main(String[] args) {
		
		Impl a1=new Impl();
		a1.draw();
		a1.play();
		a1.write();
		
		//다형성
		InterA inA=new Impl(); 	//부모 변수=new 자식();
		inA.draw();
		inA.write();
		
		InterB inB=new Impl();
		inB.play();
		
	}

}
