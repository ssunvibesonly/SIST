package day0710;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleConnectTest {

	static final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	
	public void connectSawon() {
		
		// select 할 때는 3개 다 읽어와야 하고 select아닐 땐 connection이랑 statement만 가져오면 된다.
		Connection conn=null; // 자바와 오라클 연결 커넥션
		Statement stmt=null; //CRUD 전체 sql문을 전달해준다.
		ResultSet rs=null; // select할 때 필요 -> 쿼리문을 읽어옴
		
		String sql="select * from sawon order by name asc";
		
		try {
			conn=DriverManager.getConnection(URL, "goyoung", "a1234"); //try catch 처리 해줘야한다.
			System.out.println("클라우드 오라클 서버 연결 성공!!!");
		
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {//true값 반환, 더이상 데이타 없으면 false
				
				//db로부터 데이타 가져오기
				int num=rs.getInt("num"); //컬럼명 or 열번호 
				String name=rs.getString("name");
				String gender=rs.getString("gender");
				String buseo=rs.getString("buseo");
				int pay=rs.getInt("pay");
				
				System.out.println(num+"\t"+name+"\t"+gender+"\t"+buseo+"\t"+pay);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("오라클 서버 연결 실패!!!"+e.getMessage());
		}finally {
			try {
				if(rs!=null)rs.close(); //사용중인거 닫아라~~
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void connectBaemin() {
		//주문번호 주문자 음식명 가격 상호명 가게위치 주문자주소
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;;
		
		String sql="select f.fno, j.name, f.foodname, f.price, f.shopname,"
				+ "f.loc,j.addr from food f,jumun j where f.fno=j.fno order by j.name asc";
		//sql에 한글 allias는 뺀다.
		
		try {
			conn=DriverManager.getConnection(URL,"goyoung","a1234"); //try~catch 문 생성하기 위해 먼저 선언해줘야함
			System.out.println("클라우드 오라클 서버 연결 성공쓰");
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("***배민 주문 고객 리스트***");
			System.out.println("주문번호\t주문자명\t음식명\t가격\t상호명\t가게위치\t주문자위치");
			
			while(rs.next()) {
				
				int fno=rs.getInt("fno"); //컬럼명 or 열번호가 와야되므로 조인 쓰는거 아님!! 실질적 컬럼명
				String name=rs.getString("name");
				String foodname=rs.getString("foodname");
				int pri=rs.getInt("price");
				String sh=rs.getString("shopname");
				String loc=rs.getString("loc");
				String add=rs.getString("addr");
				
				System.out.println(fno+"\t"+name+"\t"+foodname+"\t"+pri+"\t"+sh+"\t"
						+loc+"\t"+add);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("오라클 연결 실패......"+e.getMessage());
		} finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void connectSawonGroup() {
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="select gender, count(*) cnt,to_char(avg(pay),'L999,999,999')avgpay from sawon group by gender";

		try {
			conn=DriverManager.getConnection(URL, "goyoung", "a1234");
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("***성별 인원 및 평균 급여***");
			System.out.println("성별\t인원수\t평균급여");
			System.out.println("----------------------------");
			
			while(rs.next()) {
				
				String gender=rs.getString("gender");
				int cnt=rs.getInt("cnt");
				String avgpay=rs.getString("avgpay");
				
				System.out.println(gender+"\t"+cnt+"\t"+avgpay);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		OracleConnectTest oc=new OracleConnectTest();
		//oc.connectSawon();
		//oc.connectBaemin();
		oc.connectSawonGroup();
		}

}