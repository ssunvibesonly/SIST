package db.simpleboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import mysql.db.DBConnect_2;

public class SimpleBoardDao {
 DBConnect_2 db=new DBConnect_2();
 
 //전체 조회 => 페이징 게시판을 만들거면 전체 조회 필요없음 (왜냐? limit이 없으므로)
 public List<SimpleBoardDto> getAllDatas(){
	 List<SimpleBoardDto> list=new ArrayList<SimpleBoardDto>();
	 
	 Connection conn=db.getConnection();
	 PreparedStatement pstmt=null;
	 ResultSet rs=null;
	 
	 String sql="select * from simpleboard order by num desc";
	 
	 try {
		pstmt=conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		
		
		while(rs.next()) {
			SimpleBoardDto dto=new SimpleBoardDto();
			dto.setNum(rs.getString("num"));
			dto.setWriter(rs.getString("writer"));
			dto.setPass(rs.getString("pass"));
			dto.setSubject(rs.getString("subject"));
			dto.setStory(rs.getString("story"));
			dto.setReadcount(rs.getInt("readcount"));
			dto.setWriteday(rs.getTimestamp("writeday"));
			
			list.add(dto);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	 
	 return list;
	 
 }
 
 //num에 해당하는 dto반환
 public SimpleBoardDto getData(String num) {
	 SimpleBoardDto dto=new SimpleBoardDto();
	 
	 Connection conn=db.getConnection();
	 PreparedStatement pstmt=null;
	 ResultSet rs=null;
	 
	 String sql="select * from simpleboard where num=?";
	 
	 try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, num);
		rs=pstmt.executeQuery();
		
		if(rs.next()) {
			
			dto.setNum(rs.getString("num"));
			dto.setWriter(rs.getString("writer"));
			dto.setPass(rs.getString("pass"));
			dto.setSubject(rs.getString("subject"));
			dto.setStory(rs.getString("story"));
			dto.setReadcount(rs.getInt("readcount"));
			dto.setWriteday(rs.getTimestamp("writeday"));
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 return dto;
 
 }
 //가장 최신에 추가한 글의 num값 얻기
  public int getMaxNum() {
	  int max=0;
	  
	  Connection conn=db.getConnection();
	  PreparedStatement pstmt=null;
	  ResultSet rs=null;
	  
	  String sql="select max(num) max from simpleboard"; //alias = max
	  
	  try {
		pstmt=conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		
		if(rs.next()) {
			max=rs.getInt("max"); //rs.getInt(1) num자리
			
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			  
	  return max;
  }
 
 

//insert
 public void insertBoard(SimpleBoardDto dto) {
	 
	 Connection conn=db.getConnection();
	 PreparedStatement pstmt=null;
	 
	 String sql="insert into simpleboard values(null,?,?,?,?,0,now())";
	 
	 
	 try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, dto.getWriter());
		pstmt.setString(2, dto.getPass());
		pstmt.setString(3, dto.getSubject());
		pstmt.setString(4, dto.getStory());

		pstmt.execute();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		db.dbClose(pstmt, conn);
	}
 }
 //조회수 1증가
 
 	public void updateReadCount(String num) {
 		
 		Connection conn=db.getConnection();
 		PreparedStatement pstmt=null;
 		
 		String sql="update simpleboard set readcount=readcount+1 where num=?";
 		
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
 	//비밀번호 확인
 	public boolean passCheck(String num, String pass) {
 		boolean flag=false;
 		
 		Connection conn=db.getConnection();
 		PreparedStatement pstmt=null;
 		ResultSet rs=null;
 		
 		String sql="select count(*) from simpleboard where num=? and pass=?"; // count는 맞으면 1 틀리면0
 		
 		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.setString(2, pass);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				
				//초기값이 false이므로 else는 굳이 안줘도 됨
				if(rs.getInt(1)==1) //비번이 틀릴 경우 0
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
 	//수정 ..writer, subject, story 다 되게
 	public void updateBoard(SimpleBoardDto dto) {
 		
 		Connection conn=db.getConnection();
 		PreparedStatement pstmt=null;
 		
 		String sql="update simpleboard set writer=?,subject=?,story=? where num=?";
 		
 		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getStory());
			pstmt.setString(4, dto.getNum());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
 	}
 	
 	//삭제
 	public void deleteBoard(String num) {
 		Connection conn=db.getConnection();
 		PreparedStatement pstmt=null;
 		
 		String sql="delete from simpleboard where num=?";
 		
 		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	}
 	//페이징처리_1.전체 갯수 반환
 	public int getTotalCount() {
 		int total=0;
 		
 		Connection conn=db.getConnection();
 		PreparedStatement pstmt=null;
 		ResultSet rs=null;
 		
 		String sql="select count(*) from simpleboard"; //갯수 조회
 		
 		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				total=rs.getInt(1);//select count(*) from simpleboard쿼리문 조회시 1번 열을 의미
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
 		return total;
 		
 	}
 	//부분 조회
 	public List<SimpleBoardDto> getPagingList(int startNum,int perpage){
 		List<SimpleBoardDto> list=new ArrayList<SimpleBoardDto>();
 		
 		Connection conn=db.getConnection();
 		PreparedStatement pstmt=null;
 		ResultSet rs=null;
 		
 		String sql="select * from simpleboard order by num desc limit ?,?";
 		
 		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, perpage);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				SimpleBoardDto dto=new SimpleBoardDto();
				dto.setNum(rs.getString("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setPass(rs.getString("pass"));
				dto.setSubject(rs.getString("subject"));
				dto.setStory(rs.getString("story"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				list.add(dto);
			}
		 }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
 		
 		return list;
 	}
 
}
 










