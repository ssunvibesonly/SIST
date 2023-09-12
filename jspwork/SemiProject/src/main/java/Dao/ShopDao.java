package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dto.ShopDto;
import mysql.db.DBConnect_2;

public class ShopDao {
	DBConnect_2 db=new DBConnect_2();
	
	//상품등록 insert
	public void ShopInsert(ShopDto dto) {
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		String sql="insert into shop values(null,?,?,?,?,?,now())";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getShop_category());
			pstmt.setString(2, dto.getShop_sangpum());
			pstmt.setString(3, dto.getShop_detail());
			pstmt.setString(4, dto.getShop_photo());
			pstmt.setInt(5, dto.getShop_price());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			db.dbClose(pstmt, conn);
		}
		
	}
	
	//스토어에 전체 이미지 조회
	public List<ShopDto> getAllData(){
		
		List<ShopDto> list=new ArrayList<ShopDto>();
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from shop order by shop_num";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				
				ShopDto dto=new ShopDto();
				
				dto.setShop_num(rs.getString("shop_num"));
				dto.setShop_category(rs.getString("shop_category"));
				dto.setShop_sangpum(rs.getString("shop_sangpum"));
				dto.setShop_detail(rs.getString("shop_detail"));
				dto.setShop_photo(rs.getString("shop_photo"));
				dto.setShop_price(rs.getInt("shop_price"));
				dto.setShop_ipgoday(rs.getTimestamp("shop_ipgoday"));
				
				list.add(dto);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
}
