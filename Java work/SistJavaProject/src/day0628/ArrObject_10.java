package day0628;

class MyPersonalInfo{
	
	private String name;
	private String blood;
	private String age;
	
	public MyPersonalInfo(String name,String blood, String age) {
		this.name=name;
		this.blood=blood;
		this.age=age;
		
	} 
	//제목
	public static void title() {
		
		System.out.println("이름\t혈액형\t나이");
		System.out.println("----------------------------");
	}
	
	
	//츌력
	public void getInfo() {
		System.out.println(name+"\t"+blood+"형\t"+age);
	}
	
}

public class ArrObject_10 {

	public static void main(String[] args) {
		
		//생성 초기화
		MyPersonalInfo [] my= {new MyPersonalInfo("이효리", "B", "23"),
				new MyPersonalInfo("이상순", "A", "33"),
				new MyPersonalInfo("제니", "AB", "35")};
		
		System.out.println("총 "+my.length+"명의 정보 출력");
		MyPersonalInfo.title();
		
		//출력
		for(MyPersonalInfo info:my)
			info.getInfo();
		
		System.out.println("-----------------------------------------");
		
		MyPersonalInfo.title();

		for(int i=0;i<my.length;i++) {
			my[i].getInfo();
		}
	}

}
