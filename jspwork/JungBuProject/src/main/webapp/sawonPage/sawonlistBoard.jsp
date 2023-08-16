<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.memberSawon.memberAdminDto"%>
<%@page import="model.memberSawon.memberAdminDao"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
memberAdminDao dao=new memberAdminDao();
Vector<memberAdminDto>list=dao.getAllCommute();
SimpleDateFormat sdftime=new SimpleDateFormat("h:mm a");
SimpleDateFormat sdfday=new SimpleDateFormat("yyyy-MM-dd");
JSONArray arr=new JSONArray();

for(memberAdminDto dto:list){
	JSONObject ob=new JSONObject();
	
	ob.put("num2",dto.getNum2());
	ob.put("workday",sdfday.format(dto.getWorkday()));
	ob.put("id2",dto.getId2());
	ob.put("position2",dto.getPosition2());
	ob.put("department2",dto.getDepartment2());
	ob.put("go",sdftime.format(dto.getGo()));
	ob.put("bye",sdftime.format(dto.getBye()));
	ob.put("worktime",dto.getWorktime());
	
	arr.add(ob);
}


%>

<%=arr.toString()%>