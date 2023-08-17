package model.commute;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import model.memberSawon.memberAdminDto;
import oracle.db.DBConnect_2;

public class commuteDao {
DBConnect_2 db=new DBConnect_2();
//조회
	public Vector<commuteDto> getAllCommute(String id2){
		Vector<commuteDto> list=new Vector<commuteDto>();
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from commute where id2=? order by num2 desc";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id2);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				commuteDto dto=new commuteDto();
				
				dto.setNum2(rs.getString("num2"));
				dto.setWorkday(rs.getTimestamp("workday"));
				dto.setId2(rs.getString("id2"));
				dto.setPosition2(rs.getString("position2"));
				dto.setName2(rs.getString("name2"));
				dto.setDepartment2(rs.getString("department2"));
				dto.setGo(rs.getTimestamp("go"));
				dto.setBye(rs.getTimestamp("bye"));
				
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
	
	//인서트
	public void insertComm(commuteDto dto) {
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		String sql="insert into commute(num2,workday,id2,position2,name2,department2,go,worktime)values(dj.nextval,sysdate,?,?,?,?,sysdate,null)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getId2());
			pstmt.setString(2, dto.getPosition2());
			pstmt.setString(3, dto.getName2());
			pstmt.setString(4, dto.getDepartment2());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
		
	}
	//퇴근업데이트 DAO
	public void updateComm(String id2,int num2) {
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		String sql="update commute set bye=sysdate where num2=? and id2=?";
		
		try {
			pstmt=conn.prepareStatement(sql);

			pstmt.setInt(1, num2);
			pstmt.setString(2, id2);
			
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//최대값 조회
		public int getAllMax(String id2){
			
			int max=0;
			
			Connection conn=db.getConnection();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			String sql="select max(num2) from commute where id2=?";
			
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, id2);
				rs=pstmt.executeQuery();
				
				if(rs.next()) {
					max=rs.getInt("max(num2)");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.dbClose(rs, pstmt, conn);
			}

			return max;
		}
	
}
