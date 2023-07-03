package day0621;

public class DoWhile_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=1;
		
		System.out.println("while문 결과");//선조건..참일동안 반복
		
		while(i<5)
		{
			
			//출력 후 증가
			System.out.print(i+++" ");
			
			//System.out.println(i)
			//i++
	
		}
		System.out.println(" ");
		System.out.println("do~while문 결과");//후조건..출력 후 증가, do~while문 조건식이 맞지않아도 {문장}안의 초기값 최초 한 번은 출력된다.
		
		i=1;
		
		do {
			System.out.print(i+++" ");
		}while(i<5);
	}

}
