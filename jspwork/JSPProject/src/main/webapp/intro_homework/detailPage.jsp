<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.intro.IntroDao"%>
<%@page import="model.intro.IntroDto"%>
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
<style type="text/css">
	#imgy{
		margin-left:300px;
		margin-top:70px;
		
	}
	
	#tb{
		margin-left:800px;
		margin-top:-230px;
		border : "5px solid black";
	}
	

</style>

<%
request.setCharacterEncoding("utf-8");
String num=request.getParameter("num");
IntroDao dao=new IntroDao();
IntroDto dto=dao.detailPage(num);
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

%>

<script type="text/javascript">
	
	var imgarr=new Array();

	imgarr[0]="../image/만화이미지/01.png"
	imgarr[1]="../image/만화이미지/03.png"
	imgarr[2]="../image/만화이미지/05.png"
	imgarr[3]="../image/만화이미지/07.png"
	imgarr[4]="../image/만화이미지/09.png"
	imgarr[5]="../image/만화이미지/11.png"
					
	
	function randomImage(){
		
		var rimg=Math.round(Math.random()*5);
		var objImg=document.getElementById("introImg");
		objImg.src=imgarr[rimg]
	}
		
</script>
</head>
<body onload="randomImage()">
<form>
	<h1 style="margin-left:100px;margin-top:50px;font-size:50pt;font-family:'Noto Serif KR'; font-weight:bold;">사용자 정보</h1>
	<hr style="margin-top:50px">
	<div id="imgy"><img id="introImg" width="300px" height="300px" ></div>

<div id="tb">
<input type="hidden" name="num" value="<%=num %>">
<table class='table table-bordered' style="width:500px">
		
		<tr>
			<th style="width:120px; text-align:center">이름</th>
			<td><%=dto.getName() %></td>
		</tr>
		<tr>
		<th style="width:120px; text-align:center">MBTI</th>
		<td><%=dto.getMbti() %></td>
		</tr>
		<tr>
		<th style="width:120px; text-align:center">연락처</th>
		<td><%=dto.getHp() %></td>
		</tr>
		<tr>
		<th style="width:120px; text-align:center">주소</th>
		<td><%=dto.getCity() %></td>
		</tr>
		<tr>
		<th style="width:120px; text-align:center">가입일</th>
		<td><%=dto.getGaip() %></td>
		</tr>
	
</table>
</div>



</form>
</body>
</html>