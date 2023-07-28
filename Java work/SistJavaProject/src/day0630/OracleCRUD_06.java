package day0630;

import java.util.Scanner;

abstract class Command{
	
	abstract public void write();//==public abstract void
	
}
/////////////////////////////////////
class Insert1 extends Command{

	@Override
	public void write() {
		
		System.out.println("출력합니다.");
		
	}
	
	
}
/////////////////////////////////////
class List extends Command{

	@Override
	public void write() {
		System.out.println("조회합니다.");
		
	}
	
	
}
///////////////////////////////////////
class Modify extends Command{

	@Override
	public void write() {
		System.out.println("수정합니다.");
		
	}
	
}
//////////////////////////////////////
class Delete1 extends Command{

	@Override
	public void write() {
		System.out.println("삭제합니다.");
		
	}


}
///////////////////////////////////////
public class OracleCRUD_06 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		Command c=null;//메서드는 초기값 선언해줘야한다.
		
		int a=0;//메서드 안에서 생성한 변수는 초기값을 선언해줘야한다.(int a=0;은 main메서드 안에서 선언된 변수이다.)
		
		while(true) {
			
			System.out.println("1.추가 2.조회 3.수정 4.삭제 0:종료");
			System.out.println("===============================");
			a=sc.nextInt();
			
			switch(a) {
			
			case 1:
				c=new Insert1();
				break;
			case 2:
				c=new List();
				break;
			case 3:
				c=new Modify();
				break;
			case 4:
				c=new Delete1();
				break;
			case 0:
				System.out.println("종료합니다.");
				System.exit(0);
				
			}
			if(a<=4)
				c.write();
			
		
		}
		

	}

}
