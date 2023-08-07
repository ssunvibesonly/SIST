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
<form action="uploadAction.jsp" method="post" enctype="multipart/form-data"> <!-- 파일업로드에서 enctype="multipart/form-data 써줘야함 -->
	<table class="table table-bordered" style="width:500px">
		<tr>
			<th width="100">이름</th>
			<td>
			<input type="text" name="name" class="form-control">
			</td>
		</tr>
		<tr>
			<th width="100">제목</th>
			<td>
			<input type="text" name="title" class="form-control"
			style="width:350px;">
			</td>
		</tr>
		<tr>
			<th width="100">파일</th>
		<td>
			<input type="file" name="uploadFile">
		</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<button type="submit" class="btn btn-success">업로드</button></td>
		</tr>
	
	</table>
	</form>
</body>
</html>