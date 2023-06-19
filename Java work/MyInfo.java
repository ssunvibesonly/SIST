//Q. 다음과 같이 결과가 나오도록 자바클래스를 구현해보세요
 /* 컴파일 명령어 : javac MyInfo.java
     실행명령어 : java MyInfo 영어영문학과 2
     결과 : 
    ==============
    [학생 개인정보]
    ==============
    전공 : 영어영문학과
    학년 : 2학년 */


class MyInfo{ //public class를 쓰던 class를 쓰던 상관없다!

  public static void main(String [] a){

    System.out.println("==============");
    System.out.println("[학생 개인정보]");
    System.out.println("==============");
    System.out.println("전공 : " + a[0]);
    System.out.println("학년 : " + a[1] + "학년");


}


}

