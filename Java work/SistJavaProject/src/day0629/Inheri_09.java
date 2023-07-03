package day0629;


class Work{
	
	public void process(){
		
		System.out.println("작업중!!!");
	}
}
//////////////////////////////
class Food1 extends Work{
	
	@Override
	public void process() {
		// TODO Auto-generated method stub
		super.process();
		System.out.println("***음식을 합니다***");
	}
}
////////////////////////////////
class Clean extends Work{
	
	@Override
	public void process() {
		// TODO Auto-generated method stub
		super.process();
		System.out.println("***청소를 합니다**");
	}
}
/////////////////////////////////////
class Study extends Work {
		@Override
		public void process() {
			// TODO Auto-generated method stub
			super.process();
			System.out.println("***공부를 합니다***");
		}
	}
	

//////////////////////////////
public class Inheri_09 {

	public static void main(String[] args) {
		
		Food1 w1=new Food1();
		w1.process();
		
		Clean w2=new Clean();
		w2.process();
		
		Study w3=new Study();
		w3.process();
		
		//다형성
		Work work;
		
		work=new Food1();
		work.process();
		
		work=new Clean();
		work.process();
		
		work=new Study();
		work.process();
		

	}

}
