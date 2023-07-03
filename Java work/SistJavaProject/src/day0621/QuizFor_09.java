package day0621;

public class QuizFor_09 {

	public static void main(String[] args) {
		// Q.1 2 4 5 7 8 10 (3,6,9가 빠짐)_continue이용해서 출력해보시오
		
		int i=1;
		for(i=1;i<=10;i++) {
			if(i%3==0)
				continue;
			System.out.print(i+" ");
		}
		System.out.println(" ");
		/* Q. continue 이용할 것
		 	홀수값: 1
		 	홀수값: 3
		 	홀수값: 5
		 	홀수값: 7
		 	홀수값: 9*/
		
		for(i=1;i<=9;i++) {
			if(i%2==0) //짝수는 출력을 안하겠다는 의미
				continue;
			System.out.println("홀수값: "+i);
		}
		System.out.println(" ");
		
		//1~100까지 중에서 홀수의 합을 구하시오
		int sum=0;//홀수 합계 구할 변수
		int zzac=0;//짝수의 합
		for(i=1;i<=100;i++) {
			if(i%2==1)
			 sum+=i; 
			else
			 zzac+=i;
			}
		System.out.println("홀수의 합 "+sum);
		System.out.println("짝수의 합 "+zzac);
		
		//while(true)문을 이용해서 1~100사이의 짝수합 구하기
			i=1;
			sum=0;
			while(true) {//while(true)문은 조건을 쓰는 자리가 없으므로 무조건 break(break안쓰면 무한 루프)
						//while(true)문은 범위가 모호할 때 쓴다. ex)1~100까지의 사람 중에서 영준이를 만날때까지  영준이가 어딨는지 모르니까!
				
				if(i%2==0)
					sum+=i;
				i++;
				
				if(i>100)
					break;
					
			}
			System.out.println("짝수의 합: "+sum);
	}
	
		
	

}
