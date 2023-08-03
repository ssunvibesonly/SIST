package model.myteam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.db.DBConnect_2;

public class TeamDao {
	DBConnect_2 db=new DBConnect_2();
	
	//insert
	public void insertMyTeam(TeamDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="insert into myteam values(seq_1.nextval,?,?,?,sysdate)";
		
		conn=db.getConnection();
		
		try {
			
			pstmt=conn.prepareStatement(sql);
			
			//?바인딩
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getDriver());
			pstmt.setString(3, dto.getAddr());
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			db.dbClose(pstmt, conn);
		}
		
	}
	
	//select
	public ArrayList<TeamDto> getAllMyTeams(){ //Vector랑 같다.
		{
			ArrayList<TeamDto> list=new ArrayList<TeamDto>();
			
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null; //출력할 것이 있을 때 Resultset
			
			conn=db.getConnection();
			
			String sql="select * from myteam order by num";
			
			try {
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery(); //pstmt의 Query문을 실행하여 rs에 담는다.
				
				while(rs.next()) {
					TeamDto dto=new TeamDto();
					//DB에서 받아온 값들은 dto의 값으로 설정
					dto.setNum(rs.getString("num"));
					dto.setName(rs.getString("tname"));
					dto.setDriver(rs.getString("driver"));
					dto.setAddr(rs.getString("taddr"));
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

	//삭제
	public void deleteMyTeam(String num) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		conn=db.getConnection();
		
		String sql="delete from myteam where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, num);//내가 받아온 파라미터 값을 넣어주는 것이므로 쌍따옴표 안붙임
			
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}

	}

	public TeamDto getData(String num)
	{
		TeamDto dto=new TeamDto();
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from myteam where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				dto.setNum(rs.getString("num"));
				dto.setName(rs.getString("tname"));
				dto.setDriver(rs.getString("driver"));
				dto.setAddr(rs.getString("taddr"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			db.dbClose(rs, pstmt, conn);
		}
		
		return dto;
	}
	
	//수정
	public void updateMyTeam(TeamDto dto) { //값이 어떤게 변할지 모르니까 TeamDto dto로 가져온다.
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		String sql="update myteam set tname=?,driver=?,taddr=? where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getDriver());
			pstmt.setString(3, dto.getAddr());
			pstmt.setString(4, dto.getNum());
			
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
