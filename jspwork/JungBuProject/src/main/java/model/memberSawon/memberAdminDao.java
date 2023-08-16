package model.memberSawon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;



import oracle.db.DBConnect_2;

public class memberAdminDao {
	DBConnect_2 db=new DBConnect_2();
	
	//조회
	public Vector<memberAdminDto> getAllCommute(){
		Vector<memberAdminDto> list=new Vector<memberAdminDto>();
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from commute";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery(sql);
			
			while(rs.next()) {
				memberAdminDto dto=new memberAdminDto();
				
				dto.setNum2(rs.getString("num2"));
				dto.setWorkday(rs.getTimestamp("workday"));
				dto.setId2(rs.getString("id2"));
				dto.setPosition2(rs.getString("position2"));
				dto.setDepartment2(rs.getString("department2"));
				dto.setGo(rs.getTimestamp("go"));
				dto.setBye(rs.getTimestamp("bye"));
				dto.setWorktime(rs.getString("worktime"));
				
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
	
}
