<%@page import="data.dao.ShopDao"%>
<%@page import="data.dao.MemberDao"%>
<%@page import="data.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle:wght@300&family=Gamja+Flower&family=Nanum+Pen+Script&family=Noto+Serif+KR:wght@200&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
<style>
.loginout{
font-size:10pt;
margin-left:40px;

}

div.cart{
float: right;
cursor: pointer;

}
div.count{

width:30px;
height:30px;
float: right;
background-color: red;
border-radius: 100%;
text-align: center;
line-height:30px;
z-index: 10;
position: relative;
left: -20px;
top: 20px;
opacity: 80%;
color: white;
font-weight: bold;


}
</style>
<script>
$(function(){
	
	$("div.cart").click(function(){
	
		location.href="index.jsp?main=shop/mycart.jsp";
		
	});
	
});

</script>
</head>
<%
//절대경로잡기 /실행 시 프로젝트명 나오면 되고, 필요한곳에 복붙해서 사용하면 됌

String root=request.getContextPath();
//아이디얻기
String myid=(String)session.getAttribute("myid");
//로그인 세션
String loginok=(String)session.getAttribute("loginok");

//dao에서 이름 받기
MemberDao dao=new MemberDao();
String name=dao.getName(myid);



%>

<body>
<a href="<%=root %>" style="text-decoration:none; color:black;margin-left:200px;"><img alt="" src="<%=root%>/img/pororoheader2.png" style="width:200px;">
JSP & JQuery Mini Project</a>
<span class="loginout">
<%
if(loginok!=null){%>
	<b><%=name %></b>님이 접속중입니다.<button type="button" class="btn btn-danger" onclick="location.href='login/logoutaction.jsp'">로그아웃</button>
	
<%}else{%>
	<button type="button" class="btn btn-warning" onclick="location.href='index.jsp?main=login/loginform.jsp'">로그인</button>
<%	
}
%></span>
<div class="cart">
	<%
		ShopDao sdao=new ShopDao();
		
	//카트 갯수 
	int cntSize=sdao.getCartList(myid).size();
	
	%>
	<i class="bi bi-cart4 carticon" style="font-size: 1.2em;"></i>
	<div class="count"><%=cntSize %></div>
</div>
</body>
</html>