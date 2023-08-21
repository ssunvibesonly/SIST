-<%@page import="model.memberSawon.memberAdminDao"%>
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
<%
   String success = (String) session.getAttribute("sawonLogin");   
   String id = (String)session.getAttribute("id");
   memberAdminDao dao = new memberAdminDao();
   String name=dao.getName(id);
%>
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
th{text-align:center; background-color:lightgrey;}
td{text-align:center;}

</style>
<script>
$(function(){
	
	list();
	
	$("#btn1").click(function(){
		alert("출근하셨네요! 오늘 하루도 화이팅:)")
		var id = document.getElementById("id").value;
		$.ajax({
			type:"post",
			dataType:"html",
			data:{"id":id},
			url:"sawonlistBoard.jsp",
			success:function(res){
			list();	

			}
	
		})

	})
	$("#btn2").click(function(){
		alert("오늘 하루도 수고 많았어요 :)")
		var id = document.getElementById("id").value;
		$.ajax({
			type:"post",
			dataType:"html",
			data:{"id":id},
			url:"update.jsp",
			success:function(res){
				list();
				
			}
			
			
		})
		
		
	})
	


})
function list(){
		var id = document.getElementById("id").value;
		 $.ajax({
         type:"get",
         data:{"id":id},
         dataType:"json",
         url:"select.jsp",
         success:function(data){
            //alert(data.length);
            var s="<table class='table table-bordered'>";
               s+="<tr>";
               s+="<th>번호</th>";
               s+="<th>출근일</th>";
               s+="<th>사용자 ID</th>"
               s+="<th>직급</th>"
               s+="<th>이름</th>"
               s+="<th>부서</th>";
               s+="<th>출근시간</th>";
               s+="<th>퇴근시간</th>";
               $.each(data,function(idx,ele){
                  s+="<tr>"
                  s+="<td>"+(idx+1)+"</td>";
                  s+="<td>"+ele.workday+"</td>";
                  s+="<td>"+ele.id2+"</td>";
                  s+="<td>"+ele.position2+"</td>";
                  s+="<td>"+ele.name2+"</td>"
                  s+="<td>"+ele.department2+"</td>";
                  s+="<td>"+ele.go+"</td>"
                  s+="<td>"+ele.bye+"</td></tr>";

                  
                 
               })
            
            s+="</table>";
            $("#show").html(s);
            
         }
         
         })

}
	</script>
</head>
<body>
<input type="hidden" id="id" value="<%=id%>">
<br>
<img src="../image/worksheet.png" id="worksheet">
<b>출퇴근 및 급여관리 업무 자동화 프로그램</b>
<%
   if(success==null|| success.equals("")){
      %>
      <div class="btnLogin">
         <button type="button" class="btn btn-outline-info" onclick="location.href='../adminPage/loginForm.jsp'">로그인</button>
      </div>
      <% 
   }else{
%>      <div class="btnLogin">
         <b style="font-size: 15pt"><%=name %></b>&nbsp;&nbsp;님
         <button type="button" class="btn btn-outline-info" onclick="location.href='../adminPage/logoutProc.jsp'">로그아웃</button>
      </div>
<%} %>

<div style="margin-top:20px;">
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">SJProject</a>
    </div>
    <ul class="nav navbar-nav" >
      <li class="active"><a href="#">Home</a></li>
      <li><a href="#">SJ커뮤니티</a></li>
    </ul>
  </div>
</nav>
</div>  

<div class="container">
  <h1 style="font-family: Noto Serif KR; font-weight:bold; color:gray;">출퇴근 관리</h1><br>
  <button type="button" class="btn btn-primary btn-block" id="btn1">출근</button>
  <button type="button" class="btn btn-danger btn-block" id="btn2">퇴근</button>
</div>
<br><br>
<div class="container" id="show"></div>
<br>
</body>
</html>