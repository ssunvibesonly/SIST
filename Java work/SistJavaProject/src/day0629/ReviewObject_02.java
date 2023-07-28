package day0629;

class Starbucks{
	
	private String store;//지점
	private String menu;//메뉴
	private String goods;//텀블러 등
	
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getGoods() {
		return goods;
	}
	public void setGoods(String goods) {
		this.goods = goods;
	}
	
	
}



/////////////////////////////////////
public class ReviewObject_02 {

	public static void main(String[] args) {

		Starbucks m1=new Starbucks();
		m1.setStore("코엑스");
		m1.setMenu("아이스 아메리카노");
		m1.setGoods("우산");
		String message1=m1.getStore();
		String message2=m1.getMenu();
		String message3=m1.getGoods();
		System.out.println("나는 스타벅스 "+message1+"매장에 왔습니다."+
		"\n"+message2+"를 주문합니다."+"\n"+message3+"을 샀어요");
		
		
		
		

	}

}
