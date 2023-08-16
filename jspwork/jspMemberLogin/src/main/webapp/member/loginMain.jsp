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
<%
	String loginok=(String)session.getAttribute("loginok");

	if(loginok==null || loginok.equals("")){ //로그인이냐 로그아웃이냐를 나누기위해 페이지만 가져오는 것이므로 jsp:include%>
		
		<jsp:include page="loginForm.jsp"/> 
	<% }else{%>
		
		<jsp:include page="memberList.jsp"/>
	<% }
%>
</body>
</html>