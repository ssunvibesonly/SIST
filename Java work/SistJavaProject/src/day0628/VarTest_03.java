package day0628;


class Test2{
	
	int n=0;
	static int cnt=0;
	
	public Test2() { //생성자는 클래스명으로 호출된다.
		System.out.println("생성자 호출");
		n++;
		cnt++;
		
	}
	public void write() {
		System.out.println("cnt= "+cnt+"\tn="+n);
	}
}
//////////////////////////////////////////
public class VarTest_03 {
	
	public static void main(String[] args) {
		Test2 t1=new Test2();
		t1.write();
		
		Test2 t2=new Test2();
		t2.write();
		
		Test2 t3=new Test2();
		t3.write();
		
		
	}

}
