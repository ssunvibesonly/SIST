package day0621;

public class ExWhile_03 {

	public static void main(String[] args) {
		// while for 비교
		// 10 9 8 7 6 5 4 3 2 1
		
		//while문
		int i=10;
		
		while(i>=0) {
			System.out.print(i--+" ");
		}
		System.out.println(" ");
		
		//for문
		//int a=10;을 for문 안에 해도 되나, int i를 바깥에 빼도 문제 없다.
		// int i; for(;a>=0;a--) i를 바깥에 빼줘도 for문 안에 초기식 부분에 ;는 꼭 해줘야함
		for(int a=10;a>=0;a--) { //a--나 --a나 같다 단항식이므로
			System.out.print(a+" ");
		}
		
	
	}
}
