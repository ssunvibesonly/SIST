package day0620;

import java.util.Scanner;

public class SwitchTest_11 {

	public static void main(String[] args) {
		// 숫자를 입력받아 그 숫자를 출력해보기
		Scanner sc=new Scanner(System.in);
		int num;
		
		System.out.println("숫자 입력");
		num=sc.nextInt();
		
		switch(num) //case 뒤에 숫자가 호출하는 값이다
		{case 1:
			System.out.println("숫자 1입니다.");
			break;
		case 2:
			System.out.println("숫자 2입니다");
			break;
		case 3:
			System.out.println("숫자 3입니다");
			break;
		default:
			System.out.println("숫자 1 2 3이 아닙니다.");
			break;
		
		}
		
		//switch 이용해서 ex. 22는 짝수 입니다.
		
		switch(num%2)//switch문에서 case 마지막에 Default는 넣어도 되고 안넣어도 되나 넣는 편이 좋다
					//왜냐면 끝도 없이 길어질 수 있기 때문, switch문은 수식x 수식과 결과값을 case로 나눠줬다고 생각하자
		{
		case 0:
			System.out.println(num+"은 짝수 입니다.");
		case 1:
			System.out.println(num+"은 홀수 입니다.");
		/*default: -> case1 굳이 안쓰고 default로 닫아줘도 결과 같음
			System.out.println(num+"은 홀수 입니다.");*/
				
		}
		
		//if 
		if(num%2==0)
			System.out.println(num+"은 짝수");
		else
			System.out.println(num+"은 홀수");
	}

}
