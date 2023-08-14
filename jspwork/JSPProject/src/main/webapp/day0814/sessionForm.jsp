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
	<%
	 session.setAttribute("msg", "happy");
	 session.setMaxInactiveInterval(10);
	%>
	<h2>10초 안에 눌러주세요!!</h2>
	<form action="sessionAction.jsp" method="post">
		<h2>가고싶은 여행지</h2>
		<input type="radio" name="travel" value="베트남 3박4일">베트남 3박4일&nbsp;
		<input type="radio" name="travel" value="일본 3박4일">일본 3박4일&nbsp;
		<input type="radio" name="travel" value="중국 3박4일">중국 3박4일&nbsp;
		<input type="radio" name="travel" value="대만 3박4일" checked="checked">대만 3박4일&nbsp;<br>
		<input value="여행당첨" type="submit">
	</form>
</body>
</html>