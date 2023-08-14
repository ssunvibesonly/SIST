package model.visitlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import mysql.db.DBConnect_2;

public class visitListDAO {
	DBConnect_2 db=new DBConnect_2();
	
	//삽입
	public void insertVisit(visitListDTO dto) {
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		String sql="insert into visitlist values(null,?,?,?,?,now())";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getNick());
			pstmt.setString(2, dto.getPass());
			pstmt.setString(3, dto.getImage());
			pstmt.setString(4, dto.getStory());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	//조회
	public Vector<visitListDTO> selecVisit(){
		Vector<visitListDTO> list=new Vector<visitListDTO>();
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from visitlist";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				visitListDTO dto=new visitListDTO();
				
				dto.setNum(rs.getString("num"));
				dto.setNick(rs.getString("nick"));
				dto.setPass(rs.getString("pass"));
				dto.setImage(rs.getString("image"));
				dto.setStory(rs.getString("story"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				list.add(dto);

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return list;

	}
	//삭제
	public void delVisit(String num) {
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		String sql="delete from visitlist where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	//패스워드 조회
	//일단 먼저 시퀀스값과 패스워드를 뽑아야하므로(비밀번호가 같은 경우 시퀀스 값으로 찾기 때문에) select
	
	public boolean isEqual(String num,String pass) {
		boolean flag=false;
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from visitlist where num=? and pass=?";//조회하려는 값이 두개일때 where에서는 and로 이어준다.
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			
			pstmt.setString(1, num);
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
	//하나의 데이터 조회
	public visitListDTO updateSel(String num) {
		visitListDTO dto=new visitListDTO();
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from visitlist where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				dto.setNum(rs.getString("num"));
				dto.setNick(rs.getString("nick"));
				dto.setImage(rs.getString("image"));
				dto.setStory(rs.getString("story"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dto;
		
		
	}
	//수정
	
	public void updateVisit(visitListDTO dto) {
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		String sql="update visitlist set nick=?,image=?,story=? where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getNick() );
			pstmt.setString(2, dto.getImage());
			pstmt.setString(3, dto.getStory());
			pstmt.setString(4, dto.getNum());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
