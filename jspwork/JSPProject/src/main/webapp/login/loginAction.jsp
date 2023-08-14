<%@page import="model.idx.idxDao"%>
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
String id=request.getParameter("id");
String pass=request.getParameter("pass");
String save=request.getParameter("savecheck");

//아이디와 비번이 맞는지 확인
idxDao db=new idxDao();
boolean flag=db.isLogin(id, pass);

//맞으면 세션 지정 후 로그인메인으로 간다(판단은 로그인 메인이 해준다.)
if(flag){
	//로그인 중인지 알 수 있는 세션 저장
	session.setAttribute("loginok", "yes");
	//아이디세션 저장
	session.setAttribute("idok", id);//request로 받은 id값
	//체크값 세션 저장...체크하면 값이 on,안하면 null로 넘어옴
	session.setAttribute("saveok", save);
	
	//세션 유지 시간
	session.setMaxInactiveInterval(60*60*8); //8시간동안 유지(생략시 30분)
	//로그인 메인으로 이동
	response.sendRedirect("loginMain.jsp");
}else{%>
	<script type="text/javascript">
	 alert("아이디와 비밀번호가 맞지 않습니다.")
	</script>
	
	
<% }


%>
</body>
</html>