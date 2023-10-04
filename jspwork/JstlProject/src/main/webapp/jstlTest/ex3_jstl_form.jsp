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
<!-- 한글 엔코딩(get방식은 한글 안깨짐) -->
<fmt:requestEncoding value="utf-8"/>
	<form action="ex3_jstl_form.jsp" method="post" style="width:200px;">
		<h3>이름 입력</h3>
		<input type="text" name="irum" class="form-control">
		<h3>가고싶은 나라</h3>
		<input type="text" name="nara" class="form-control">
		<br>
		<button type="submit" class="btn btn-info">결과 확인</button>
	
	</form>
	
	<!-- 이름을 입력시에만 결과가 나오도록 -->
	 <!-- param == request.getParameter -->
	<c:if test="${!empty param.irum }"> <!-- irum이 비어있지 않다면, -->
		<h2>이름: ${param.irum }</h2>
		<h3>가고싶은 나라: ${param.nara }</h3>
		
		<c:choose>
			<c:when test="${param.nara=='프랑스' }">
				<h3 style="color:blue;">프랑스는 에펠탑</h3>
			</c:when>
			<c:when test="${param.nara=='체코' }">
				<h3 style="color:brown;">체코는 흑맥주</h3>
			</c:when>
			<c:when test="${param.nara=='하와이' }">
				<h3 style="color:yellow;">하와이는 훌라춤</h3>
			</c:when>
			<c:when test="${param.nara=='오스트리아' }">
				<h3 style="color:magenta;">오스트라이는 마리앙트와네트</h3>
			</c:when>
			<c:otherwise>
				<h3 style="color:red;">${param.nara }는 해당사항 없음</h3>
			</c:otherwise>
		
		</c:choose>
	</c:if>
	
	
</body>
</html>