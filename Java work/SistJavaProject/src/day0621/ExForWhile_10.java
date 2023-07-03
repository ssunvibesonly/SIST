package day0621;

public class ExForWhile_10 {

	public static void test1() {//새로 생성한 메서드
		
		//for문으로 1부터 5까지 합 구하기
		int i;
		int sum=0;
		
		for(i=1;i<=5;i++) {
			sum+=i;
		}
			
		System.out.println("1~5까지의 합: "+sum);
	}
	public static void test2() {
		
		//1~10까지의 홀수합 for문
		int i;
		int osum=0;
		
		for(i=1;i<=10;i++) {
			if(i%2==1)
				osum+=i;
		}
		System.out.println("홀수합: "+osum);
	}
	
	public static void test3() {
		//100까지의 합은 5050 100을 변수처리해서 가져오기
		int i;
		int sum=0;
		
		for(i=1;i<=100;i++) {
			sum+=i;
		}
		System.out.println("1부터 "+(i-1)+"까지의 합은 "+sum);
		
	}
	
	public static void main(String[] args) {//메인 메서드는 하나다, 해당 클래스의 시작과 끝을 담당
		test1(); //test1 메서드에 코드를 작성했으므로 메인메서드에서 test1()호출해줘야 결과값 도출
		test2();
		test3();
	}
	

}
