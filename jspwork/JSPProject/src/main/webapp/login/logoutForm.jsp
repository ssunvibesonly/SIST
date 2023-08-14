<%@page import="model.idx.idxDao"%>
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
//세션으로부터 idok 읽어오기
String id=(String)session.getAttribute("idok");

//아이디에 해당하는 이름을 dao로부터 얻는다.
idxDao db=new idxDao();
String name=db.getName(id);

%>

<br><br>
<b style="color:gray;"><%=name %>님</b>이 로그인중입니다.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" value="로그아웃" class="btn btn-outline-danger" onclick="location.href='logoutAction.jsp'">
<br><br>
<img alt="" src="../image/flower_ani/redhair1.PNG">
</body>
</html>