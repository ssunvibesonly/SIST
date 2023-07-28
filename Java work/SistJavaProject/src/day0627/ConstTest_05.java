package day0627;

class ConstA{
	
	int num=0;
	
	//디폴트 생성자...명시적인 생성자를 만들면 디폴트 생성자는 자동 생성되지 않는다.
	//필요하면 만들어주어야 한다.
	
	public ConstA() { 
		num=10;
		System.out.println("디폴트 생성자");
	}
	 
	
	//인자 있는 생성자
	public ConstA(int num) {
		this.num=num; //this를 붙이는건 인스턴스 변수만 가능하다.
		System.out.println("생성자 호출");
	}

	//메서드 -> 소문자로 
	public int getNumber(){ //public static "void" : 리턴 타입이 없다.
							//public int or String : int 형이나 String형으로 리턴값 돌려줘야 한다. 반드시 return!!!
		num=50;
		
		return num;
		
	}
	


}


/////////////////////////////////////////////////////////
public class ConstTest_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//인자값 있는 생성자(인자값으로 num을 보낸 생성자) => 생성과 동시에 값을 수정 가능
		ConstA ca1=new ConstA(30);
		System.out.println(ca1.num);
		
		//디폴트 생성자
		ConstA ca2=new ConstA();
		System.out.println(ca2.num);
		
		//메서드 호출 => 수정하려면 수정 메서드가 필요
		ConstA ca3=new ConstA();
		System.out.println(ca3.getNumber());
		
		
		
		
	}

}
