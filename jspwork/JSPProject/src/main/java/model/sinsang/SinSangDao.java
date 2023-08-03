package model.sinsang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.naming.spi.DirStateFactory.Result;

import oracle.db.DBConnect_2;

public class SinSangDao {
	DBConnect_2 db=new DBConnect_2();
	
	
	//insert
	public void insertSinsang(SinSangDto dto){
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="insert into sinsang values(seq_1.nextval,?,?,sysdate)";
		
		conn=db.getConnection(); // db연결
		
		try {
			
			pstmt=conn.prepareStatement(sql); 
			
			//?에 바인딩(연결의느낌) 하는 과정 => SQL문이 완성된 상태로 저장된다.
			pstmt.setString(1, dto.getName()); //1: 첫번째 물음표
			pstmt.setString(2, dto.getAddr());
			
			//query 실행
			pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally { //DB연결을 끊어주는 메서드라 써주는 편이 좋다.
			db.dbClose(pstmt, conn);
		}
		
	}
	
	//select
	public Vector<SinSangDto> getAllDatas() //vector는 무한대로 배열이 늘어날 수 있다.
	{
		Vector<SinSangDto> list=new Vector<SinSangDto>();
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select*from sinsang order by num";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			//여러개의 데이터를 얻을 경우
			while(rs.next()) {
				//dto 선언.. 반드시 while 안에사
				SinSangDto dto=new SinSangDto();
				
				dto.setNum(rs.getString("num"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				dto.setSdate(rs.getTimestamp("sdate"));
				
				//벡터에 추가
				list.add(dto);
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return list;
	}



//삭제
	public void deleteSinsang(String num)//num = 시퀀스
	{
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		String sql="delete from sinsang where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeQuery();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		
		
	}
	
	//하나의 데이터 조회
	public SinSangDto getData(String num) { //하나의 데이터 조회니까 꾸러미만 없애서 Vector가 빠진 SinsangDto를 반환한다.
		
		SinSangDto dto=new SinSangDto();
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from sinsang where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs=pstmt.executeQuery();
			
			//하나의 데이터 조회시 if
			if(rs.next())
			{
				dto.setNum(rs.getString("num"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				dto.setSdate(rs.getTimestamp("sdate"));
				
			}
		}catch(SQLException e){
			
		}finally {
			
			
		}
		

	return dto;
	}
	
	//수정..이름 주소 수정
	public void updateSinsang(SinSangDto dto)
	{
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
			
		String sql="update sinsang set name=?,addr=? where num=? ";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//? 바인딩
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.setString(3, dto.getNum());
			
			pstmt.execute();
			
		}catch(SQLException e){
			
			
		}finally {
			db.dbClose(pstmt, conn);;
		}
		
	}
	}
	

	
