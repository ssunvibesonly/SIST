package day0623;

import java.util.Scanner;

public class ArrayIntFind_12 {

	public static void main(String[] args) {
		// 숫자를 입력해서 그 숫자가 몇번째 있는지 찾기(indexof)
		// 1. 찾으려는 숫자가 있는지 없는지 먼저 확인
		// 2. 없으면 없다 출력(있는지 없는지 확인할 땐 boolean값이 우선이다)
		// 3. 0을 입력 시 종료: [while(true)]

		Scanner sc=new Scanner(System.in);
		
		int su;//입력할 수
		int [] data={5,1,98,321,68,41,20,28,19,22};
		boolean flag;
		
		while(true) {
			System.out.println("검색할 숫자를 입력하세요:");
			su=sc.nextInt();
			
			//break..0입력 시 종료
			if(su==0) {
				System.out.println("종료합니다.");
				break;
			}
			//있다 없다 확인하기 위한 초기값(초기값은 false로 준다 왜냐하면? 아직 못찾았기 때문에 없을 수도 있으므로)	
			flag=false; // 찾으면 true로 변경
			
			//값 찾기
			for(int i=0;i<data.length;i++) { //값이 있을 경우는 for문에서 출력이 되고,
				if(su==data[i]) {
					flag=true;
					System.out.println(i+"번지에서 검색"); // 번째로 검색하고 싶으면 (i+1) 왜냐? 배열은 0번지부터 시작하므로
				}
			}
			if(!flag)//flag==false 값이 없을 경우는 flag==false에서 if(!flag)로 온다. 여기서 데이터가 없다는 출력문을 나타내려면
					//if문 내부가 참이어야 다음께 출력이 되므로 !flag를 쓴다.
				System.out.println(su+"는 데이터에 없습니다.");
			
			
		}
		
	}

}
