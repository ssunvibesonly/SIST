package day0616;

public class ParseIntArgs_03 {

	public static void main(String[] args) {
		/* [결과출력]
		 * 내 이름은 김영환
		 * 자바 점수는 88
		 * 오라클 점수는 77
		 * 두 과목의 합계는 165점 입니다
		 */
		
		/*System.out.println("[결과출력]");
		System.out.println("내 이름은 " + args[0]);
		System.out.println("자바 점수는 " + args[1]);
		System.out.println("오라클 점수는 " + args[2]);
		
		int sun1 = Integer.parseInt(args[1]);
		int sun2 = Integer.parseInt(args[2]);
		
		System.out.println("두 과목의 합계는 " + (sun1 + sun2));*/
		
		//선생님 풀이 (변수 선언 - 계산 - 출력 하는 습관들이기! / 변수를 가지고 와서 최대한 짧게 하는 습관 들이기)
		//변수선언
		String name = args[0];
		int java = Integer.parseInt(args[1]);
		int oracle = Integer.parseInt(args[2]);
		
		//출력 
		System.out.println("[결과출력]");
		System.out.println("내 이름은 " + args[0]);
		System.out.println("자바 점수는 " + java);
		System.out.println("오라클 점수는 " + oracle);
		
		System.out.println("두 과목의 합계는 " + (java + oracle));
		
		

	}

}
