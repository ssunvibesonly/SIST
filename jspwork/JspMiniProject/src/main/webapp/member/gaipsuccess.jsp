<%@page import="data.dto.MemberDto"%>
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
<%
String id=request.getParameter("id");

MemberDao dao=new MemberDao();
String name=dao.getName(id);

%>
<body>

<div style="margin-left:280px;">
<b style="font-weight: bold;font-size:15pt;"><%=name %>님</b> 회원가입이 완료되었습니다.<br>
<img src="img/rupy4.png" style="width:200px;"><br><br>
<div style="margin-left:40
px;">
<button type="button" onclick="location.href='index.jsp'"class="btn btn-outline-success">main</button>
<button type="button" onclick="location.href='index.jsp?main=login/loginform.jsp'"class="btn btn-success">로그인</button></div>
</div>
</body>
</html>