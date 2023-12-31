package day0616;

public class ParseArgs_04 {

	public static void main(String[] args) {
		/* main에서 실행할 때 args로 변수 넘기는 문제
		 * 변수명 : sangName / 수량 : su / 단가 : dan / 총 금액 : total
		 * 
		 * 1. 변수 선언
		 * 2. 계산
		 * 3. 출력
		 * 
		 * [상품정보]
		 * 상품명 : 갤럭시 폴드
		 * 수량 : 5개
		 * 단가 : 800000원
		 * 총 금액 : 4000000원*/
		
		/*String name = args[0];
		int su = Integer.parseInt(args[1]);
		int dan = Integer.parseInt(args[2]);
		int total = Integer.parseInt(args[3]);
		
		System.out.println("[상품정보]");
		System.out.println("상품명 : " + name);
		System.out.println("수량 : " + su + "개");
		System.out.println("단가 : " + dan + "원");
		System.out.println("총 금액 : " + total + "원");*/
		
		//선생님 풀이
		String name =args[0];
		int su = Integer.parseInt(args[1]);
		int dan = Integer.parseInt(args[2]);
		int total;
		
		total=su*dan;
		
		System.out.println("[상품정보]");
		System.out.println("상품명 : " + name);
		System.out.println("수량 : " + su + "개");
		System.out.println("단가 : " + dan + "원");
		System.out.println("총 금액 : " + total + "원");
	}

}
