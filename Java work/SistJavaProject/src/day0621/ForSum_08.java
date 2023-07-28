package day0621;

public class ForSum_08 {

	public static void main(String[] args) {
		
		// for문으로 합계 구하기
		//1~10까지의 합계
		int sum=0; //합계 구하는 변수
		
		for(int i=1;i<=10;i++) {
			sum+=i;//sum=sum+i..합계 변수에 i를 누적시킨다.
			
		}
		System.out.println("1부터 10까지의 합은 "+sum+" 입니다.");
		
		//while문으로도 합계 구해보기
		int total=0;
		int i=1;
		while(i<=10) {
			total=total+i;
			i++;
		}
		System.out.println("1부터 10까지의 합은 "+total+" 입니다.");
		
		//결과 출력시 1~10까지의 합은 55입니다. 10을 변수를 이용하여 출력되게끔
		
		int tot=0;
		int a=1;
		for(;a<=10;a++) {
			tot+=a;	
		}
		System.out.println(""
				+ ""
				+ "1에서" +(a-1)+"까지의 합은 "+tot);
		
		
		
	}

}
