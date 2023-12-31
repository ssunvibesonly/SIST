<%@page import="model.memberSawon.memberAdminDto"%>
<%@page import="java.util.Vector"%>
<%@page import="model.memberSawon.memberAdminDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link href="https://fonts.googleapis.com/css2?family=Dongle:wght@300&family=Gamja+Flower&family=Nanum+Pen+Script&family=Noto+Serif+KR:wght@200&display=swap" rel="stylesheet">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style>
#worksheet{
   width:45px;
   float:left;
   margin-left:20px;
   color:gray;
}
b{
font-size:25pt;
margin-left:5px;
font-family:"Noto Serif KR";
}
li{font-weight:bold; color:white;font-family:"Noto Serif KR";}
div.btnLogin{
float: right;
margin-right: 50px;
margin-top: 10px;
}

</style>
</head>
<body>
<%
	String success = (String) session.getAttribute("adminLogin");	
	String id = (String)session.getAttribute("id");	
%>

<br>
<img src="../image/worksheet.png" id="worksheet">
<b>출퇴근 및 급여관리 업무 자동화 프로그램</b>
<%
	if(success==null|| success.equals("")){
		%>
		<div class="btnLogin">
			<button type="button" class="btn btn-outline-info" onclick="location.href='loginForm.jsp'">로그인</button>
		</div>
		<% 
	}else{
%>		<div class="btnLogin">
			<b style="font-size: 15pt">관리자</b>&nbsp;&nbsp;님
			<button type="button" class="btn btn-outline-info" onclick="location.href='logoutProc.jsp'">로그아웃</button>
		</div>
<%} %>

<div style="margin-top:20px;">
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">SJProject</a>
    </div>
    <ul class="nav navbar-nav" >
      <li><a href="adminForm.jsp">Home</a></li>
      <li class="dropdown active"><a class="dropdown-toggle" data-toggle="dropdown" href="#">사원관리<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="sawonInfo.jsp">사원정보</a></li>
          <li><a href="#">업무일지</a></li>
          <li><a href="#">부서별 업무 현황</a></li>
        </ul>
      </li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">근무내역<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">일일 근무 현황</a></li>
          <li><a href="#">월간 사원별 출퇴근 현황</a></li>
          <li><a href="#">급여 내역서</a></li>
        </ul>
      </li>
      <li><a href="#">SJ커뮤니티</a></li>
    </ul>
  </div>
</nav>
<div class="container">
  <h3>Navbar With Dropdown</h3>
  <p>This example adds a dropdown menu for the "Page 1" button in the navigation bar.</p>
</div>
</body>
</html>