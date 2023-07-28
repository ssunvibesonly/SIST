package day0616;

import java.util.Calendar;

public class MyAge_12 {

	public static void main(String[] args) {
		// 매개변수 args에서 실행 시 이름과 태어난 연도를 보낸 후 출력하세요.(변수명 : name / 년도 : myBirth)
		// 이름 : 장순영
		// 태어난 연도 : 1996년
		// 나이 : 27세
		
		
		//현재년도는 Calendar import하여 구할 수 있다.
		//1. import 우선
		/*Calendar cal = Calendar.getInstance();
		
		//2. 변수
		String name = args[0];
		int myBirth = Integer.parseInt(args[1]);
		
		System.out.println("이름 : " + name);
		System.out.println("태어난 연도 : " + myBirth);
		System.out.println("나이 : " + (cal.get(cal.YEAR)-myBirth) + "세");*/
		
		//선생님 풀이 
		
		//1. import 우선
		Calendar cal = Calendar.getInstance();
		
		//2. 변수
		String name = args[0];
		int myBirth = Integer.parseInt(args[1]);
		
		int curYear = cal.get(cal.YEAR);//현재년도
		
		
		//3. 계산
		int myAge=curYear-myBirth;
		
		//4. 출력
		System.out.println("이름 : "+ name);
		System.out.println("태어난 연도 : " + myBirth);
		System.out.println("나이 : " + myAge+"세");
		
		
		
	

	}

}
