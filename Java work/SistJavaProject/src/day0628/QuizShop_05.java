package day0628;

class MyShop{
	private String sangpumName;
	private String ipgoday;
	private String chulgoday;

	//3개의 데이터를 한번에 수정할 수 있는 메서드
	
	public void setSang(String sName, String ip, String chul) {
		sangpumName=sName;
		ipgoday=ip;
		chulgoday=chul;
	}
	
	
	//3개의 데이타를 한번에 출력할수 있게 메서드

	/*public void getSang() {
		System.out.println("상품명: "+sangpumName+"\n입고일: "+ipgoday+"\n출고일: "+chulgoday);
	}*/
	
	public String getSang() {
		String s="상품명: "+sangpumName+"\t입고날짜: "+ipgoday+"\t출고일자: "+chulgoday;
		return s;
	}

}

////////////////////////////////////////
public class QuizShop_05 {

	public static void main(String[] args) {
		
		System.out.println("***상품입고***");
		
		MyShop a=new MyShop();
		a.setSang("키보드", "2023-06-01", "2023-06-20");
		//a.getSang();
		System.out.println(a.getSang());
		
		System.out.println("-------------------------");
		MyShop b=new MyShop();
		b.setSang("모니터", "2023-06-04", "2023-06-23");
		//b.getSang();
		System.out.println(b.getSang());
	}

}
