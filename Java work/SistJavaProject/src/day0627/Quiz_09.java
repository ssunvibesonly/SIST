package day0627;

public class Quiz_09 {
	
	//변수 선언
	private static String place="이마트";
	private String sName; //null
	private int price; //0
	
	//set메서드
	public static void setPlace(String place){
		
		Quiz_09.place=place;	
	}
	
	public void setSname(String sName) {
		this.sName=sName;
		
	}
	public void setPrice(int price) {
		this.price=price;
		
	}
	
	
	//get메서드
	
	public static String getPlace() {
		return place; //public static void getPlace면 여기서 바로 System.out.~가능(반환값이 void이므로)
					// 단, String형이라고 알려주면 return값을 줘야한다.
		
	}
	
	public String getsName() {
		return sName;
	}
	
	
	public int getprice() {
		return price;
	}
	
}
