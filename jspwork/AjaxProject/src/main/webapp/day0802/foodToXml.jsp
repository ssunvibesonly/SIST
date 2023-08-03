<?xml version="1.0" encoding="UTF-8"?>
<%@page import="java.sql.SQLException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="oracle_db.DBConnect_2"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<data>
<% 
		DBConnect_2 db=new DBConnect_2();
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null; //SQL문 전달자
		ResultSet rs=null;
		String sql="select * from myfood order by num";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //날짜 형식을 바꿔주는 것
		
		try{
			
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				
				String num=rs.getString("num");
				String fname=rs.getString("foodname");
				String fphoto=rs.getString("foodphoto");
				int price=rs.getInt("price");
				int cnt=rs.getInt("cnt");
				
				%><myfood num="<%=num %>">
					<fname><%=fname %></fname>
					<fphoto><%=fphoto %></fphoto>
					<price><%=price %></price>
					<cnt><%=cnt %></cnt>
				
				</myfood>
				
			<% }
		}catch(SQLException e){			
			e.printStackTrace();
			e.getMessage();
		}finally{
			db.dbClose(rs, pstmt, conn);
			
		}%>
		
</data>
