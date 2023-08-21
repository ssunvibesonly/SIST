<%@page import="db.simpleboard.SimpleBoardDao"%>
<%@page import="db.simpleboard.SimpleBoardDto"%>
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

String num=request.getParameter("num");
String writer=request.getParameter("writer");
String story=request.getParameter("story");
String subject=request.getParameter("subject");

SimpleBoardDto dto=new SimpleBoardDto();
SimpleBoardDao dao=new SimpleBoardDao();

dto.setNum(num);
dto.setWriter(writer);
dto.setStory(story);
dto.setSubject(subject);

dao.updateBoard(dto);

response.sendRedirect("detailview.jsp?num="+num);



%>
</body>
</html>