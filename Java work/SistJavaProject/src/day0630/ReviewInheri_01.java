package day0630;

class Market{
	
	private String sangpum;
	private int su;
	
	public Market() { //디폴트 생성자를 만든다는 건 명시적 생성자도 만든다는 뜻, 디폴트 생성자 일 때는 컴파일러가 자동으로 디폴트 생성자를 생성해주지만, 
		//super();    //명시적 생성자일 경우 디폴트 생성자랑 구분해야되기 때문에 디폴트 생성자도 나타내야 한다. 
		// sangpum="딸기" => 디폴트 생성자로 만들어도 null값이 나오는게 싫다면 이처럼 변수를 넣어줄 수 있다.
	}
	
	public Market(String sangpum, int su) {
		
		this.sangpum=sangpum;
		this.su=su;
		
	}
	
	public void getMarket() {
		
		System.out.println("상품명: "+sangpum);
		System.out.println("수량: "+su);
		
	}
	
	
	
}



///////////////////////////////////
class MyMarket extends Market{
	
	private int price;
	
	public MyMarket() {
		price=5000;
		
	}
	
	public MyMarket(String sangpum,int su,int price) {
		super(sangpum,su);
		this.price=price;
		
	}
	
	@Override
	public void getMarket() {
		System.out.println("단가: "+price);//생성자일 경우에만 위에 super를 무조건 둬야하고 메소드는 상관없다.
		super.getMarket();
	}
	
	
	
}
//////////////////////////////////
public class ReviewInheri_01 {

	public static void main(String[] args) {
		// 디폴트
		MyMarket ma1=new MyMarket();
		ma1.getMarket();
		System.out.println();
		
		
		//명시적 생성자
		MyMarket ma2=new MyMarket("오렌지", 10, 5000);
		ma2.getMarket();
		

	}

}
