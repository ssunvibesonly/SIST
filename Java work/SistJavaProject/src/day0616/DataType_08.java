package day0616;

public class DataType_08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		byte a = 127;//-128~127
		byte b = (byte)128; // 더 작은 자료형으로의 변환(디모션_값손실) -128~127이라서 127이상의 값을 넣으면 그 다음값인 -128로 출력된다.
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		
		int x = 7;
		int y = 4;
		
		System.out.println(x/y); //정수형끼리의 계산결과는 무조건 int타입(정수)
		System.out.println((double)x/y);//계산시 x를 double로 변환해서 계산 따라서 계산 결과는 double
		System.out.println(x/(double)y);// x나 y 둘 중 하나만 double형이 되면 결과는 double이다.
		
		//강제 형변환
		
		double d=100.0;
		int i = 100;
		
		int result = (int)d+i;
		double result2 = (double)d+i;//양쪽 그릇의 크기가 맞으면 굳이 우측에 형을 적어주지 않아도 되나 적어도 상관없다.
		
		System.out.println("d = " + d);
		System.out.println("i = " + i);
		System.out.println("result = "+ result);
		System.out.println("result2 = "+ result2);
	}

}
