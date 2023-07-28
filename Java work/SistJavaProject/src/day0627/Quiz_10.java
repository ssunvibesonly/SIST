package day0627;

public class Quiz_10 {

	//멤버변수 선언
	private String sangpum; //상품명
	int su; //수량
	int dan; //단가
	static String SHOPNAME; //상점
	
	
	//sangpum_set,getMethod
	public void setSangpum(String sang) {
		
		sangpum=sang;
	
	}
	public String getSangpum() {
		return sangpum;	//sang은 지역변수이기 때문에 당연히 return값은 sangpum으로 줘야한다.
	}
	
}
