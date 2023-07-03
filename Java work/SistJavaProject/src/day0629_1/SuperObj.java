package day0629_1;

/* 부모 클래스가 다른 "패키지"에 있을 경우 protected,public 변수는 접근이 가능하다.
 * 같은 패키지인 경우에는 private만 빼고 모두 접근 가능하다.
 * 
 */

public class SuperObj {

	protected String name;
	protected int age;
	
	public SuperObj(String name,int age) { //명시적 생성자 호출 (생성자명은 클래스명과 동일)
		this.name=name;
		this.age=age;
	}
}
