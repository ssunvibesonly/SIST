package model.memberSawon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import com.mysql.cj.protocol.Resultset;

import oracle.db.DBConnect_2;

public class memberSawonDao {
	DBConnect_2 db=new DBConnect_2();
	//조회
	
	public Vector<memberSawonDto> getAllData(){
		Vector<memberSawonDto> list=new Vector<memberSawonDto>();
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		Resultset rs=null;
		
		String sql="select * from commute where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.exe
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}
