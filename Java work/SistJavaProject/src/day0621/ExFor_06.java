package day0621;

public class ExFor_06 {

	public static void main(String[] args) {
		// for문
		// 1~10까지 가로로 출력
		
		for(int i=1;i<=10;i++)
		{
			System.out.printf("%2d",i); //%2d는 정수 자릿수가 두개란 뜻이므로8 9 10의 경우8 910처럼 붙어나올 수 있다
		}

		System.out.println(" ");
		//10~1까지 가로로 출력
		
		for(int i=10;i>=1;i--)
		{
			System.out.printf("%2d",i);
		}
		System.out.println(" ");
	
		//1~50까지 출력하는데 3씩 증가하게...
		//1 4 7
		for(int i=1;i<=50;i+=3) {
			System.out.printf("%2d",i);
		}
		System.out.println(" ");
		
		//continue
		//1~20까지 출력하는데 1 2 3 4 5 6 7 8 9 11 12
		for(int i=1;i<=20;i++)
		{
			//5의 배수를 빼고 출력
			if(i%5==0)
				continue;//continue 부분에 해당하는 것만 skip하고 i++로 이동
				//break; => 조건이 5의 배수 중 첫 수인 5를 만나면 아예 빠져나감
			System.out.print(i+" ");
		}
	}
	

}
