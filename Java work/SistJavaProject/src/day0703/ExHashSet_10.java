package day0703;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Set : 데이터의 중복 허용 불가능, 순서를 유지하지 않는 집합
 * List : 데이터의 중복 허용 가능, 순서 유지 가능 * List는 인터페이스므로 생성 안됨(자식으로 생성) Array List는 클래스다
 * Map : key값을 알면 value값 구하기 가능
 */

public class ExHashSet_10 {

	public static void main(String[] args) {
		// 컬렉션-자료구조(set,vector,arraylist)
		//컬렉션이 복수의 자료형 저장_안정성이 떨어질 수 있으므로 나온 것이 제네릭<>
		//(인터페이스 or 클래스)<데이터형> 객체이름=new 클래스명<데이터형>;
		
		Set<String> set1=new HashSet<String>(); //HashSet은 Set에 해당하는 클래스
		//Set에 String 데이터를 담겠다. - Set은 인터페이스이므로 객체 생성이 안된다.
		
		//추가..배열에 비해 가변적
		set1.add("사과");
		set1.add("포도");
		set1.add("사과");//중복되었으므로 갯수 포함 안됨
		set1.add("키위");
		set1.add("오렌지");
		
		System.out.println("데이타 갯수: "+set1.size());
		
		System.out.println("출력#1_for~each");

		for(String a:set1)
			System.out.println(a);
		
		System.out.println();
		System.out.println("출력#2_Iterator");
		
		Iterator<String> iter=set1.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println("출력#3_for");
		
		Object [] ob=set1.toArray();
		for(int i=0;i<ob.length;i++) {
			System.out.println(ob[i]);
		}
		
		//모든 데이터 삭제
		set1.clear();
		
		if(set1.isEmpty())
			System.out.println("Set타입 안에 데이터가 없다.");
		else
			System.out.println("Set타입 안에 데이터가 있다.4");

	}

}
