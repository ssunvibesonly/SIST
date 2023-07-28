package day0615;

public class ArgsTest_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 실행할 때 매개변수를 보내서 출력하세요 : 마우스 우클릭 -> Run as -> Run Configuration -> Java Application -> Arguments
		/* 안녕~ 내 이름은 유재석이고 나의 직업은 개그맨이야*/
		/* 새로운 클래스를 생성하고 매개변수(Arguments)를 적용해주어야 된다면, 코드 생성 전에 run을
		실행하고 코드를 작성해준다 왜냐하면 run을 해주면 Java Application이 신규거로 적용되기 때문이다*/
		System.out.print("안녕~ 내 이름은 " + args[0] + "이고 나의 직업은 " + args[1] + "이야");

	}

}
