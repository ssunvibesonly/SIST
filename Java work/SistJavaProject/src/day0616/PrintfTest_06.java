package day0616;

public class PrintfTest_06 {

	public static void main(String[] args) {
		// printf로 출력하세요 자바에서는 printf 개행 안됨
		// 안녕하세요 제 이름은 송혜교 입니다.
		// 이스케이프 문자 써서 나이는 25세 입니다.
		// %d : 정수, %f : 실수 , %s : 문자열, %c : 문자 (오른쪽부터 채워진다고 생각)
		
		String name = "송혜교";
		int age = 25;
		
		System.out.printf("안녕하세요 제 이름은 %s 입니다.\n나이는 %d세 입니다.", name, age);

	}

}
