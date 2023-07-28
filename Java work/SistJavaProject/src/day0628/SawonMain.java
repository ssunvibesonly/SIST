package day0628;

import java.util.Scanner;

public class SawonMain {

	public static void getSawon(Sawon[] sawon) {
		
		//제목
		Sawon.getTitle();
		
		for(Sawon s:sawon) {
			System.out.println(s.getSawonName()+"\t"+s.getPay()+"\t"+s.getFamSu()
			+"\t"+s.getTimeSu()+"\t"+s.getFamilySudang()+"\t"+s.getTimeSudang()+"\t"+s.getTotalPay());
		}
	
	}
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int inwon; //몇명인지 입력
		
		
		
		System.out.println("입력할 직원수는?");
		inwon=Integer.parseInt(sc.nextLine());
		
		//배열할당
		Sawon[]sawon=new Sawon[inwon];//Sawon [] sawon;
									// sawon=new Sawon[inwon];
		
		//인원수만큼 데이터 입력
		for(int i=0;i<inwon;i++) //inwon의 수만큼 생성되니까 inwon
		{
			//sawon생성 
			sawon[i]=new Sawon();
			
			System.out.println("사원명?");
			String name=sc.nextLine();
			
			System.out.println("급여?");
			int pay=Integer.parseInt(sc.nextLine());
			
			System.out.println("가족수?");
			int fs=Integer.parseInt(sc.nextLine());
			
			System.out.println("초과시간?");
			int ts=Integer.parseInt(sc.nextLine());
			
			//setter로 sawon클래스에 데이터를 넣기
			
			sawon[i].setSawonName(name); //스캐너에 입력한 이름
			sawon[i].setPay(pay);
			sawon[i].setFamSu(fs);
			sawon[i].setTimeSu(ts);
			
			
		}
		//출력
		getSawon(sawon);
		
		
		
	}

}
