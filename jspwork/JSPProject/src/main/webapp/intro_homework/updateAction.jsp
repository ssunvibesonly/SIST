<%@page import="model.intro.IntroDto"%>
<%@page import="model.intro.IntroDao"%>
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
	request.setCharacterEncoding("utf-8");

	String num=request.getParameter("num");
	String name=request.getParameter("name");
	String mbti=request.getParameter("mbti");
	String hp=request.getParameter("hp1")+""+request.getParameter("hp2")+"-"+request.getParameter("hp3");
	String city=request.getParameter("city");
	
	
	IntroDto dto=new IntroDto();
	
	dto.setNum(num);
	dto.setName(name);
	dto.setMbti(mbti);
	dto.setHp(hp);
	dto.setCity(city);
	
	IntroDao dao=new IntroDao();
	dao.updateAct(dto);
	
	response.sendRedirect("list_intro.jsp");

%>
<body>

</body>
</html>