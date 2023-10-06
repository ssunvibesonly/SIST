package spring.anno.last;

public interface Shopinter {

	public void insertSangpum(String sangpum,int price,String color); //추상메서드
	public void deleteSangpum(String num);
	public void selectShop(String sangpum,int price,String color);
}
