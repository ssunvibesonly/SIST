package day0630;

interface InterAA{
	
	public void eat();
	public void go();
	
	
}

/////////////////////////////////////
interface InterBB extends InterAA{
	
	public void ride();
	
	
	
}
/////////////////////////////////////
class InterImpl2 implements InterBB{

	@Override
	public void eat() {
		System.out.println("저녁을 먹어요");
		
	}

	@Override
	public void go() {

		System.out.println("롯데월드 가요");
		
	}

	@Override
	public void ride() {
		System.out.println("자전거 타고 놀아요");
		
	}
	
	
}

////////////////////////////////////
public class InterExtends_03 {

	public static void main(String[] args) {
		// 3개모두 호출
		
		InterImpl2 inter1=new InterImpl2();
		inter1.eat();
		inter1.go();
		inter1.ride();
		
		//다형성
		InterBB da1=new InterImpl2();
		da1.eat();
		da1.go();
		da1.ride();
	}

}
