package day0703;

import java.util.HashSet;
import java.util.Set;

public class SetInt_11 {

	public static void main(String[] args) {
		HashSet<Integer> set1=new HashSet<Integer>(); //Set은 인터페이스 HashSet은 클래스
		
		set1.add(11);
		set1.add(4);
		set1.add(66);
		set1.add(3);
		set1.add(12);
		set1.add(4);
		
		System.out.println("갯수: "+set1.size());
		
		System.out.println("출력#3_for");
		
		Object [] ob=set1.toArray();
		for(int i=0;i<ob.length;i++) {
			System.out.printf("%5d",ob[i]);
		}
		
		
	}

}
