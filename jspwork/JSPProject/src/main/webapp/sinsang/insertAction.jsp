<%@page import="model.sinsang.SinSangDao"%>
<%@page import="model.sinsang.SinSangDto"%>
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
	String name=request.getParameter("name"); //form의 name
	String addr=request.getParameter("addr");
	
	//입력데이터를 DTO로 묶어서
	SinSangDto dto=new SinSangDto();
	
	dto.setName(name);
	dto.setAddr(addr);
	
	//insert 메서드 전달
	SinSangDao dao=new SinSangDao();
	dao.insertSinsang(dto);
	
	//출력 jsp 이동..url이 바뀜 => 처리 페이지에서 반드시 이동해줘야함
	response.sendRedirect("list.jsp");	
	
%>
</body>
</html>