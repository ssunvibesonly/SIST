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
<%
//절대경로잡기 /실행 시 프로젝트명 나오면 되고, 필요한곳에 복붙해서 사용하면 됌

String root=request.getContextPath();
%>
<body>
<a href="<%=root %>" style="text-decoration:none; color:black;margin-left:200px;"><img alt="" src="<%=root%>/img/pororoheader2.png" style="width:200px;">
JSP & JQuery Mini Project</a>
</body>
</html>