package day0616;

public class ParseNum_02 {

	public static void main(String[] args) {
		// 형변환 : 문자열을 정수로 바꿔주는 것
		//String 타입을 int타입으로 변경하려면
		//Integer.parseInt("10"); 문자열 10이 정수 10로 반환
		//Double.parseDouble("12.23"); 문자열 12.23이 실수타입으로 변환
		//대문자시작.소문자시작형식 Wrapper class : 기본형과 클래스간의 변환을 위해 클래스 안에 있는 메서드를 가지고 오는 용도
		
		String num1= "10";
		String num2= "20";
		
		System.out.println("두 수 더하기 : " + (num1 + num2));
		
		//문자열 num1,num2를 정수타입 int로 변환 후 계산
		
		int su1 = Integer.parseInt(num1);
		int su2 = Integer.parseInt(num2);
		
		System.out.println("변환 후 두수 더하기 : " + (su1 + su2));
		System.out.println("변환 후 두수 빼기 : " + (su1-su2));
		System.out.println("변환 후 두수 곱하기 : " + (su1*su2));
		System.out.println("변환 후 두수 나누기 : " + (su1/su2));//정수형끼리 연산시 결과 정수형
		System.out.println("변환 후 두수 나머지 : " + (su1%su2));
	}

}
