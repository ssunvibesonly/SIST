<%@page import="model.visitlist.visitListDAO"%>
<%@page import="model.visitlist.visitListDTO"%>
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
request.setCharacterEncoding("utf-8");

String nick=request.getParameter("nick");
String pass=request.getParameter("pass");
String image=request.getParameter("image");
String story=request.getParameter("story");

visitListDTO dto=new visitListDTO();

dto.setNick(nick);
dto.setPass(pass);
dto.setImage(image);
dto.setStory(story);

visitListDAO dao=new visitListDAO();
dao.insertVisit(dto);

response.sendRedirect("list.jsp");

%>

</body>
</html>