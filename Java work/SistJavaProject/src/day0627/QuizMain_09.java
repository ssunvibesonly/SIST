package day0627;

public class QuizMain_09 {

	public static void main(String[] args) {
		System.out.println("\t[쇼핑 목록]");
		
		Quiz_09.setPlace("이마트");
		Quiz_09.getPlace();
		System.out.println("쇼핑장소: "+Quiz_09.getPlace());//place는 static으로 설정했기 때문에 객체 생성 없이 바로 사용할 수 있다.
		
		Quiz_09 s1=new Quiz_09();
		s1.setSname("손선풍기");
		s1.setPrice(25000);
		String sang=s1.getsName();
		int pri=s1.getprice();
		System.out.println("상품명: "+sang+"\n가격: "+pri+"원");
		
		System.out.println("========================");
		
		Quiz_09.getPlace();
		System.out.println("쇼핑장소: "+Quiz_09.getPlace());
		Quiz_09 s2=new Quiz_09();
		s2.setSname("휴대폰 충전기");
		s2.setPrice(30000);

		String sang1=s2.getsName();
		int pri1=s2.getprice();
		
		System.out.println("상품명: "+sang1+"\n가격: "+pri1+"원");
		
		System.out.println("========================");
		
		Quiz_09.getPlace();
		System.out.println("쇼핑장소: "+Quiz_09.getPlace());
		
		Quiz_09 s3=new Quiz_09();
		s3.setSname("이어폰");
		s3.setPrice(70000);
		
		System.out.println("상품명: "+s3.getsName());
		System.out.println("가격: "+s3.getprice());
		
		System.out.println("========================");
		
		

	}

}
