package day0621;

import java.util.Scanner;

public class WhileTrueCount_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 임의의 수를 입력해서 합계,평균,갯수
		 * 단 0을 입력하면 while문을 빠져나가게 하자
		 */
		Scanner sc=new Scanner(System.in);
		int su,sum=0;//입력할 수 ,합계
		int cnt=0;//갯수
		double avg=0;//평균
		
		while(true) {
			System.out.println("숫자 입력(종료:0): ");
			su=sc.nextInt();
			
			if(su==0)
				break;//break문을 해준 다음에 갯수를 증가하기 때문에 break를 먼저 줘야 0을 카운트 안한다.
			
			sum+=su;
			cnt++;	
	
		}
		
		avg=(double)sum/cnt; //평균은 sum만 누적하고 있으므로
		
		System.out.println("입력한 수의 합: "+sum);
		System.out.println("입력한 수의 평균: "+avg);
		System.out.println("입력한 숫자 갯수: "+cnt);
	}

}
