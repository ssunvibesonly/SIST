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
<form action="quizaction.jsp" method="post" enctype="multipart/form-data">
	<table class="table table-bordered" style="width:700px;">
		<tr>
			<th>작성자</th>
			<td>
				<input type="text" name="writer" class="form-control" required="required"> 
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>
				<input type="text" name="title" class="form-control" required="required">
			</td>
		</tr>
		<tr>
			<th>이미지 첨부파일</th>
			<td>
				<input type="file" name="uploadfile">
			</td>
		</tr>
		<tr>
		<th>내용</th>
			<td>
				<textarea name="content" class="form-control"></textarea>
			</td>
		</tr>
		<tr align='center'>
			<td  colspan="2">
				<input type="submit" value="글등록" class="btn btn-outline-success" onclick="funcwan()">
				<input type="button" value="글목록" class="btn btn-outline-info" onclick="location.href='quizlist.jsp'">
				<script>
				function funcwan(){
					alert("글이 등록되었습니다.")
				}
			</script>
			</td>
		</tr>
	
	</table>

</form>
</body>
</html>