package day0623;

import java.util.Scanner;

public class QuizArrFind_13 {

	public static void main(String[] args) {
		//이름을 입력해서 없으면 없다고 있으면 몇번째 있는지 알려주세요
		//끝이라고 쓰면 종료

		Scanner sc=new Scanner(System.in);
		
		String[]stuNames= {"이성신","이민규","박병주","최성현","김영준","강연주","최진평","고은비","송주영"};
		
		String name;
		boolean flag;
		
		while(true) {
			System.out.println("이름을 입력하세요: ");
			name=sc.nextLine();
			
			if(name.equals("끝")) {
				System.out.println("종료합니다.");
				break;
			}
			
			flag=false;
			
			for(int i=0;i<stuNames.length;i++) {
				if(name.equals(stuNames[i]))
				{	flag=true;
					System.out.println(name+"은 "+i+"번지에서 검색 되었습니다.");
				}
			}
			if(!flag) {//flag==false 위에서 flag=false라고 대입을 해줬으니까 flag가 false라면 "데이터가 검색되지 않습니다"출력
						//boolean은 true아니면 false만 있다 조건문에서 flag쓸땐 flag or !flag만 쓴다.
				System.out.println("데이터가 검색되지 않았습니다.");
			
			}
			
			
			
		}
		
		
	}

}
