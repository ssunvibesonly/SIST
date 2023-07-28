package Quiz_0711;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class QuizMyStudent {

	DBConnect_2 db=new DBConnect_2();
	Scanner sc=new Scanner(System.in);
	
	public void insert() {
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		System.out.println("이름은?");
		String name=sc.nextLine();
		System.out.println("학년은?");
		int stu_grade=Integer.parseInt(sc.nextLine());
		System.out.println("핸드폰 번호는?");
		String hp=sc.nextLine();
		System.out.println("주소는?");
		String addr=sc.nextLine();
		System.out.println("나이는?");
		int age=Integer.parseInt(sc.nextLine());
		
		String sql="insert into mystudent values(seq_stu.nextval,?,?,?,?,?,sysdate)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//?바인더
			pstmt.setString(1, name);
			pstmt.setInt(2, stu_grade);
			pstmt.setString(3, hp);
			pstmt.setString(4, addr);
			pstmt.setInt(5, age);
			
			//업데이트
			int a=pstmt.executeUpdate();
			
			if(a==1)
				System.out.println("인서트 성공");
			else
				System.out.println("인서트 실패");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("insert error:"+e.getMessage());
		}finally {
			db.dbClose(pstmt, conn);
		}

	}
	//select
		public void select() {
				
			Connection conn=db.getConnection();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			String sql="select * from mystudent";
			
			try {
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				System.out.println("시퀀스\t이름\t학번\t핸드폰 번호\t주소\t나이\t날짜");
				System.out.println("------------------------------------------");
				
				while(rs.next()) {
					System.out.println(rs.getInt("stu_num")+"\t"+rs.getString("stu_name")+
							"\t"+rs.getInt("stu_grade")+"\t"+rs.getString("hp")+"\t"+
							rs.getString("addr")+"\t"+rs.getInt("age")+"\t"+rs.getDate("sdate"));
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("select error:"+e.getMessage());
			}finally {
				db.dbClose(rs, pstmt, conn);
			}

			}
	//delete
	public void delete() {
			Connection conn=db.getConnection();
			PreparedStatement pstmt=null;

			System.out.println("삭제할 시퀀스는?");
			int num=Integer.parseInt(sc.nextLine());
			
			String sql="delete from mystudent where stu_num=?";
			
			try {
				pstmt=conn.prepareStatement(sql);
				
				//?바인더
				pstmt.setInt(1, num);
				int a=pstmt.executeUpdate();
				
				if(a==1)
					System.out.println("삭제 성공");
				else
					System.out.println("삭제 실패");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("delete error: "+e.getMessage());
			}finally {
				db.dbClose(pstmt, conn);
			}
			
		}
		//수정할 시퀀스가 존재합니까?
	public boolean isData(String stu_num) {
		
		boolean flag=false;
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from mystudent where stu_num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, stu_num);
			rs=pstmt.executeQuery();
			
			if(rs.next())
				flag=true;
			else
				flag=false;
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		
		
		return flag;
		
		
	}
	//수정
	public void update() {
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		System.out.println("수정할 시퀀스번호?");
		String stu_num=sc.nextLine();
		
		if(!isData(stu_num)) {
			System.out.println("해당 번호는 존재하지 않습니다.");
			return;
		}
		
		System.out.println("수정할 이름?");
		String stu_name=sc.nextLine();
		System.out.println("수정할 학년?");
		int stu_grade=Integer.parseInt(sc.nextLine());
		System.out.println("수정할 핸드폰 번호?");
		String hp=sc.nextLine();
		System.out.println("수정할 주소?");
		String addr=sc.nextLine();
		System.out.println("수정할 나이?");
		int age=Integer.parseInt(sc.nextLine());
		
		String sql="update mystudent set stu_name=?,stu_grade=?,hp=?,addr=?,age=? where stu_num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, stu_name);
			pstmt.setInt(2, stu_grade);
			pstmt.setString(3, hp);
			pstmt.setString(4, addr);
			pstmt.setInt(5, age);
			pstmt.setString(6, stu_num);
			
			pstmt.execute();
			
			System.out.println("수정 성공!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("update error:"+e.getMessage());
		}finally {
			db.dbClose(pstmt, conn);
		}
		
		
	}
	//검색
	public void search() {
		System.out.println("검색할 학생명");
		String stu_name=sc.nextLine();
		
		String sql="select * from mystudent where stu_name like ?";
		
		System.out.println(sql);
		System.out.println("시퀀스\t학생명\t학년\t핸드폰번호\t주소\t나이\t날짜");
		System.out.println("---------------------------------------------");
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+stu_name+"%");
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				
				System.out.println(rs.getInt("stu_num")+"\t"+rs.getString("stu_name")+"\t"
						+rs.getInt("stu_grade")+"\t"+rs.getString("hp")+"\t"+rs.getString("addr")+"\t"
						+rs.getInt("age")+"\t"+rs.getDate("sdate"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		
		
		
	}
	
	public static void main(String[] args) {
		QuizMyStudent stu=new QuizMyStudent();
		Scanner sc=new Scanner(System.in);
		int a;
		
		while(true) {
			System.out.println("**학생 정보**");
			System.out.println("1.입력 2.출력 3.삭제 4.수정 5.검색 9.종료");
			System.out.println("--------------------------------------");
			a=Integer.parseInt(sc.nextLine());
			
			if(a==1)
				stu.insert();
			else if(a==2)
				stu.select();
			else if(a==3)
				stu.delete();
			else if(a==4)
				stu.update();
			else if(a==5)
				stu.search();
			else
				System.out.println("종료");
			break;
			
		}
		
		
		
		

	}

}
