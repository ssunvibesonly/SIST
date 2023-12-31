package day0615;

public class SpecialChar_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 문자열 내에서 특별한 의미로 해석되는 문자를 이스케이프 시퀀스(Escape Sequence)
		// 이스케이프 시퀀스(Escape Sequence)는 모두 \로 시작함 -> \뒤에 문자에 해당하는 값이 적용되어 도출
		/* 
		 * \t : 다음 탭 위치로 이동(문자 다음에 \t를 하면 탭 한 번 친다는 소리)
		 * \n : 다음 줄로 이동
		 * \" : 쌍따옴표
		 * \' : 홑따옴표
		 * \\ : 백슬래쉬 기능 -> \하나가 나옴
		 * */
		
		System.out.println("Apple\tMelon");
		System.out.println("Orange\tKiwi\tBanana");
		System.out.println("Apple\\");
		System.out.println("Apple\"");
		System.out.println("Apple\'");
		
		// "Hello"
		System.out.println("\"Hello\"");
		// c:\
		System.out.println("c:\\");
		
		//Q. "red", "green", "blue"
		System.out.println("\"red\",\"green\",\"blue\""); //,는 +연결 안함
		
	}

}
