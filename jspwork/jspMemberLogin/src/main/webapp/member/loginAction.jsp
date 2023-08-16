<%@page import="member.model.MemberDAO"%>
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
	String id=request.getParameter("id");
	String pass=request.getParameter("pass");
	String save=request.getParameter("savecheck");
	
	MemberDAO db=new MemberDAO();
	boolean flag=db.isEqulaIdPass(id, pass);
	
	if(flag){
		session.setAttribute("loginok", "yes"); //로그인중인지 세션 저장
		session.setAttribute("idok", id); //id 저장
		session.setAttribute("saveok", save); //체크박스 저장 (체크하면 값이 on 안하면 null)
		
		session.setMaxInactiveInterval(60*60*10);
		
		response.sendRedirect("loginMain.jsp");
		
	}else{%>
		<script>
		alert("ID와 PW가 일치하지 않습니다.");
		history.back();
		</script>
		
	<%}
	
%>
<body>

</body>
</html>