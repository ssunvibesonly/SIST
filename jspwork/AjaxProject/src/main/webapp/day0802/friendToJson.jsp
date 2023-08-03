<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="oracle_db.DBConnect_2"%>
<%
	DBConnect_2 db=new DBConnect_2();
	Connection conn=db.getConnection();
	Statement stmt=null;
	ResultSet rs=null;
	
	String sql="select * from friend order by num";
	
	try{
		stmt=conn.createStatement();
		rs=stmt.executeQuery(sql);
		
		JSONArray arr=new JSONArray();
		
		while(rs.next()){
			String num=rs.getString("num");
			String fname=rs.getString("fname");
			String fhp=rs.getString("fhp");
			String faddr=rs.getString("faddr");
			String gaipday=rs.getString("gaipday");
			
			JSONObject ob=new JSONObject();
			
			ob.put("num",num);
			ob.put("fname",fname);
			ob.put("fhp",fhp);
			ob.put("faddr",faddr);
			ob.put("gaipday",gaipday);
			
			//arr에 ob추가
			arr.add(ob);
			
		}%>
			<%=arr.toString() %>
	<%}catch(SQLException e){
		
	}finally{
			
		
	}
	
	

%>