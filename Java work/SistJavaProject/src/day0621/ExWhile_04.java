package day0621;

public class ExWhile_04 {

	public static void main(String[] args) {

		int i=1;
		
		while(i<10){	
		System.out.println("Java"+i);
		i++;
	}
		System.out.println("종료");
	
		i=1; //새로운 조건을 시작할 때마다 꼭 변수 선언 해주어야 한다. 
			//위에서 int i=1 선언해줬으므로 하단에는 i를 쓸거라면 i=1선언해준다.
		while(true) {
			System.out.println("Java"+i);
			i++;
			
			//break
			if(i==10) //i>=10같아도 10일 때 break가 되므로 i==10이랑 break 했을 때와 같다.
				break;
			
	}
		
}
}