package day0627;

public class MemoryCnt_04 {
	
	static int count=0; //인스턴스 멤버는 각각이므로 count도 각각 되는거라 누적되지 않는다.
						//단  static 변수는 공용이므로 누적된다.
	
	//생성자
	public MemoryCnt_04() {
		count++;
		System.out.println(count);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MemoryCnt_04 m1=new MemoryCnt_04();
		MemoryCnt_04 m2=new MemoryCnt_04();
		
		
		
		
	}

}
