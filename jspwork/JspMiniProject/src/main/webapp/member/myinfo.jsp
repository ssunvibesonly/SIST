<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dao.MemberDao"%>
<%@page import="data.dto.MemberDto"%>
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
	  $(".btndelete").click(function(){
		
		  var num=$(this).attr("num");
		  //alert(num);
		  
		  var ans=confirm("정말 탈퇴하시겠습니까?")
		  
		  if(ans){
			  location.href="member/deleteme.jsp?num="+num;
		  }
	  });
	  
  });

</script>
</head>
<%
String loginok=(String)session.getAttribute("loginok");
String myid=(String)session.getAttribute("myid");

MemberDao dao=new MemberDao();
MemberDto a=new MemberDto();
List<MemberDto> list=dao.getAllMembers();
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");


%>
<body>

<% for(MemberDto dto:list){
		if(loginok!=null&&myid.equals(dto.getId())){%>
	<table class="table table-bordered" style="width:1000px;">
	<tr>
		<td rowspan="7" style="width: 350px;">
		<img src="img/rupy5.png">
		</td>
		<th>이름</th>
		<td><%=dto.getName() %></td>
		<div>
		<td rowspan="7" style="vertical-align: middle; width: 130px;" align="center">
		<button type="button" class="btn btn-outline-warning btn-sm" onclick="location.href='index.jsp?main=member/updateform.jsp?num=<%=dto.getNum()%>'">수정</button>
		<button type="button" class="btn btn-outline-danger btn-sm btndelete" num=<%=dto.getNum() %>>탈퇴</button>
		</div>
		</td>
	</tr>	
		<tr>
		<th>ID</th>
		<td><%=dto.getId() %></td>
		</tr>
		<tr>
		<th>PW</th>
		<td><%=dto.getPass() %></td>
		</tr>
		<tr>
		<th>HP</th>
		<td><%=dto.getHp() %></td>
		</tr>
		<tr>
		<th>E-mail</th>
		<td><%=dto.getEmail() %></td>
		</tr>
		<tr> 
		<th>주소</th>
		<td><%=dto.getAddr() %></td>

		</tr>
		
		<br>
		</table>
		<%}%>
		<br>


<%}%>


</body>
</html>