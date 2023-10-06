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
	<form action="read1">
		<table class="table table-bordered" style="width: 200px;">
			<tr>
				<th>
					제목:<input type="text" name="mtitle" class="form-control">
				</th>
			</tr>
			<tr>
				<td align="center">
					<button type="submit" class="btn btn-success">데이터 전송</button>
				</td>
			</tr>
		</table>
	</form>
	
	<form action="read2">
		<table class="table table-bordered" style="width: 400px;">
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="myname" class="form-control">
				</td>
			</tr>
			<tr>
				<th>학교</th>
				<td>
					<input type="text" name="myschool" class="form-control">
				</td>
			</tr>
			<tr>
				<th>학년</th>
				<td>
					<input type="text" name="mygrade" class="form-control">
				</td>
			</tr>
			<tr>
				<th>학교주소</th>
				<td>
					<input type="text" name="myschooladdr" class="form-control">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-info">데이터 전송</button>
				</td>
			</tr>
		</table>
	</form>
		<form action="read3" method="post">
		<table class="table table-bordered">
			<tr>
				<th>카테고리</th>
				<td>
					<input type="text" name="category" class="form-control">
				</td>
			</tr>
			<tr>
				<th>상품명</th>
				<td>
					<input type="text" name="sang" class="form-control">
				</td>
			</tr>
			<tr>
				<th>가격</th>
				<td>
					<input type="text" name="price" class="form-control">
				</td>
			</tr>
			<tr>
				<th>색상</th>
				<td>
					<input type="text" name="color" class="form-control">
				</td>
			</tr>
			<tr>
				<td colspan="2">
				<button type="submit" class="btn btn-danger">데이터 전송</button>
				</td>
			</tr>
		</table>
	</form>
	<form action="read4" method="post">
	<table class="table table-bordered">
		<tr>
			<th>이름</th>
			<td>
				<input type="text" name="name" class="form-control">
			</td>
		</tr>
		<tr>
			<th>나이</th>
			<td>
				<input type="text" name="age" class="form-control">
			</td>
		</tr>
		<tr>
			<th>혈액형</th>
			<td>
				<input type="text" name="blood" class="form-control">
			</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>
				<input type="text" name="addr" class="form-control">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="submit" class="btn btn-warning">데이터 전송</button>
			</td>
		</tr>
	</table>
	</form>

</body>
</html>