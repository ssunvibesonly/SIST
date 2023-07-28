package day0627;

public class QuizInfo_0 {
	
	private static String schoolName;
	private String stuName;
	private int age;
	private String mb;
	
	//set은 void만 가능한데 void가 의미하는게 반환값이 없을 때 쓰는 것이다. set은 
	//값을 출력해서 보려는게 아니라 말그대로 수정만 하려는것이기 때문에 void를써주고,
	//파라메터값에 자료형이 들어가는 것은 말그대로 인자를 넘겨준다는 것만을 의미
	
	//set
	public static void setschoolName(String name) {
		schoolName=name;
	}
	
	public void setstuName(String stuname) {
		this.stuName=stuname;
	}
	
	public void setAge(int age) {
		this.age=age;
	}
	public void setMb(String mb) {
		this.mb=mb;
	}

	//get
	public static String getschoolName() {
		return schoolName;
	}
	public String getstuName() {
		return stuName;
	}
	public int getage() {
		return age;
	}
	
	public String getmb() {
		return mb;
	}


}
