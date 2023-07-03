package day0628;

class Student{
	
	private String name;
	private String hp;
	private int grade;
	
	//명시적 생성자 => 생성자의 역할: 생성과 동시에 초기값 할당
	public Student(String name,String hp,int grade) {
		this.name=name;
		this.hp=hp;
		this.grade=grade;
	}
	
	//멤버값 출력데이타
	public void getData() {
		System.out.println("이름: "+name+" 핸드폰 번호: "+hp+" 학년: "+grade);
	}
	
}

//////////////////////////////////
public class ArrObject_09 {

	public static void main(String[] args) {
		
		/*Student [] stu=new Student[3];
		
		stu[0]=new Student("이민규", "010-1111-2222", 3);
		stu[1]=new Student("최진평", "010-3333-2442", 1);
		stu[2]=new Student("진현규", "010-1234-5972", 4);*/
		
		//생성하면서 바로 초기화
		Student [] stu= {new Student("이민규", "010-1111-2222", 3), 
				new Student("최진평", "010-3333-2442", 1),
				new Student("진현규", "010-1234-5972", 4)
		};
		
		//출력#1
		for(int i=0;i<stu.length;i++) {
			
			Student s=stu[i];
			s.getData();
			//stu[i].getData();
			System.out.println("----------------------------------");
		}
		
		//출력#2 for~each문
		for(Student s1:stu) {//클래스명 변수:변수명
			s1.getData();
			System.out.println("=================================");
		}

	}

}
