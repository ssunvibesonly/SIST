package dbtest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

public class PrepareMyShop {

	DBConnect db=new DBConnect();
	Scanner sc=new Scanner(System.in);
	
	//insert 
	public void insertMyShop() {
		//Connection
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		System.out.println("상품명은?");
		String sang=sc.nextLine();
		System.out.println("수량?");
		int su=Integer.parseInt(sc.nextLine());
		System.out.println("가격은?");
		int dan=Integer.parseInt(sc.nextLine());
		
		//sql..PreparedStatement는 미완의 sql문 작성
		String sql="insert into myshop values(seq1.nextval,?,?,?,sysdate)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//?를 순서대로 바인딩
			pstmt.setString(1, sang);
			pstmt.setInt(2, su);
			pstmt.setInt(3,dan);
			
			//업데이트
			int a=pstmt.executeUpdate();
			
			if(a==1)
				System.out.println("인서트 성공!");
			else
				System.out.println("인서트 실패!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	//select
	public void selectMyShop() {
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from myshop";
		
		
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			System.out.println("시퀀스\t상품명\t수량\t가격\t입고일");
			System.out.println("-----------------------------------------");
			
			while(rs.next()) {
				int snum=rs.getInt("shopnum");
				String sang=rs.getString("sangpum");
				int su=rs.getInt("su");
				int pri=rs.getInt("price");
				Date ipgo=rs.getDate("ipgo");
				
				System.out.println(snum+"\t"+sang+"\t"+su+"\t"+pri+"\t"+ipgo);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("select error:"+e.getMessage());
		}finally {
			db.dbClose(rs, pstmt, conn);
		}

	}
	//delete..시퀀스 번호 입력후 삭제
	public void deleteMyShop() {
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		System.out.println("삭제할 시퀀스는?");
		int num=Integer.parseInt(sc.nextLine());
		
		String sql="delete from myshop where shopnum=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//?바인딩
			pstmt.setInt(1, num);
			
			int a=pstmt.executeUpdate();
			if(a==1)
				System.out.println("**삭제 성공**");
			else
				System.out.println("**삭제 실패**");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}	
	}
	//수정할 시퀀스가 존재?
	public boolean isData(String shopnum) {
		boolean flag=false;
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from myshop where shopnum=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//?
			pstmt.setString(1, shopnum);
			rs=pstmt.executeQuery();
			
			if(rs.next())
				flag=true;
			else 
				flag=false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		
		
		return flag;
	}
	
	//수정..시퀀스 입력 후 수정할 데이타 수정
	public void updateMyShop() {
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		System.out.println("수정할 시퀀스 번호?");
		String num=sc.nextLine();
		
		//여기서 시퀀스가 없다면 종료
		if(!isData(num)) {
			System.out.println("해당 번호는 존재하지 않습니다");
			return;
		}
		System.out.println("수정할 상품명?");
		String sang=sc.nextLine();
		System.out.println("수정할 수량은?");
		int su=Integer.parseInt(sc.nextLine());
		System.out.println("수정할 가격은?");
		int price=Integer.parseInt(sc.nextLine());
		
		//sql
		
		String sql="update myshop set sangpum=?,su=?,price=? where shopnum=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//4개 순서대로 바인딩
			pstmt.setString(1, sang);
			pstmt.setInt(2, su);
			pstmt.setInt(3, price);
			pstmt.setString(4, num);

			//업데이트
			pstmt.execute();
			
			System.out.println("수정 성공!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//검색
	public void searchSangpum() {
		
		System.out.println("검색할 상품명(일부)");
		String sang=sc.nextLine();
		
		String sql="select * from myshop where sangpum like ?";
		System.out.println(sql);
		
		System.out.println("시퀀스\t상품명\t수량\t단가\t날짜");
		
		System.out.println("-----------------------------------------");
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+sang+"%");
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
		
					int snum=rs.getInt("shopnum");
					String sangpum=rs.getString("sangpum");
					int su=rs.getInt("su");
					int pri=rs.getInt("price");
					Date ipgo=rs.getDate("ipgo");
					
					System.out.println(snum+"\t"+sangpum+"\t"+su+"\t"+pri+"\t"+ipgo);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
	
	}
	
	public static void main(String[] args) {
		PrepareMyShop shop=new PrepareMyShop();
		Scanner sc=new Scanner(System.in);
		int n;
		
		while(true) {
			System.out.println("***상품 입고***");
			System.out.println("1. 상품 추가 2.상품 삭제 3. 상품수정 4. 상품 전체 출력 5.상품 검색 9. 종료");
			n=Integer.parseInt(sc.nextLine());
			
			if(n==1) {
				shop.insertMyShop();
			}
			else if(n==2) {
				shop.deleteMyShop();
			}
			else if(n==3) {
				shop.updateMyShop();
			}
			else if(n==4) {
				shop.selectMyShop();
			}
			
			else if(n==5) {
				shop.searchSangpum();
			}
			
			else if(n==9) {
				System.out.println("종료");
				break;
			}
			else {
				System.out.println("잘못 입력 했습니다.");
			}
		}
			

	}

}
