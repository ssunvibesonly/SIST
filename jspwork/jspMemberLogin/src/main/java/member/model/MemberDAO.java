package member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import mysql.db.DBConnect_2;

public class MemberDAO {
//아이디 존재하면 true값을 리턴해준다.
	DBConnect_2 db=new DBConnect_2();
	
	public boolean isIdCheck(String id) {
		
		boolean flag=false;
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from spmember where id=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
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
	//insert
	public void insertMember(MemberDTO dto) {
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		String sql="insert into spmember values(null,?,?,?,?,?,now())";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPass());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getHp());
			pstmt.setString(5, dto.getImage());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
			
		}
				
		
	}
	//select
	public Vector<MemberDTO> getAllData(){
		Vector<MemberDTO> list=new Vector<MemberDTO>();
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from spmember order by num";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				MemberDTO dto=new MemberDTO();
				dto.setNum(rs.getString("num"));
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString("name"));
				dto.setHp(rs.getString("hp"));
				dto.setImage(rs.getString("photo"));
				dto.setGaip(rs.getTimestamp("gaip"));
				
				list.add(dto);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
		
	}
	
	//ID랑 패스워드 맞으면 로그인
	public boolean isEqulaIdPass(String id,String pass) {
		boolean flag=false;
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from spmember where num=? and pass=?";
		
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
		}

		return flag;
		
	}
}
