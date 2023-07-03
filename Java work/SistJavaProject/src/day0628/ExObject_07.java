package day0628;

class Score{
	
	private String stuName;
	private int java;
	private int oracle;
	private int html;
	
	static final String TITLE="중간고사 시험결과";

	//자동 setter, getter
	
	public String getStuName() { //메서드는 원래 하나의 값을 가져오는 것이 원칙이긴 하나 여러개도 가져올 순 있다.
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public int getOracle() {
		return oracle;
	}

	public void setOracle(int oracle) {
		this.oracle = oracle;
	}

	public int getHtml() {
		return html;
	}

	public void setHtml(int html) {
		this.html = html;
	}

	//합계 메서드
	public int getTot() {
		
		int t=java+oracle+html;
		return t;
	}
	
	//평균 메서드
	public double getAvg() {
		
		return getTot()/3.0; // double a=getTot()/3.0; return a;
	}
	
	
}


public class ExObject_07 {

	public static void main(String[] args) {
		System.out.println("***"+Score.TITLE+"***");
		
		Score m1=new Score();
		m1.setStuName("김지윤");
		m1.setJava(99);
		m1.setOracle(88);
		m1.setHtml(56);
		System.out.println("학생명: "+m1.getStuName()+"\n자바 점수: "+m1.getJava()+"\n오라클 점수: "+m1.getOracle()+"\nHTML 점수: "+m1.getHtml());
		System.out.println("합계: "+m1.getTot());
		System.out.println("평균: "+m1.getAvg());
		System.out.println("=====================================================");
		
		Score m2=new Score();
		m2.setStuName("김동현");
		String name=m2.getStuName();
		m2.setJava(79);
		int java=m2.getJava();
		m2.setOracle(68);
		int ora=m2.getOracle();
		m2.setHtml(76);
		int html=m2.getHtml();
		System.out.println("학생명: "+name+"\n자바 점수: "+java+"\n오라클 점수: "+ora+"\nHTML 점수: "+html);
		System.out.println("합계: "+m2.getTot());
		System.out.printf("평균:%.2f",m2.getAvg());//소수점 자리 지정 하고 싶을땐 ,로 연결한다.

	}

}
