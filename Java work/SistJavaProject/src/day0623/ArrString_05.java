package day0623;

public class ArrString_05 {

	public static void main(String[] args) {
		// 배열선언 문자열 선언 후 초기값
		String [] str=new String[4]; // 처음에 배열을 몇개의 자리로 구성할건지 정해주어야 한다. 배열수를 정하지 않으면 오류뜸

		//초기화
		str[0]="최진평";
		str[1]="고은비";
		str[2]="김영환";
		str[3]="홍성경";
		
		//출력
		System.out.println("for문 출력");
		for(int i=0;i<str.length;i++)
			System.out.println(i+"=="+str[i]);
		
		
		System.out.println("for~each문 출력");
		for(String a:str)
			System.out.println(a);
			
			
		
		
		
	}

}
