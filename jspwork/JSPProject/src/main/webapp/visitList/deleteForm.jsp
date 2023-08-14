<%@page import="model.visitlist.visitListDTO"%>
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
String num=request.getParameter("num");

visitListDTO dto=new visitListDTO();

%>
<body>
<form action="deleteAction.jsp" method="post">
<input type="hidden" name="num" value=<%=num %>>
<table class="table table-bordered" style="width:300px">
	<tr >
	<th>패스워드를 입력하세요</th>
	</tr>
	<tr>
	<td>
		<input type="password" name="pass" class="form-control">
	</td>
	</tr>
	<tr>
	<td>
	<input type="submit" value="확인" class="btn btn-outline-info">
	</td>
	</tr>

</table>

</form>
</body>
</html>