package day0627;

public class QuizInfoMain_0 {

	public static void main(String[] args) {
		System.out.println("[학생 명단]");
		
		QuizInfo_0.setschoolName("쌍용고등학교");
		System.out.println("학교명: "+QuizInfo_0.getschoolName());

		System.out.println("-------------------------------------");
		System.out.println("학생1");
		
		QuizInfo_0 s1=new QuizInfo_0();
		s1.setstuName("장순영");
		s1.setAge(28);
		s1.setMb("INTJ");
		String sname=s1.getstuName();
		int age1=s1.getage();
		String mb1=s1.getmb();
		System.out.println("이름: "+sname+"\n나이: "+age1+"\nmbti: "+mb1);
		
		System.out.println("--------------------------------------");
		System.out.println("학생2");
		
		QuizInfo_0 s2=new QuizInfo_0();
		s2.setstuName("강연주");
		s2.setAge(27);
		s2.setMb("ISTJ");
		String sname2=s2.getstuName();
		int a2=s2.getage();
		String mb2=s2.getmb();
		System.out.println("이름: "+sname2+"\n나이: "+a2+"\nmbti: "+mb2);
		System.out.println("--------------------------------------");
		
		QuizInfo_0 s3=new QuizInfo_0();
		s3.setstuName("홍길동");
		s3.setAge(100);
		s3.setMb("CUTE");
		System.out.println("이름: "+s3.getstuName()+"\n나이: "+s3.getage()+"\nmbti: "+s3.getmb());
	}

}
