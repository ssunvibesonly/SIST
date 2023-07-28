package day0629;

class Shop{
	
	String sangpum;
	int su;
	
	public Shop(String sang, int su) {
		sangpum=sang;
		this.su=su;
		
	}
	
	public void writeShop() {
		
		System.out.println("상품: "+sangpum+"\n갯수: "+su);
	}
}
/////////////////////////////
class MyCart extends Shop{

	int price;
	
	public MyCart(String sang, int su, int price) {
		super(sang, su);
		this.price=price;
	
	}
	
	//오버라이딩
	@Override
	public void writeShop() {
		super.writeShop();
		System.out.println("가격: "+price);
	}
	

}
///////////////////////////////////
public class Inheri_06 {

	public static void main(String[] args) {
		
		MyCart s1=new MyCart("아이패드", 1, 1500000);
		s1.writeShop();

	}

}
