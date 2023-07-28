package day0628;

class MyDate{
	
	//인스턴스 변수
	private int year;
	private int month;
	private int day;
	
	//디폴트 생성자 숨어있다. /=> 인자값 있는 생성자를 만들면 꼭 디폴트 생성자도 명시를 해줘야 오류가 안든다.
	public MyDate() {
		
	}
	
	//명시적 생성자 ...3개의 인자값을 수정과 동시에 생성/ => 인자값 있는 생성자를 만들면 꼭 디폴트 생성자도 명시를 해줘야 오류가 안든다.
	public MyDate(int y,int m,int d) {
		year=y;
		month=m;
		day=d;
		
	}
	
	
	//getter,setter
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	
	
	
}


///////////////////////////////////////////
public class AutoSetGet_01 {

	public static void main(String[] args) {
		// 객체 생성
		
		MyDate date=new MyDate();
		date.setYear(2023);
		date.setMonth(6);
		date.setDay(22);
		
		System.out.println(date.getYear()+"-"+date.getMonth()+"-"+date.getDay());

		//명시적 생성 
		MyDate date1=new MyDate(2020, 8, 10);
		System.out.println(date1.getYear()+"-"+date1.getMonth()+"-"+date1.getDay());
	}

}
