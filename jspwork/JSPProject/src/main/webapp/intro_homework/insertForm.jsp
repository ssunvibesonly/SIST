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
<style type="text/css">
	div{
		magin-top:100px
	}

</style>

<script type="text/javascript">
$(function(){
	$("#hp2").keyup(function(){
		if($(this).val().length==4){
			$("#hp3").focus();
			
		}
	
	})
	})
</script>
<body style="background-color:lightgray">
<form action="insertAction.jsp" method="post">
	<div style="margin-left:100px;margin-top:50px;font-size:50pt;font-family:'Noto Serif KR'; font-weight:bold;"
	 >프로필 등록</div>
	<hr style="color:white; border:2px solid white">
	<div style="margin-left:580px; margin-top:70px">
	<table class="table table-bordered" style="width:500px; height:500px; ">
		<tr valign="middle" style="text-align:center">
			<th>이름</th>
				<td>
					<input type="text" class="form-control" name="name" required="required" placeholder="이름을 입력하세요">
				</td>
		</tr>
		<tr valign="middle" style="text-align:center">
			<th>MBTI</th>
				<td>
				<input type="text" class="form-control" name="mbti" placeholder="MBTI를 입력하세요" required="required">
				</td>
		</tr>
		<tr valign="middle" >
			<th style="text-align:center">핸드폰 번호</th>
			<td>
				<select name="hp1">
					<option value="010">010</option>
					<option value="017">017</option>
					<option value="018">018</option>
					<option value="019">019</option>
				</select>
				<b>-</b>
				<input id="hp2" name="hp2" type="text"  maxlength="4" size="4" required="required">
				<b>-</b>
				<input id="hp3" name="hp3" type="text"  maxlength="4" size="4" required="required">
			</td>
		</tr>
		<tr valign="middle" style="text-align:center">
			<th>사는 지역</th>
			<td>
				<input type="radio" name="city" value="서울">서울&nbsp;
				<input type="radio" name="city" value="경기">경기&nbsp;
				<input type="radio" name="city" value="대전">대전&nbsp;
				<input type="radio" name="city" value="부산">부산&nbsp;
				<input type="radio" name="city" value="광주">광주&nbsp;
				<input type="radio" name="city" value="제주">제주&nbsp;
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center" valign="middle">
			<button type="submit" onclick="location.href='list_intro.jsp'"
			class="btn btn-success">프로필 등록</button>
			</td>
		</tr>
	
	</table>
</div>
</form>
</body>
</html>