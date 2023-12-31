package day0616;

public class QuizDataType_10 {

	public static void main(String[] args) {
		/* 매개변수(args)를 이용하여 출력해보세요
		 * [시험결과]
		 * Java=88, Jsp=77, Spring=99
		 * 총점 : 264점
		 * 평균 : 88.00점 */
		
		int java = Integer.parseInt(args[0]);
		int jsp = Integer.parseInt(args[1]);
		int spring = Integer.parseInt(args[2]);
		
		int total = java + jsp + spring;
		double avg = total/3.0;
		
		System.out.println("[시험결과]");
		System.out.println("Java=" + java + " Jsp=" + jsp + " Spring=" + spring);
		System.out.println("총점 : " + total);
		System.out.printf("평균 : %.2f", avg); 
		
		// 선생님 풀이
		
		// 변수 선언&계산
		/*int java = Integer.parseInt(args[0]);
		int jsp = Integer.parseInt(args[1]);
		int spring = Integer.parseInt(args[2]);
		int count=3; //3과목을 의미하는 변수
		int tot=java+jsp+spring;
		
		double avg1=tot/count;//결과가 무조건 int
		double avg2=(double)tot/count; // 결과가 double
		
		System.out.println("[시험결과]");
		System.out.printf("java=%d, jsp=%d, spring=%d\n",java,jsp,spring);
		System.out.println("총점 : " + tot + "점");
		System.out.printf("평균 : %.2f", avg1);*/
		
		
	

		

		
	}

}
