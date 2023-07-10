package day0619;

import java.util.Scanner;

public class ScannerScore_03 {

	public static void main(String[] args) {
		// Scanner 콘솔창에 변수값을 입력받아서 출력할 것! 

		// 생성
		Scanner sc=new Scanner(System.in); //웬만하면 까먹을 수도 있으니 import 먼저 해주자
		
		//변수
		String name;
		int kor,eng,math;
		int total;
		double avg;
		
		//입력
		System.out.println("학생의 이름은?");
		name=sc.nextLine();
		System.out.println("국어 점수는?");
		kor=sc.nextInt();
		System.out.println("영어 점수는?");
		eng=sc.nextInt();
		System.out.println("수학 점수는?");
		math=sc.nextInt();
		
		//계산
		total=kor+eng+math;
		avg=total/3.0; //avg를 double로 호출했기 때문에 나눌때도 소수로 나눠줘야 값이 제대로 나온다.
		
		//최종출력
		System.out.println("====================");
		System.out.println("학생명: "+name);
		System.out.println("국어 점수: "+kor);
		System.out.println("영어 점수: "+eng);
		System.out.println("수학 점수: "+math);
		System.out.println("====================");
		System.out.println("총점:"+total+"점");
		System.out.println("평균:"+avg+"점");
		
		
		

	}

}
