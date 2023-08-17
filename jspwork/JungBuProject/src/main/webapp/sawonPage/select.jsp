<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.commute.commuteDao"%>
<%@page import="model.memberSawon.memberAdminDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="model.commute.commuteDto"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.util.Vector"%>

<%
String id = request.getParameter("id");
SimpleDateFormat sdfday=new SimpleDateFormat("yyyy-MM-dd");
SimpleDateFormat sdftime=new SimpleDateFormat("h:mm a");

commuteDao daocomm=new commuteDao();
Vector<commuteDto> list=daocomm.getAllCommute(id);

JSONArray arr=new JSONArray();

for(commuteDto jsondto:list){
	JSONObject ob=new JSONObject();
	
	ob.put("num2",jsondto.getNum2());
	ob.put("workday",sdfday.format(jsondto.getWorkday()));
	ob.put("id2",jsondto.getId2());
	ob.put("position2",jsondto.getPosition2());
	ob.put("name2",jsondto.getName2());
	ob.put("department2",jsondto.getDepartment2());
	ob.put("go", sdftime.format(jsondto.getGo()));
	ob.put("bye",jsondto.getBye()==null?"":sdftime.format(jsondto.getBye()));
	ob.put("worktime",jsondto.getWorktime());
	
	arr.add(ob);
	
} %>

<%=arr.toString()%>