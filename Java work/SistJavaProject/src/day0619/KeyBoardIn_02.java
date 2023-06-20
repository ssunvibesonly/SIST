package day0619;

import java.util.Scanner;

public class KeyBoardIn_02 {

	public static void main(String[] args) {
		// Scanner는 문자열이나 숫자를 모두 키보드로 입력받으려 할 때 생성
		Scanner sc=new Scanner(System.in); //Scanner + ctrl + space바를 통해 Scanner import
		
		//변수
		String name,city;
		int age;
		
		//출력(입력문)
		System.out.println("이름을 입력해 보세요!");
		name=sc.nextLine(); //한줄을 문자로 읽어온다(공백 사용 가능)
		
		System.out.println("나이를 입력해 보세요!"); //age=sc.nextInt() 숫자를 읽어온다.
		age=Integer.parseInt(sc.nextLine());//숫자입력과 동시에 라인도 띄어준다
		//숫자 입력 후 엔터를 누르면 그 엔터가 키보드 버퍼로 저장되어서 다음 문자열을 읽을 때  먼저 읽어버리는 문제 발생
		//그래서 다음 문자열 읽기 전에 형변환 안에 sc.nextLine()
		
		System.out.println("당신이 사는 지역은?");
		city=sc.nextLine();
		
		//최종 출력
		System.out.println("내 이름은 "+name+"입니다.");
		System.out.println("내 나이는 "+age+"입니다.");
		System.out.println("내가 사는 지역은 "+city+"입니다.");
	}

}
