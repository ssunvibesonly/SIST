package model.idx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mysql.db.DBConnect_2;

public class idxDao {
	DBConnect_2 db=new DBConnect_2();
	
	//아이디 통해서 이름 얻기 => 로그인할 때 id를 통해서 하니까 id를 통해 이름을 얻으며, 로그인 후에 값을 꺼낸다고 시퀀스를 가져오면 또 메서드를 만들어줘야함
	public String getName(String id) {
		
		String name="";
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from idx where id=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				name=rs.getString("name");
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
				
		return name;
		
	}
	//id에 맞는 pass인지 확인
	public boolean isLogin(String id,String pass) {
		
		boolean flag=false;
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from idx where id=? and pass=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		
		return flag;
	}
}
