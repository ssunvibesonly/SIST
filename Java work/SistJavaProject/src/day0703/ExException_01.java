package day0703;

public class ExException_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("프로그램 시작!!!");
		try { 
			//try : 에러가 발생할 수 있는 부분 {코드}: 발생할 수 있는 부분에 대한 코드
			int num=3/0; //정수를 0으로 나누면 에러 발생
		} catch(ArithmeticException e) {//catch : 에러에 대한 해결,처리
			System.out.println(e.getMessage()); //예외처리 메세지
			//e.printStackTrace(); => 에러에 대한 자세한 정보 출력
			
		}
		System.out.println("프로그램 종료!!!");
		
		
	}

}
