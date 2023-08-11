package db.simpleguest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import mysql.db.DBConnect_2;

public class SimpleGuestDAO {
	
	DBConnect_2 db=new DBConnect_2();
	
	//insert
	public void insertSimple(SimpleGuestDTO dto) {
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		String sql="insert into simpleguest values(null,?,?,?,?,now())";
		//String sql="insert into simpleguest (image,nick,pass,story,writeday)values(?,?,?,?,now());
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getImage());
			pstmt.setString(2, dto.getNick());
			pstmt.setString(3, dto.getPass());
			pstmt.setString(4, dto.getStory());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
	}
	
	//select
	public Vector<SimpleGuestDTO> getAllData(){
		Vector<SimpleGuestDTO> list=new Vector<>();
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from simpleguest order by num desc";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				SimpleGuestDTO dto=new SimpleGuestDTO();
				
				dto.setNum(rs.getString("num"));
				dto.setImage(rs.getString("image"));
				dto.setNick(rs.getString("nick"));
				dto.setPass(rs.getString("pass"));
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
	public void deleteSimple(String num) {
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		String sql="delete from simpleguest where num=?";
		
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
	
	//getData()
	public SimpleGuestDTO getData(String num) {
		SimpleGuestDTO dto=new SimpleGuestDTO();
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from simpleguest where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setNum(rs.getString("num"));
				dto.setImage(rs.getString("image"));
				dto.setNick(rs.getString("nick"));
				dto.setStory(rs.getString("story"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
		
	}
	
	
	//비밀번호 비교
	//비밀번호가 맞으면 true, 틀리면 false
	public boolean isEqualPass(String num,String pass){
		boolean flag=false;
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from simpleguest where num=? and pass=?"; //where조건이 두개일 땐 and로 연결
		
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
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return flag;
		
	}
	//데이터 수정.. 비번이 맞을 경우에만 호출할 것이므로
	//비번은 조건에 안넣을 예정
	//수정: 닉네임,이미지,스토리
	public void updateGuest(SimpleGuestDTO dto) {
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		String sql="update simpleguest set nick=?,image=?, story=? where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getNick());
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
