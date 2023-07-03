package day0623;

import java.util.Scanner;

public class ArrScannerSum_09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 0번지 값: 55입력
		 * 1번지 값: 77입력
		 * 2번지 값: 88입력
		 * 3번지 값: 49입력
		 * 4번지 값: 29입력
		 * ==============
		 * [입력값 확인]
		 * 1번째 값: 55
		 * 2번째 값: 88입력
		 * 3번째 값: 49입력
		 * 4번째 값: 29입력
		 * ==============
		 * 총합계 : 298
		 */
		
		Scanner sc=new Scanner(System.in);
		
		int [] data;
		data=new int[5];
		
		int sum=0;
		
		//값 입력
		for(int i=0;i<data.length;i++) {

			System.out.print(i+"번지 값: ");
			data[i]=sc.nextInt();
			sum+=data[i];
			
		}
		//값 출력
		System.out.println("====================");
		System.out.println("\t[입력값 확인]");
		
		for(int i=0;i<data.length;i++) {
			System.out.println((i+1)+"==>"+data[i]);
			
		}
		System.out.println("총 합계 : "+sum);
	

		
	}

}
