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
<div style="margin:50px;100px">
<form action="insertAction.jsp" method="post">
	<table class="table table-bordered" style="width:850px;" align="center">
		<caption align="top"><b>간단 방명록</b></caption>
			<tr>
				<th width="80" style="background-color:lightpink">닉네임</th>
				<td>
					<input type="text" name="nick" class="form-control" required="required" style="width:120px;">
				</td>
				<th width="100" style="background-color:lightpink">비밀번호</th>
				<td>
					<input type="password" name="pass" class="form-control" required="required" style="width:120px;">
				</td>
			</tr>
			<tr>
			<th colspan="4">
			<%
			for(int i=11;i<=20;i++){%>
				<input type="radio" name="image" value="<%=i %>" <%=i==13?"checked":"" %>>&nbsp;
				<img src="../image/만화이미지/<%=i %>.png" style="width:50px">
			<% }%>
			</th>
			</tr>
			<tr>
				<th colspan="4">
					<textarea class="form-control" name="story" style="width:800px; height:150px"></textarea>
				</th>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<input type="submit" value="저장" class="btn btn-outline-info">
					<input type="button" value="목록" class="btn btn-outline-warning"
					onclick="location.href='guestList.jsp'">
				</td>
			</tr>
			
				
		
			
			
	</table>
</form>
</div>
</body>
</html>