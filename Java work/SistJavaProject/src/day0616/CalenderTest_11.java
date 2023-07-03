
package day0616;

import java.util.Calendar;
import java.util.Date;

public class CalenderTest_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Date date = new Date();//Date 클래스에 있는 모든 메서드를 가져다 쓸 수 있음
		//System.out.println("지금은" + (date.getYear()+1900));
	
	
		Calendar cal = Calendar.getInstance();//Calendar는 import받아갈 때 instance로 받아가게 설정되어 있음, 인스턴스는 calendar나 수학공식과 기존값이 정해져있는 것 등
											// new 쓰는 것과 getInstance를 쓰는 것의 역할은 동일하다.
											// Calendar에서 쓰는 모든 인스턴스를 cal(참조 변수)가 가져다 쓸 수 있다. 우리가 만든 객체 클래스는 가져다 쓸 때 new
		System.out.println("지금은 " + cal.get(cal.YEAR) + "년도");
		System.out.println("지금은 " + (cal.get(cal.MONTH)+1)+ "월 입니다.");//월은 그냥 출력할 때 -1달전이 나온다 따라서 +1을 더해준다
		System.out.println("지금은 " + cal.get(cal.DATE) + "일 입니다.");
		System.out.println("지금은 " + cal.get(cal.DAY_OF_MONTH) + "일 입니다.");
		System.out.println("시간 :  " + cal.get(cal.HOUR));
		System.out.println("시간 : " + cal.get(cal.HOUR_OF_DAY) + "시" + cal.get(cal.MINUTE) + "분" + cal.get(cal.SECOND) + "초"); 
		
	}
	

}
