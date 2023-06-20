package day0619;

public class OperTest_06 {

	public static void main(String[] args) {
		// 증감연산자 ++,--
		int a,b;
		a=b=5;
		
		//단항일 경우에는 앞에 증감연산자를 붙이나 뒤에 붙이나 같다.
		++a; //원래 a값에서 1증가
		b++; 
		
		System.out.println("a="+a+", b="+b);
		
		//수식에서 사용할 때는 전치, 후치의 결과값이 틀리다.
		int m,n;
		m=n=0;
		a=b=5;
		
		m=a++;//후치수식이므로 1.a=5를 m에 먼저 대입해주고 2. a를 ++한다. 따라서 m=5,a=6
		System.out.println("m="+m+", a="+a);//
		
		n=++b;//전치이므로 ++된 b의값을 n과 b 모두 적용된다/먼저 증가 후 대입
		System.out.println("n="+n+", b="+b);

	}

}
