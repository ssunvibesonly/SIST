package day0627;

class Student{
	
	private String name; //null
	private int age; //0
	
	//setter_method
	//인스턴스변수에 저장된 데이터를 수정할 목적(set변수명) : 수정할 인자값이 있다.
	//저장, 수정 용도이므로 return(결과값)이 없다. 따라서 void로 지정
	public void setName(String name) {
		
		this.name=name;
		
	}
	
	public void setAge(int age) {
		
		this.age=age;
		
	}
	
	//getter_method
	//인스턴스 변수에 저장된 데이터를 조회할 목적으로 사용(get변수명)
	//데이터를 얻는 목적이므로 호출 데이터를 넘겨줄 필요가 없기 때문에 인자값(파라메터값)이 없다.
	//실행 결과를 돌려주므로 "return 결과값"으로 지정
	
	public String getName() {
		
		return name;
	}
	
	public int getAge() {
		
		return age;
	}
	
}

////////////////////////////////////
public class SetGetMethod_07 {

	public static void main(String[] args) {
		//1. 객체 생성
		Student stu1=new Student();
		
		//2. 참조변수명으로 set 메서드 호출
		stu1.setName("장순영");
		stu1.setAge(28);
		
		//3. get메서드를 통한 값얻기
		String name=stu1.getName();
		int age=stu1.getAge();
		
		//출력
		System.out.println(name+""+age);
	
		Student stu2=new Student();
		stu2.setName("이제훈");
		stu2.setAge(40);
		
		/*String name1=stu2.getName();
		int age1=stu2.getAge(); => 출력할 때 깔끔하게 출력하려고 이처럼 쓴다.*/
		
		System.out.println(stu2.getName()+" "+stu2.getAge());
		
		/*System.out.println(name1+" "+age1); => 출력할 때 깔끔하게 출력하려고 이처럼 쓴다.*/
		
	}

}
