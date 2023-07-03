package day0621;

public class ExWhile_02 {

	public static void main(String[] args) {
		// Whil문으로 1부터 10까지 출력
		
		int n=0;
		
		while(n<10)
		{
			n++;
			System.out.printf("%4d",n);
		}
		System.out.println();
		
		//다른 방법
		n=0; //이미 상단에 int n=0;이라고 선언했으므로 n=0만 선언해준다.
		
		while(n<10) {
			System.out.printf("%4d",++n);		
		}
		System.out.println();
		
		n=0;
		while(true)
		{	
			System.out.printf("%4d",++n);//n++면 0 1 2 3 4 5 6 7 8 9
										//왜냐? 후치수식이면 while문 바깥의 n이
										//먼저 10이되고 print문을 수행하기 위해
										//while문 내부로 들어오면 n==10일때
										//break가 되기 때문에
										//그러나 ++n이면 바깥 n이 9일 때 ++n은 
										//10이되고 바깥 n이 10이 되면 ++n은 
										//11이 되니까 이미 바깥 n이 10이 되는 순간
										//break 
			
			 
			if(n==10) //break 반드시 넣어야한다!!!
				break;	//무한루프에 빠지므로 반드시 break문을 주어야 한다.
		}
		System.out.println();
		
		
	}

}
