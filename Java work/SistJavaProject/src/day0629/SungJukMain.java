package day0629;

import java.util.Scanner;

public class SungJukMain {

	public static void getSungjuk(SungJuk s) {
		
		System.out.println(s.getName()+"\t"+s.getJava()+"\t"+s.getOracle()
		+"\t"+s.getTot()+"\t"+s.getAvg());
	}
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int inwon;
		SungJuk [] sj;
		String schoolName;
		
		System.out.println("입력할 인원 수");//배열할당
		inwon=Integer.parseInt(sc.nextLine());
		
		System.out.println("학교명?");
		schoolName=sc.nextLine();
		
		SungJuk.setSchoolName(schoolName);
		
		//인원수만큼 배열 할당
		sj=new SungJuk[inwon]
;
		//인원수 입력
		for(int i=0;i<inwon;i++) {
			System.out.println(i+"번 학생 이름?");
			String name=sc.nextLine();
			
			System.out.println("자바와 오라클 점수 입력");
			int java=Integer.parseInt(sc.nextLine());
			int oracle=Integer.parseInt(sc.nextLine());
			
			//i번째 학생성적 생성
			sj[i]=new SungJuk();
			
			//set
			sj[i].setName(name);
			sj[i].setJava(java);
			sj[i].setOracle(oracle);
				
		}
		//결과 출력
		System.out.println("***결과 출력***");
		System.out.println("학교명: "+SungJuk.getSchoolName());
		
		System.out.println("학생명\t자바점수\t오라클점수\t총점\t평균\t합격여부");
		System.out.println("---------------------------------");
		
		for(SungJuk s:sj)
			getSungjuk(s);
	}

}
