package day0704;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

/*
 1.상품 입고 2.상품 재고 9.종료
 1
 상품명? 바나나
 수량? 10
 가격? 1000
 2
 번호 상품명    수량    가격    총가격
 1   바나나 	  10개   1000원  10000원
 */

public class ShopMain_03 {
	
	List<Shop> list=new Vector<Shop>(); //List는 new가 안되서 Vector로 new
	
	//입력
	public void inputShop() {
		Scanner sc=new Scanner(System.in);
		
		String sang;
		int su,dan;
		
		System.out.println("상품명?");
		sang=sc.nextLine();
		System.out.println("수량?");
		su=Integer.parseInt(sc.nextLine());
		System.out.println("가격?");
		dan=Integer.parseInt(sc.nextLine());
		
		/*Shop data=new Shop(sang, su, dan);
		list.add(data);*/
		
		}
	
	//출력
	public void outPutShop() {
		System.out.println("번호\t상품명\t수량\t가격\t총가격");
		System.out.println("==============================");
		
		for(int i=0;i<list.size();i++) {
			Shop s=list.get(i);
			int total=s.getSu()*s.getDan();
			System.out.println(i+1+"\t"+s.getSangName()+"\t"+s.getSu()+"\t"+s.getDan()+"\t"+total);
			
		}
		
		
	}
	

	public static void main(String[] args) {
		
		ShopMain_03 sh=new ShopMain_03();// 생성 안해주면 메서드 호출 안됨 ex) sh.inputShop();
		
		Scanner sc=new Scanner(System.in);
		int a;
		
		while(true) {
			
			System.out.println("1.상품 입고\t2.상품 재고\t9.종료");
			a=Integer.parseInt(sc.nextLine());
			
			if(a==1)
				sh.inputShop();
			else if(a==2)
				sh.outPutShop();
			else if(a==9) {
				System.out.println("시스템 종료");
				break;}
			else {
				System.out.println("잘못입력했어요");
				continue;}
			
			
			
			
		}
		

	}

}
