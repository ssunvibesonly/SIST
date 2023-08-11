<%@page import="db.simpleguest.SimpleGuestDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

String num=request.getParameter("num");
String pass=request.getParameter("pass");

SimpleGuestDAO dao=new SimpleGuestDAO();

if(dao.isEqualPass(num, pass)){
	dao.deleteSimple(num);
	response.sendRedirect("guestList.jsp");
}else{
	%>
	<script>
	alert("비밀번호가 틀렸습니다.");
	history.back();
	
	</script>
	
<%}

%>

