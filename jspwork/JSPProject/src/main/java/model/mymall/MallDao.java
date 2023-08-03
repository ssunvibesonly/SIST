package model.mymall;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import oracle.db.DBConnect_2;

public class MallDao {

		DBConnect_2 db=new DBConnect_2();
		
		//삽입
		public void insertMall(MallDto dto) {
			Connection conn=db.getConnection();
			PreparedStatement pstmt=null;
			
			String sql="insert into mymall values(seq_1.nextval,?,?,?,?,sysdate)";
			
			try {
				pstmt=conn.prepareStatement(sql);
				
				pstmt.setString(1, dto.getSang());
				pstmt.setString(2, dto.getPhoto());
				pstmt.setString(3, dto.getPrice());
				pstmt.setString(4, dto.getIpgo());
				
				pstmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.dbClose(pstmt, conn);
			}

		
	}
	//select
		public Vector<MallDto> getAllData(){
		Vector<MallDto> list=new Vector<MallDto>();
			
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			conn=db.getConnection();
			
			String sql="select * from mymall";
			
			try {
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();//ResultSet(java.sql.ResultSet)은 executeQuery(String sql)을 통해 쿼리 실행하면 ResultSet타입으로 반환을 해주어 결과값을 저장할 수 있다.
				
				while(rs.next()) {
					MallDto dto=new MallDto();
					dto.setNo(rs.getString("no"));
					dto.setSang(rs.getString("sangpum"));
					dto.setPhoto(rs.getString("photo"));
					dto.setPrice(rs.getString("price"));
					dto.setIpgo(rs.getString("ipgoday"));
					dto.setWriteday(rs.getTimestamp("writeday"));
					
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

