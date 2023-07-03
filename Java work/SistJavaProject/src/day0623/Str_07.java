package day0623;

public class Str_07 {

	public static void main(String[] args) {
		// 문자형 배열 str1, str2..선언과 동시에 초기화
		
		String [] str1={"국밥","피자","파스타","햄버거","타코"};
		String [] str2=new String[5]; //5개의 문자열이 들어가도록 메모리 할당, null로 초기화
		
		//str2에 문자열 넣기
		str2[0]="빨강";
		str2[1]="노랑";
		str2[4]="파랑";
		
		// => 0,1,2,3,4 순서대로 문자열을 넣치 않아도 오류 나지 않는다.
		
		//str1을 변수i를 이용해서 출력
		//음식1: 김밥
		//음식2: 피자
		
		System.out.println("#str1 출력1");
		for(int i=0;i<str1.length;i++) {
			System.out.println("음식"+(i+1)+": "+str1[i]);
		}
		
		//str1출력(음식 이름들만 나오게)
		System.out.println("#str1 출력2_for~each문");
		for(String i:str1)
			System.out.println(i);
		
		//str2도 출력
		System.out.println("str2을 변수i를 이용해서 출력");
		for(int i=0;i<str2.length;i++)
			System.out.println("색깔"+(i+1)+":"+str2[i]);
		
	
		System.out.println("str2을 for~each 이용해서 출력");
		for(String color:str2)
			System.out.println(color);

	}

}
