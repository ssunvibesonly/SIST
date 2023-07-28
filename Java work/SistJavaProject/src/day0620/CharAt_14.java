package day0620;

public class CharAt_14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String juminNum="960719-53213468";
		//index순서 01234567...
		char seventh=juminNum.charAt(7);//7번째 자리를 확인할거라 변수를 seventh로 만들었다
		
		System.out.println(seventh);
		//남자입니다 or 여자입니다 or 2000년 이후 남자 입니다 or 2000년 이후 여자 입니다
		
		if(seventh=='1')
			System.out.println("남자입니다.");
		else if(seventh=='2')
			System.out.println("여자입니다.");
		else if(seventh=='3')
			System.out.println("2000년 이후 남자 입니다.");
		else if(seventh=='4')
			System.out.println("2000년 이후 여자 입니다.");
		else
			System.out.println("오류입니다.");
		
		//switch로도 해보기(집가서)
		
		
	}

}
