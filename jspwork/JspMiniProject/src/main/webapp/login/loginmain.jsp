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
//loginok는 로그인 성공 시 저장하고, 로그아웃 시 제거
String loginok=(String)session.getAttribute("loginok");

if(loginok==null){%>
	<jsp:include page="loginform.jsp"/>
	
<%}else{%>
	<jsp:include page="logoutform.jsp"/>
<%}

%>
</body>
</html>