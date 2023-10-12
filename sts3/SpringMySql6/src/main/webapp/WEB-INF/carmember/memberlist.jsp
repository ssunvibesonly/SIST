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
<c:if test="${count==0 }">
	<h2 class="alert alert-info">등록된 고객정보가 없습니다.</h2>
</c:if>
<c:if test="${count>0 }">
	<h2 class="alert alert-info">총 ${count }명의 고객이 있습니다.</h2>
	<button type="button" class="btn btn-warning" onclick="location.href='addform'">사용자 등록하기</button>
</c:if>

<table class="table table-bordered">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>핸드폰 번호</th>
			<th>주소</th>
			<th>가입일</th>
			<th>편집</th>
		</tr>
		<c:forEach var="cdto" items="${list }" varStatus="i">
		<tr>
			<td>${i.count }</td>
			<td>${cdto.name }</td>
			<td>${cdto.hp }</td>
			<td>${cdto.addr }</td>
			<td><fmt:formatDate value="${cdto.gaipday }" pattern="yyyy-MM-dd"/></td>
			<td>
				<button type="button" class="btn btn-secondary" 
				onclick="location.href='updateform?num=${cdto.num}'">수정</button>
				<button type="button" class="btn btn-danger"
				onclick="location.href='delete?num=${cdto.num}'">삭제</button>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>