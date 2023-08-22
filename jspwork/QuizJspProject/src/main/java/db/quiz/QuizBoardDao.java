package db.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mysql.db.DBConnect_2;

public class QuizBoardDao {
	DBConnect_2 db=new DBConnect_2();
	
	//insert
	public void insertQuiz(QuizBoardDto dto) {
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		String sql="insert into quizboard values(null,?,?,?,?,0,now())";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getImgname());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			db.dbClose(pstmt, conn);
		}
	
		
	}
	//조회
	public List<QuizBoardDto> getPagingList(int startNum,int perblock){
		List<QuizBoardDto> list=new ArrayList<QuizBoardDto>();
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from quizboard order by q_num desc limit ?,?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, perblock);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				QuizBoardDto dto=new QuizBoardDto();
				dto.setQ_num(rs.getString("q_num"));
				dto.setWriter(rs.getString("writer"));
				dto.setTitle(rs.getString("title"));
				dto.setImgname(rs.getString("imgname"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				list.add(dto);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			db.dbClose(rs, pstmt, conn);
		}
		
		
		
		return list;
		
	}
	
	//전체 갯수 반환
		public int getTotalList(){
			int cnt=0;
			
			Connection conn=db.getConnection();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			String sql="select count(*) from quizboard";
			
			try {
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				if(rs.next()) {
					
					cnt=rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			return cnt;
		}
		
		//조회수 1증가
		public void updateCnt(String num) {
			
			Connection conn=db.getConnection();
			PreparedStatement pstmt=null;
			
			String sql="update quizboard set readcount=readcount+1 where q_num=? ";
			
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, num);
				pstmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		//전체 조회
		public List<QuizBoardDto> getAllData(){
			List<QuizBoardDto> list=new ArrayList<QuizBoardDto>();
			
			Connection conn=db.getConnection();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			String sql="select * from quizboard order by q_num desc";
			
			try {
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
					QuizBoardDto dto=new QuizBoardDto();
					dto.setQ_num(rs.getString("q_num"));
					dto.setWriter(rs.getString("writer"));
					dto.setTitle(rs.getString("title"));
					dto.setContent(rs.getString("content"));
					dto.setImgname(rs.getString("imgname"));
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
}
