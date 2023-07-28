package JDBC_sawon;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SawonCRUD {

	DBConnect_2 db=new DBConnect_2();
	Scanner sc=new Scanner(System.in);
	
	public void addSawon() {
		
		System.out.println("***사원 추가하기***");
		System.out.println("사원명?");
		String name=sc.nextLine();
		System.out.println("부서명?");
		String buseo=sc.nextLine();
		System.out.println("성별(여자or남자?)?");
		String gender=sc.nextLine();
		System.out.println("급여?");
		int pay=Integer.parseInt(sc.nextLine());
		
		String sql="insert into sawon values(seq_sawon.nextval,'"+name+"','"+gender+"','"+buseo+"',"
				+pay+")";
		
		System.out.println(sql);
		
		//오라클에 연결
		
		Connection conn=db.getConnection();
		Statement stmt=null; //완성형의 sql문을 전달하는 api
		
		try {
			stmt=conn.createStatement();
			stmt.execute(sql); //sql문 실행
			
			System.out.println("DB 추가 되었습니다.");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}
		
		
	}
	public void writeSawon() {
		String sql="select num,name,gender,buseo,to_char(pay,'L999,999,999')pay from sawon";
		
		System.out.println("\t\t[전체 사원 명단]");
		System.out.println();
		
		System.out.println("시퀀스\t사원명\t성별\t부서명\t월급여");
		System.out.println("-------------------------------------");
		
		//db연결
		Connection conn=db.getConnection();
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				System.out.println(rs.getInt("num")+"\t"+rs.getString("name")+"\t"+
				rs.getString("gender")+"\t"+rs.getString("buseo")+"\t"+rs.getString("pay"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, stmt, conn);
		}
	}
	//사원명을 입력하면 삭제
	public void deleteSawon() {
		
		Connection conn=db.getConnection();
		Statement stmt=null;
		
		System.out.println("삭제할 사원명은?");
		String name=sc.nextLine();
		
		String sql="delete from sawon where name='"+name+"'";
		
		try {
			stmt=conn.createStatement();
			stmt.execute(sql);
			
			System.out.println("삭제됨");
	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}
		
		
	}
	//수정..시퀀스 입력 후 부서, 급여만 수정...
	public void updateSawon() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("수정할 사원 번호?");
		int num=Integer.parseInt(sc.nextLine());
		
		System.out.println("수정할 부서명은?");
		String buseo=sc.nextLine();
		
		System.out.println("급여는?");
		int pay=Integer.parseInt(sc.nextLine());
				
		String sql="update sawon set buseo='"+buseo+"',"+"pay="+pay+"where num="+num;
		System.out.println(sql);
		
		Connection conn=db.getConnection();
		Statement stmt=null;
				
				try {
					stmt=conn.createStatement();
					stmt.execute(sql);
					
					System.out.println(num+"사원번호 수정됨");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					db.dbClose(stmt, conn);
				}

	}
	public void searchSawon() {
		
		System.out.println("검색할 사원명을 입력해주세요(일부검색 가능)");
		Scanner sc=new Scanner(System.in);
		String name=sc.nextLine();
		String sql="select num,name,gender,buseo,to_char(pay,'L999,999,999')pay from sawon "
				+ "where name like '%"+name+"%'";
		
		System.out.println("**검색사원 명단**");
		System.out.println();
		
		System.out.println("시퀀스\t사원명\t성별\t부서명\t월급여");
		System.out.println("-------------------------------------");
		
		Connection conn=db.getConnection();
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getInt("num")+rs.getString("name")+rs.getString("gender")+
						rs.getString("buseo")+rs.getString("pay"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, stmt, conn);
		}
		
	}
	
	public static void main(String[] args) {
		//클래스 생성
		SawonCRUD sawon=new SawonCRUD();
		int num;
		//Scanner 생성
		Scanner sc=new Scanner(System.in);
		//while
		
		while(true) {
			
			System.out.println("Orale DB_Sawon 문제");
			System.out.println("1.insert 2.select 3.update 4.delete 5.사원검색 6.종료");
			
			num=Integer.parseInt(sc.nextLine());
			
			if(num==1) {
				sawon.addSawon();
			}else if(num==2) {
				sawon.writeSawon();}
			else if(num==3) {
				sawon.updateSawon();
			}
			else if(num==4) {
				sawon.deleteSawon();
			}
			else if(num==5) {
				sawon.searchSawon();
			}
			else if(num==9) {
				System.out.println("종료합니다.");
				break;
			}
				
			
		}

	}

}
