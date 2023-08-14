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

 //세션이 있는지 확인 후 없으면 꽝
 String msg=(String)session.getAttribute("msg"); //오류가 나면 당황하지말고 왼쪽이랑 형을 같게 맞춰본다.
 String travel=request.getParameter("travel");
 
 if(msg==null || !msg.equals("happy")) //Null 조건이 늘 앞에 온다!
 {%>
	<h3 style="color:red;">시간초과로 꽝입니다.</h3>
 <%}else{
	 %>
	<h3>축<%=travel %>상품에 당첨됨!</h3>	 
 <%}
	 
%>

<a href="sessionForm.jsp">다시 선택</a>
</body>
</html>