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
<fmt:requestEncoding value="utf-8"/>
	<form action="ex4_JstlTagTest.jsp" method="post">
		<table class="table table-bordered" style="width: 300px;">
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="name" class="form-control" style="width: 120px;">
				</td>
			</tr>
			<tr>
				<th>나이</th>
				<td>
					<input type="text" name="age" class="form-control" style="width: 120px;">
				</td>
			</tr>
			<tr>
				<th>급여</th>
				<td>
					<input type="text" name="pay" class="form-control" style="width: 120px;">
				</td>
			</tr>
			<tr>
				<th>가고싶은 나라</th>
				<td>
					<input type="text" name="nara" class="form-control" style="width: 120px;">
				</td>
			</tr>
			<tr>
			<td colspan="2" align="center">
				<button type="submit" class="btn btn-success">결과 확인</button>
			</td>
			</tr>
		</table>
	</form>
	
	<!-- 이름을 입력했을 경우에만 출력 div로 출력 
		이름 : 김영환
		나이 : 19세(미성년자)..조건:20살 이상이면 성인, 그렇치 않으면 미성년자
		급여 : 180만원..화폐단위와 천 단위 구분 기호
		가고싶은 나라 : choose 이용해서 
	
	-->
	<div style="border: 2px solid gray;width: 400px;height: 300px;">
		<c:if test="${!empty param.name }">
		 <h4>이름: ${param.name }</h4>
		 <h4 style="float: left;">나이: ${param.age }</h4>
		 	<c:if test="${param.age<20 }"><span style="color: blue;">(미성년자)</span></c:if>
		 	<c:if test="${param.age>20 }"><span style="color: red;" >(성인)</span></c:if>
		 	
		 <h4 style="clear: both;">급여: <fmt:formatNumber value="${param.pay }" type="currency"/></h4>
		 <h4>가고싶은 나라: ${param.nara } </h4>
		 	<c:choose>
		 		<c:when test="${param.nara=='일본' }"><h4>일본가서 당고 먹자</h4></c:when>
		 		<c:when test="${param.nara=='미국' }"><h4>미국 햄버거는 짜</h4></c:when>
		 		<c:otherwise><h4>어디든 여행가고 싶어용</h4></c:otherwise>
		 	</c:choose>
		
		</c:if>
		
	
	</div>
	
</body>
</html>