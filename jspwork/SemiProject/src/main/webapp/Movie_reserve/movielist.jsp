<%@page import="java.util.Vector"%>
<%@page import="java.util.List"%>
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
<script>
	$(function(){
		

	})
	




</script>
<style>

#mv_name{

position:absolute;
top:200px;
left:200px;
border:2px solid gray;
width:343px;
height:500px;

}
#mv_theater{

position:absolute;
border:2px solid gray;
top:200px;
left:543px;
width:345px;
height:500px;

}

#mv_day{

position:absolute;
border:2px solid gray;
left:885px;
top:200px;
width:173px;
height:500px;

}
#mv_time{
position:absolute;
border:2px solid gray;
left:1057px;
top:200px;
width:342px;
height:500px;

}

.table{

position:absolute;
top:150px;
left:200px;
text-align:center;
width:1200px;
}

#select_info{

position:absolute;
border:2px solid gray;
top:750px;
left:200px;
width:1200px;
height:200px;


}

</style>
</head>
<body>
<table class="table table-bordered">
	<tr>
		<th style="width:200px;">영화</th>
		<th style="width:200px;">극장</th>
		<th style="width:100px;">날짜</th>
		<th style="width:200px;">시간</th>
	</tr>
</table>



<div align="center" id="info">
<div id="mv_name"><%

String [] mov={"오펜하이머","콘크리트 유토피아","달짝지근해:7510","밀수","엘리멘탈","잠","미션 임파서블: 데드 레코닝 PART ONE","보호자"};
String sum="";
%>
<ul style="text-decoration: none;">
<%
for(int i=0;i<mov.length;i++){
%>
<li><%=mov[i] %></li>
<%
}
%>
</ul>
</div>
<div id="mv_theater"></div>
<div id="mv_day"></div>
<div id="mv_time"></div>
<div id="select_info"></div>


</body>
</html>