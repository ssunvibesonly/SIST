package day0622;

public class ForStar_07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 중첩(다중)for문으로 별모양 찍기
		System.out.println("중첩(다중)for문으로 별모양 찍기");
		
		/*for(int i=1;i<=5;i++) { //행갯수
			for(int j=1;j<=5;j++) { //열갯수
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();*/
		
		
		//2번
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("*");
				
		}
		System.out.println();
	}
		System.out.println();
		
		 //3번
		for(int i=1;i<=5;i++) {//행갯수
			for(int j=5;j>=i;j--) {//열갯수(i가 1일때 5번,2일때 4번,...5일때 1번)
				System.out.print("*");
				
		}
		System.out.println();
	}
		
	
	}
	
}



