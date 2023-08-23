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
<script>
$(function(){

	//id중복체크
	$("#btncheck").click(function(){
		//id읽기
		var id=$("#id").val();
		//alert(id);
		
		$.ajax({
		
			type:"get",
			url:"member/idsearch.jsp",
			dataType:"json",
			data:{"id":id}, //"id"는 name태그에 있는 것이다.
			success:function(data){
				
				//alert(data.count);
				if(data.count==1){
					alert("이미 가입된 아이디 입니다.\n다시 입력해 주세요.")
					$("span.idsuccess").text("fail").css("color","red");
					$("#id").val("");
					$("#id").focus();
					
				}else{
					$("span.idsuccess").text("success").css("color","green");
					alert("가입 가능한 아이디 입니다.")
				}
				
			}
			
		})
		
	})
	$("#selemail").change(function(){
		if($(this).val()=='-'){
			$("#email2").val("");
			$("#email2").focus();
		}else{
			$("#email2").val($(this).val());
		}
		
	})

	
})
function check(f){
	if(f.pass.value!=f.pass2.value){
		alert("비밀번호가 서로 다릅니다.");
		f.pass.value="";
		f.pass2.value="";
		
		return false; //action이 호출되지 않는다.
	}
	
}


</script>
</head>
<body>
<form action="member/memberaction.jsp" method="post" onsubmit="return check(this)"> <!-- submit하기 전에 check(this)해야 submit 된다. -->
	<table class="table table-bordered" style="width:500px;">
		<caption align="top" style="text-align: center;"><b>회원가입</b></caption>
			<tr>
				<td>
					<input type="text" name="id" placeholder="아이디" class="form-group"required="required"
					style="width:120px;" id="id">&nbsp;&nbsp;&nbsp;<button type="button" class="btn btn-danger btn-sm" id="btncheck">중복체크</button>&nbsp;&nbsp;&nbsp;<span class="idsuccess"></span> 
				</td>
			</tr>
			<tr>
				<td>
					<input type="password" name="pass" placeholder="비밀번호" class="form-group"required="required"
					style="width:120px;">
					<input type="password" name="pass2" placeholder="비밀번호 확인" class="form-group"required="required"
					style="width:120px;">
					
				</td> 
			</tr>
			<tr>
				<td>
					<input type="text" name="name" placeholder="이름" class="form-group"required="required"
					style="width:120px;">
				</td> 
			</tr>
			<tr>
				<td>
					<input type="text" name="hp" placeholder="핸드폰번호" class="form-group"required="required"
					style="width:120px;">
				</td> 
			</tr>
			<tr>
				<td>
					<input type="text" name="addr" placeholder="주소" class="form-group"required="required"
					style="width:120px;">
				</td> 
			</tr>
			<tr>
			<td style="width:100px;">
				<input type="text" name="email1" class="form-group" required="required" placeholder="이메일"
				style="width:120px;">
				<b>@</b>
				<input type="text" name="email2" id="email2" required="required" style="width:120px">
				<select id="selemail" class="form-group" style="width:100px;">
					<option value="-">직접입력</option>
					<option value="naver.com">네이버</option>
					<option value="google.com">Gmail</option>
					<option value="nate.com">네이트</option>
					<option value="daum.net">다음</option>
				
				</select>
	
			</td>		
			</tr>
			<tr>
				<td>
				<button type="submit" class="btn btn-outline-info" style="width:100px;">회원가입</button>
				<button type="reset" class="btn btn-outline-warning" style="width:100px;">초기화</button>
				</td>
			
			</tr>

	</table>


</form>
</body>
</html>