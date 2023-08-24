<%@page import="data.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle:wght@300&family=Gamja+Flower&family=Nanum+Pen+Script&family=Noto+Serif+KR:wght@200&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
<div style="margin:100px 200px;">
	<img alt="" src="img/check.png" width="100" align="left" style="color:green;"><br><br><br>
	
	<%
	String myid=(String)session.getAttribute("myid");
	
	//db에 있는 이름 가져온다.
	MemberDao dao=new MemberDao();
	String name=dao.getName(myid);
	

	%>
	<br><br>
	<b><%=name %>님이 로그인 하셨습니다.</b><br><br>
	<button type="button" class="btn btn-danger" onclick="location.href='login/logoutaction.jsp'">로그아웃</button>
</div>
</body>
</html>