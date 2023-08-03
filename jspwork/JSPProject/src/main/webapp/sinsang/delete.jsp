<%@page import="model.sinsang.SinSangDao"%>
<%@page import="model.sinsang.SinSangDto"%>
<%@page import="org.apache.catalina.connector.Response"%>
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
	//삭제 메서드 호출
	String num=request.getParameter("num"); //form에 안써도 받는건 받아올 수 있다.
	SinSangDao dao=new SinSangDao();//삭제해야하기 위해 필요한 메서드가 SinSangDao 클래스 안에 있기 때문에 먼저 dao를 생성
	dao.deleteSinsang(num);
	
	//리스트로 이동
	response.sendRedirect("list.jsp");
%>
</body>
</html>