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
<button onclick="location.href='ilike/movie'" class="btn btn-outline-info">제목을 메세지로 받아서 출력하고 그 아래 이미지_result1</button><br>
<button onclick="location.href='school/myinfo'" class="btn btn-outline-success">get방식(이름,학교,학년,학교주소)_테이블출력_result2</button><br>
<button onclick="location.href='shop/ipgo'" class="btn btn-outline-danger">post방식(카테고리,상품명,가격,색상)_dto_테이블출력_result3</button><br>
<button onclick="location.href='myshinsang'" class="btn btn-outline-warning">post방식_map(이름,나이,혈액형,주소)_출력_result4</button><br>
</body>
</html>