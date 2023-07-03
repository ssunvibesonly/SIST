package day0622;

public class ExForGugu_04 {

	public static void main(String[] args) {
		// 2~9단까지 구구단
		/*for(int dan=2;dan<=9;dan++) {
			for(int j=1;j<=9;j++) {
				
				System.out.println(dan+"X"+j+"="+dan*j);
			}
			System.out.println(" ");
		}*/

		//구구단 break 연습
		//반복문 앞에 이름을 붙히고 해당이름을 break 처리하면 두개 이상의 반복문을 빠져나가는게 가능하다
		loop: for(int dan=2;dan<=9;dan++) {
			for(int j=1;j<=9;j++) {
				if(j==5)
					break loop;
				
				System.out.println(dan+"*"+j+"="+dan*j);				
			}
			System.out.println();
		}
		
			
		
		
		
		
		
	}

}
