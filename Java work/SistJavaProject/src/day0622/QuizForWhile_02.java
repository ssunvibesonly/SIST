package day0622;

import java.util.Scanner;

public class QuizForWhile_02 {

	public static void quiz1() {
		
		// 점수를 입력하면 합계를 구하시오
		//1~100이 아니면 제외(continue), 대신 0을 입력하면 종료
		
		Scanner sc=new Scanner(System.in);
		
		int score;//입력할 점수
		int sum=0;
		
		while(true) { //while(true) break 필수! 
			
			System.out.println("점수를 입력하시오");
			score=sc.nextInt();
					
			if(score==0)//break는 젤 위에 써주도록 하자! 그래야 결과값이 알맞게 나옴
				break;
			
			if(score<0||score>100)//점수 잘못쓰면 끝나는게 아니고 다시 반복 쓸 수 있게 continue ,if문 안에꺼 제외
				continue;//조건 문장 아래에 한줄만 블락으로 인식 두줄이상이면 블락처리 해준다{}-1
						 // 어차피 break에서 score==0으로 했기 때문에 score<0으로 해도 상관없다.
			
			sum+=score;//sum=sum+score
			
		}
		System.out.println("합계(단,0을 입력하면 종료): " +sum);
	}
	
	public static void quiz2() {
		//점수를 반복해서 입력하면 합계,평균를 구하시오.
		//끝이라고 입력시 프로그램 종료
		Scanner sc=new Scanner(System.in);
		
		String num;
		double avg;
		int cnt=0;
		int sum=0;
		
		while(true) {
			System.out.println("점수를 입력하시오(끝 입력시 종료)");
			num=sc.nextLine();
			
			//break
			if(num.equals("끝"))
				break;
			
			int a=Integer.parseInt(num);
			//continue
			if(a<1 || a>100)
				continue;
			
			sum+=a;
		
			cnt++;//만약에 "끝"위에다가 cnt를 쓰면 "끝"이라고 쓴것도 카운트 되기 때문에 break아래에 써준다
		}
		avg=(double)sum/cnt; //(double)변수1/변수2 -> 변수1만 (double)형으로 바뀐다. 
							
		System.out.println("합계를 입력하시오: "+sum);
		System.out.println("평균을 입력하시오: "+avg);
		
	}
	
	public static void quiz3() {
		/*
		 * 총 5개의 점수를 입력받아 합계를 구하시오
		 * 만약 1~100이 아닐경우 다시 입력받아라
		 * 1번 점수 88
		 * 2번 점수 99
		 * 3번 점수 200
		 * 잘못 입력했어요
		 * 3번 점수 33
		 * 4번 점수
		 * 
		 * ========
		 * 합계 : 
		 */
		
		int score;
		int sum=0;

		System.out.println("총 5개의 점수를 입력받아 합계를 구하시오");
		
		for(int i=1;i<=5;i++) {
			
			Scanner sc=new Scanner(System.in);
		
			System.out.print(i+"번 점수 입력: ");
			score=sc.nextInt();
			
			if(score<0 || score>100) {
				System.out.println("잘못 입력했어요");	
				i--;
				continue;
			}
			
			sum+=score;
			
		}
			System.out.println("========");
			System.out.println("합계: "+sum);
			
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//quiz1();
		//quiz2();
		quiz3();
	}

}
