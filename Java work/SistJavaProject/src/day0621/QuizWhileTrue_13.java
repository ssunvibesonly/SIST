package day0621;

import java.util.Scanner;

import day0619.ScannerMyAge_05;

public class QuizWhileTrue_13 {
	public static void main(String[]args) {
		/*
		 * 점수를 반복해서 입력하다가 q나 Q를 입력하면 
			while문 빠져 나온 뒤 총 갯수, 총점, 평균은 소수점한자리로 출력하시오
		 */
		Scanner sc=new Scanner(System.in);
		
		String score;
		int tot=0,cnt=0;
		double avg;
	
		while(true) {
			System.out.println("점수를 입력하시오(종료:q,Q): ");
			score=sc.nextLine();
			
			//종료
			//if(score.equals("q")||score.equals("Q"))
			if(score.equalsIgnoreCase("q"))
			//if(score.charAt(0)=='q'||score.charAt(0)=='Q')
				break;
			
			tot+=Integer.parseInt(score);//정수로 변환 후 합계 변수에 누적
			cnt++;
			
		}
		avg=(double)tot/cnt;//둘다 정수이므로 double로 형변환
		System.out.println("***결과 출력***");
		System.out.println("입력한 총 갯수를 입력하시오: "+cnt);
		System.out.println("입력한 값의 총점을 구하시오: "+tot);
		System.out.printf("평균은 소수점 한자리로 구하시오:%.1f",avg);
		
	}

}
