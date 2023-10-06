<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
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
<br>
<table class="table table-bordered">
	<tr>
		<th>이름</th>
		<td>${name }</td>
	</tr>
	<tr>
		<th>학교</th>
		<td>${school }</td>
	</tr>
	<tr>
		<th>학년</th>
		<td>${grade }</td>
	</tr>
	<tr>
		<th>학교주소</th>
		<td>${addr }</td>
	</tr>

</table>
</body>
</html>