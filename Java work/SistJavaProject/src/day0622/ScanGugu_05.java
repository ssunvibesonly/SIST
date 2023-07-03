package day0622;

import java.util.Scanner;

public class ScanGugu_05 {

	public static void main(String[] args) {
		// 단을 입력해서 해당 단 출력하기_Scanner
		//0을 입력하면 종료
		
		Scanner sc=new Scanner(System.in);
		
		int dan;
			
		while(true) {
			System.out.println("단을 입력하세요(종료:0): ");
			dan=sc.nextInt();
			
			//종료
			if(dan==0) {
				System.out.println("종료합니다.");
				break;
			}
			//2~9단까지만 입력가능
			if(dan<2 || dan>9) {
				System.out.println("2~9단까지만 입력가능");
				continue;
			}
				
			
			
			//구구단 출력
			System.out.println("["+dan+"단]");
			for(int i=1;i<=9;i++) {
				//System.out.println(dan+"x"+i+"="+dan*i);
				System.out.printf("%d X %d = %2d\n",dan,i,dan*i);
			}
			System.out.println();
			
		}
	}

}
