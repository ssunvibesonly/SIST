package spring.anno.last;

import org.springframework.stereotype.Component;

@Component //<bean> ref 해주기 위해 
public class ShopDao implements Shopinter {

	@Override
	public void insertSangpum(String sangpum, int price, String color) {
		// TODO Auto-generated method stub
		System.out.println(sangpum+":"+price+":"+color);

	}

	@Override
	public void deleteSangpum(String num) {
		// TODO Auto-generated method stub
		System.out.println(num+"번 삭제됨");
	}

	@Override
	public void selectShop(String sangpum, int price, String color) {
		// TODO Auto-generated method stub
		System.out.println("**상품 관리**");
		System.out.println("**상품관리**");
	      System.out.println("상품명:"+sangpum);
	      System.out.println("가격:"+price);
	      System.out.println("색상:"+color);

	}

}
