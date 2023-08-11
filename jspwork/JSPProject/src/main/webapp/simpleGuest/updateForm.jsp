<%@page import="db.simpleguest.SimpleGuestDTO"%>
<%@page import="db.simpleguest.SimpleGuestDAO"%>
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
<%

String num=request.getParameter("num");


SimpleGuestDAO dao=new SimpleGuestDAO();

SimpleGuestDTO dto=dao.getData(num);





%>
</head>
<body>
<div style="margin:50px;100px">
<form action="updateAction.jsp" method="post">
	<!--num hidden으로 넘기기  -->
	<input type="hidden" name="num" value="<%=num%>">
	<table class="table table-bordered" style="width:850px;" align="center">
		<caption align="top"><b>간단 방명록 수정</b></caption>
			<tr>
				<th width="80" style="background-color:lightpink">닉네임</th>
				<td>
					<input type="text" name="nick" class="form-control" required="required" style="width:120px;" value="<%=dto.getNick() %>">
				</td>
				<th width="100" style="background-color:lightpink">비밀번호</th>
				<td>
					<input type="password" name="pass" class="form-control" required="required" style="width:120px;">
				</td>
			</tr>
			<tr>
			<th colspan="4">
			<%
			int img=Integer.parseInt(dto.getImage());
			for(int i=11;i<=20;i++){%>
				<input type="radio" name="image" value="<%=i %>" <%=i==img?"checked":""%>>&nbsp;
				<img src="../image/만화이미지/<%=i %>.png" style="width:50px">
			<% }%>
			</th>
			</tr>
			<tr>
				<th colspan="4">
					<textarea class="form-control" name="story" style="width:800px; height:150px"><%=dto.getStory() %></textarea>
				</th>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<input type="submit" value="수정" class="btn btn-outline-info" >
					<input type="button" value="목록" class="btn btn-outline-warning"
					onclick="location.href='guestList.jsp'">
				</td>
			</tr>
			
				
		
			
			
	</table>
</form>
</div> 
</body>
</html>