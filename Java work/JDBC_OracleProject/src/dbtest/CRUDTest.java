package dbtest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

public class CRUDTest {

	DBConnect db=new DBConnect();
	
	//insert
	public void insert() {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("이름입력");
		String name=sc.nextLine();
		System.out.println("주소입력");
		String addr=sc.nextLine();
		
		String sql="insert into myinfo values(seq1.nextval,'"+name+"','"+addr+"',sysdate)"; //완성된 구문
		
		//1. db 연결
		Connection conn=db.getConnection();
		
		//2. statement 
		Statement stmt=null;
		try {
			stmt=conn.createStatement();
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("insert error: "+e.getMessage());
		}finally {
			db.dbClose(stmt, conn);
		}
		
		System.out.println("***정보가 추가 되었습니다.***");
	} 
	
	//select
	public void select() {
		Connection conn=db.getConnection();
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="select * from myinfo";
		
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			//2개 이상일 경우 while문
			//resultest객체의 next이용해서 행을 선택하고 get메서드를 이용해서 테이블의 컬럼값을 얻는다.
			while(rs.next()) { 
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String add=rs.getString("addr");
				Date sdate=rs.getDate("sdate");
				System.out.println(num+"\t"+name+"\t"+add+"\t"+sdate);
				
				
			}
		} catch (SQLException e) {
			System.out.println("select error: "+e.getMessage());
			e.printStackTrace();
		}finally {
			db.dbClose(rs, stmt, conn);		
	}
	}
	
	//delete
			public void delete() {
				
				//시퀀스 입력 후 삭제
				Scanner sc=new Scanner(System.in);
				String num;
				
				System.out.println("삭제할 시퀀스는?");
				num=sc.nextLine();
				
				String sql="delete from myinfo where num="+num;
				
				//db연결
				Connection conn=db.getConnection();
				//statement
				Statement stmt=null;
				try {
					stmt=conn.createStatement();
					
					//sql문 실행
					int a=stmt.executeUpdate(sql); //성공한 갯수
					
					if(a==0) //없는 번호 입력 시 실제 삭제가 되지 않으므로 0이 반환
						System.out.println("없는 데이터 번호입니다.");
					else //삭제되면 1 반환
						System.out.println("**삭제 되었습니다.**");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					db.dbClose(stmt, conn);
				}
		
				
			}
	//update
	public void update(){
		
		//수정할 시퀀스 입력 후 이름, 주소 입력
		Scanner sc=new Scanner(System.in);
		String num;
		System.out.println("수정할 시퀀스는?");
		num=sc.nextLine();
		
		//위의 boolean메서드 가져와서 실행
		if(!this.isData(num)) {
			System.out.println("해당 번호는 존재하지 않습니다.");
			return; //메서드 종료
		}
		
		System.out.println("수정할 이름은?");
		String name=sc.nextLine();
		
		System.out.println("수정할 주소는?");
		String add=sc.nextLine();
		
		//sql
		String sql="update myinfo set name='"+name+"',addr='"+add+"' where num="+num;
		
		System.out.println(sql);
		
		//db연결 
		Connection conn=db.getConnection();
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			stmt=conn.createStatement();
			int a=stmt.executeUpdate(sql);
			
			if(a==0)
				System.out.println("수정할 데이터가 없습니다.");
			else
				System.out.println("수정되었습니다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("update error: "+e.getMessage());
		}finally {
			db.dbClose(stmt, conn);
		}
		
	}
	//update할 때 없는 번호인지 있는 번호인지 찾아주기
	public boolean isData(String num) { 
		
		//num에 해당하는 데이터가 있으면 true 없으면 false
		boolean flag=false;
		
		String sql="select * from myinfo where num="+num;
		
		Connection conn=db.getConnection();
		Statement stmt=null;
		ResultSet rs=null; //rs가 있을 땐 rs로 업데이트
		
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			//1개일 경우는 if문(<-> 여러개 while)
			if(rs.next()) //데이터가 있는 경우
				flag=true;
			else //데이터가 없는 경우
				flag=false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, stmt, conn);
		}
		
		
		
		return flag;
	}
	
	public static void main(String[] args) {
		CRUDTest crud=new CRUDTest();
		
		Scanner sc=new Scanner(System.in);
		int n;
		
		while(true) {
			
			System.out.println("***Oracle db 연습_myinfo***");
			System.out.println("1. insert 2. select 3. delete 4.update 9. 종료");
			
			n=Integer.parseInt(sc.nextLine());
			
			if(n==1) {
				crud.insert();
			}
			else if(n==2) {
				crud.select();
			}
			else if(n==3) {
				crud.delete();
			}
			else if(n==4) {
				crud.update();
			}
			else if(n==9) {
				System.out.println("종료!");
				break;
			}
			else {
				System.out.println("숫자를 잘못 입력하였습니다.");
				break;}
			
			
		}

	}

}
