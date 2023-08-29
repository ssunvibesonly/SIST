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
%>

<jsp:useBean id="dto" class="data.dto.SmartDto"/>
<jsp:useBean id="dao" class="data.dao.SmartDao"/>
<jsp:setProperty property="*" name="dto"/>
<%

//db에 insert
dao.insertSmart(dto);

/* //목록으로 이동
response.sendRedirect("../index.jsp?main=board/boardlist.jsp"); */

//디테일페이지로 이동
int num=dao.getMaxNum();
response.sendRedirect("../index.jsp?main=board/contentView.jsp?num="+num);
%>
</body>
</html>