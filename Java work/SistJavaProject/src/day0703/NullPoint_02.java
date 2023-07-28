package day0703;

import java.util.Date;

public class NullPoint_02 {
	
	//NullPointerException : 생성하지 않고 클래스의 메소드를 호출하는 경우
		Date date; //Date date=new Date();로 수정해줘야 한다.
		
		public void writeday() {
			
			int y,m,d;
			
			try {
			y=date.getYear()-1900; // Date는 getYear()-1900 꼭 해줘야 함
			m=date.getMonth()+1;// Date는 getMonth()+1 꼭 해줘야 함
			d=date.getDate();
			
			System.out.println(y+"년"+m+"월"+d+"일 입니다.");
			
			}catch (NullPointerException e) {//모든 Exception의 부모가 Exception이므로 Exception 사용 가능
			
				System.out.println("객체 생성을 안했어요"+e.getMessage());
			}
		}
		
	public static void main(String[] args) {
		
		NullPoint_02 np=new NullPoint_02();
		np.writeday();
		System.out.println("***정상 종료***");
		
		

	}

}
