<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<%
	String id = (String)session.getAttribute("id");
	
	if(id.equals("admin")){
		
		session.removeAttribute("adminLogin");
		response.sendRedirect("loginForm.jsp");
	}else{
		
		session.removeAttribute("sawonLogin");
		response.sendRedirect("loginForm.jsp");
	}
	
%>
</body>
</html>