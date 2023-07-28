package day0710;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QuizConnectNewBoard {
		
	static final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	
		public void connectSubject() {
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="select * from snsboard";
		
		try {
			conn=DriverManager.getConnection(URL, "goyoung", "a1234");
			System.out.println("클라우드 오라클 서버 연결이 성공했어요!");
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int num=rs.getInt("b_num");
				String nick=rs.getString("nick");
				String sub=rs.getString("subject");
				String con=rs.getString("content");
				String day=rs.getString("wday");
				
				System.out.println(num+"\t"+nick+"\t"+sub+"\t"+con+"\t"+day);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("오라클 연결 실패 ㅠㅠ"+e.getMessage());
		}try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	public static void main(String[] args) {
		QuizConnectNewBoard oc=new QuizConnectNewBoard();
		oc.connectSubject();
	}

}