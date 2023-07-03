package day0623;

public class ArrInt_06 {

	public static void main(String[] args) {
		// 선언하면서 초기값들을 동시에 저장할 수 있다.
		
		int [] arr= {5,7,8,9,12,53,46,56};
		System.out.println("개수: "+arr.length);
		
		for(int i=0;i<arr.length;i++) {
			System.out.println("출력_1: "+(i+1)+"==>"+arr[i]);
		}
		
		
		System.out.println("for~each문 출력");
		for(int i:arr) 
			System.out.println(i);	
	}

}
