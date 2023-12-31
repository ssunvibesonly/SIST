package day0616;

public class OperTest_07 {

	public static void main(String[] args) {
		// 기본자료형_8개
		// 1. 논리형 : true, false
		boolean b=false; //뭐가 있는지 찾을 때 기본적으로 거짓이라고 두고 찾는다
		
		//2. 문자형( '' 홑따옴표로 나타냄)
		// 반드시 하나의 문자 16비트 유니코드값 표현
		// 자바에서 char : 2byte (한글은 2byte, 영어는 1byte이다.) 
		// 기본적으로는 정수형, 아스키코드
		char ch='A';
		
		//3. 정수형
		byte by = -128; // 1byte -128~127까지 가능
		short sh = 32000; // 16bit = 2byte
		int c = 6700000; // 32bit = 4byte
		long num1=100L; // 64bit, 뒤에 L 또는 l을 붙여야 long = 8byte
		
		//4. 실수형
		double d = 42356.14526; //64bit=8byte, 소수점 / 실수에선 double이 기본형
		float f = 3.1234568f; // 32bit=4byte
		
		// int, float은 똑같이 32bit=4byte 사용하지만 기본적으로 실수형이 정수형보다 큰 타입으로 처리된다.
		
		//출력
		System.out.println("bool=" + b);
		System.out.println("not bool=" + !b);
		System.out.println("ch="+ ch);//65
		System.out.println("ch=" + (ch+1));//66
		System.out.println("ch=" + (char)(ch+1));//B
		System.out.println("dou=" + d);//정밀도 15자리
		System.out.println("f=" + f);//정밀도 8자리
		
		//printf %f:실수
		//전체자리수 10자리 소수점 2자리
		System.out.printf("d=%10.2f",d);
		//소수점1자리
		System.out.printf("\nd = %.1f",d); 
 
	}

}
