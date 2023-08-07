package model.intro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import oracle.db.DBConnect_2;

public class IntroDao {
	DBConnect_2 db=new DBConnect_2();
	
	//삽입
	public void insertAct(IntroDto dto){
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		String sql="insert into intro values(seq_1.nextval,?,?,?,?,sysdate)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getMbti());
			pstmt.setString(3, dto.getHp());
			pstmt.setString(4, dto.getCity());
			
			pstmt.executeUpdate();			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			db.dbClose(pstmt, conn);
		}
		
	}
	//조회
	
	public Vector<IntroDto> getAllData(){
		Vector<IntroDto> list=new Vector<IntroDto>();
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from intro order by intro_num";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				IntroDto dto=new IntroDto();
				
				dto.setNum(rs.getString("intro_num"));
				dto.setName(rs.getString("intro_name"));
				dto.setMbti(rs.getNString("intro_mbti"));
				dto.setHp(rs.getString("intro_hp"));
				dto.setCity(rs.getString("intro_city"));
				dto.setGaip(rs.getTimestamp("gaipday"));
				
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
	//삭제
	public void deleteAct(String num) {
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		String sql="delete from intro where intro_num=?";
		
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
	//수정
	public IntroDto getData(String num){ //하나의 데이터 조회
		
		IntroDto dto=new IntroDto();
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from intro where intro_num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num); //바인딩 먼저
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				
				dto.setNum(rs.getString("intro_num"));
				dto.setName(rs.getString("intro_name"));
				dto.setMbti(rs.getString("intro_mbti"));
				dto.setHp(rs.getString("intro_hp"));
				dto.setCity(rs.getString("intro_city"));
				
				pstmt.execute();
			}
			
					
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
		
	}
	//수정..추가 등
	public void updateAct(IntroDto dto) {
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		String sql="update intro set intro_name=?,intro_mbti=?,intro_hp=?,intro_city=? where intro_num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getMbti());
			pstmt.setString(3, dto.getHp());
			pstmt.setString(4, dto.getCity());
			pstmt.setString(5, dto.getNum());
			
			
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			db.dbClose(pstmt, conn);
		}
		
		
		
	}
	
	//디테일페이지
			public IntroDto detailPage(String num) {
				
				IntroDto dto=new IntroDto();
				
				Connection conn=db.getConnection();
				PreparedStatement pstmt=null;
				ResultSet rs=null;
				
				String sql="select * from intro where intro_num=?";
				
				try {
					pstmt=conn.prepareStatement(sql);
					pstmt.setString(1, num);
					rs=pstmt.executeQuery();
					
					if(rs.next()) {
						dto.setNum(rs.getString("intro_num"));
						dto.setName(rs.getString("intro_name"));
						dto.setMbti(rs.getString("intro_mbti"));
						dto.setHp(rs.getString("intro_hp"));
						dto.setCity(rs.getString("intro_city"));
						dto.setGaip(rs.getTimestamp("gaipday"));
						
						
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				return dto;
			}
				
}
