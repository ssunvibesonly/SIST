<%@page import="model.visitlist.visitListDTO"%>
<%@page import="model.visitlist.visitListDAO"%>
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
String nick=request.getParameter("nick");
String image=request.getParameter("image");
String story=request.getParameter("story");
String pass=request.getParameter("pass");


visitListDAO dao=new visitListDAO();
visitListDTO dto=new visitListDTO();
if(dao.isEqual(num, pass)){
	
	dto.setNick(nick);
	dto.setPass(pass);
	dto.setImage(image);
	dto.setStory(story);
	dto.setNum(num);
	dao.updateVisit(dto);
	
	
	
	response.sendRedirect("list.jsp");
}else{ %>
	<script>
	alert("비밀번호가 틀렸습니다.")
	history.back();
	
	</script>
	
 <%}


%>
</body>
</html>