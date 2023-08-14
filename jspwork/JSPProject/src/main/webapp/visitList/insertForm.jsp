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
<style>
.emoticon{
	cursor:pointer;
}
.select{
	border:2px solid orange;
}}
</style>
<script>
$(function(){

	$(".emoticon").click(function(){
		$(this).addClass("select");
		$(this).siblings().removeClass('select');
		$("#img").val($(this).attr("src")); //input에 value값을 안줬으므로 어디서든 꼭 주어야 값을 넘길 수 있다.
											//input에는 값을 넘겨줄 땐 경로가 넘어가는 것이지 이미지 자체가 넘어갈 수 없다.
		
	})
	
	
})


</script>
</head>
<body>
	<form action="insertAction.jsp" method="post">
	<h2>방명록 남기기</h2>
		<table class="table table-bordered" style="width:750px">
			<tr>
				<th>작성자</th>
					<td>
						<input name="nick" type="text" class="form-control" required="required">
					</td>
				<th>패스워드</th>
					<td>
						<input name="pass" type="password" class="form-control" required="required">
					</td>							
			</tr>
			<tr>
				<th>이모티콘</th>
					<td colspan="3">
						<input type="hidden" name="image" id="img"><!-- 표에는 텍스트 or 라디오, 체크 등의 타입만 들어갈 수 있는데 이미지를 넣어주기 위해 hidden타입으로 줬다. -->
						<script>
							for(var i=1;i<=10;i++){
								var s="<img src='../image/만화이미지/"+(i<10?"0":"")+i+".png' style='width:50px' class='emoticon'>"+"&nbsp;&nbsp;"
								
								document.write(s);
								
							}
						</script>
					</td>
			</tr>
			<tr>
				<td colspan="4">
					<textarea type="text" name="story" class="form-control"
					style="height:100px"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<input type="submit" value="방명록 작성" class="btn btn-outline-info">
				</td>
			</tr>
		</table>


	</form>
</body>
</html>