package day0623;

import java.util.Random;

public class Random_02 {

	public static void main(String[] args) {
		//Random클래스
		
		Random rd=new Random();
		
		System.out.println("0~9사이의 난수 발생");
		for(int i=1;i<=3;i++) {
			int n=rd.nextInt(10)+1;//random클래스 안에 포함된 nextInt()의 괄호 안에 숫자를 넣으면 0~9까지의 숫자가 발생/
			System.out.println(n); //  rd.nextInt(10)은 *10
		}
		
		
	}

}
