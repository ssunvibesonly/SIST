<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle:wght@300&family=Gaegu:wght@300&family=Nanum+Pen+Script&family=Sunflower:wght@300&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
<style type="text/css">
	#showimg{
		border: 1px solid gray;
		width: 130px;
		height: 160px;
		margin-top: 20px;
	}
</style>
<script type="text/javascript">
	$(function(){
		
		$("#btnphoto").click(function(){
			$("#myphoto").trigger("click");
		});
		
		
		//사진 미리보기
        $("#myphoto").on("change", function(event) {

            var file = event.target.files[0];

            var reader = new FileReader();
            reader.onload = function(e) {

                $("#showimg").attr("src", e.target.result);
            }

            reader.readAsDataURL(file);
        });
		
		
		//아이디 입력시 아이디 체크
		$("#btnidcheck").click(function(){
			
			var id=$("#id").val();
			
			$.ajax({
				type:"get",
				dataType:"json",
				url:"idcheck", //MemberController에서 설정한 매핑주소
				data:{"id":id},
				success:function(res){
					
					if(res.check==0)
						$("span.idsuccess").text("ok").css("color","green");
					else
					{
						$("span.idsuccess").text("fail").css("color","red");
					}
				}
			});
			
		});
		
		//2번째 비밀번호 입력시 체크
		$("#pass2").keyup(function(){
			var p1=$("#pass").val();
			var p2=$(this).val();
			
			if(p1==p2)
			{
				$("span.passsuccess").text("ok").css("color","green");
			}
			else
			{
				$("span.passsuccess").text("");
			}
		});
		
		//submit 전에 필수 사항 체크
	});
	
	function check(){
		
		
		//사진
		if($("#myphoto").val()=='')
		{
			alert("사진을 넣어주세요");
			return false;
		}
		//id
		if($("span.idsuccess").text()!='ok')
		{
			alert("아이디 중복 체크를 해주세요");
			return false;
		}
			
		//비밀번호
		if($("span.passsuccess").text()!='ok')
		{
			alert("비밀번호 중복 체크를 해주세요");
			return false;
		}
	}
</script>
</head>
<body>
	<div style="margin: 100px 100px;">
		<form action="insert" method="post" enctype="multipart/form-data" onsubmit="return check()">
			<table class="table table-bordered" style="width: 600px;">
				<caption align="top"><b>회원가입</b></caption>
				<tr>
					<td rowspan="5" align="center" style="width: 250px;">
						<input type="file" id="myphoto" name="myphoto" style="display: none;">
						<button type="button" id="btnphoto" class="btn btn-secondary">사진선택</button>
						<br>
						<img id="showimg">
					</td>
					<td>
						<div class="d-inline-flex">
							<input type="text" placeholder="아이디입력" name="id" id="id"
							class="form-control" style="width: 120px;">
							<button type="button" class="btn btn-danger"
							id="btnidcheck">중복체크</button> &nbsp;&nbsp;
							<span class="idsuccess" style="width: 60px; color: green;"></span>
						</div>
					</td>
				</tr>
				
				<tr>
					<td>
						<div class="d-inline-flex">
							<input type="password" style="width: 120px;" class="form-control"
							name="pass" id="pass" placeholder="숫자4자리" maxlength="4" required="required">
							<input type="password" style="width: 120px;" class="form-control"
							id="pass2" placeholder="숫자4자리" maxlength="4" required="required">&nbsp;&nbsp;
							<span class="passsuccess" style="width: 60px; color: green;"></span>
						</div>
					</td>
				</tr>
				
				<tr>
					<td>
						<input type="text" name="name" class="form-control" placeholder="이름" required="required"
						style="width: 150px;">
					</td>
				</tr>
				
				<tr>
					<td>
						<input type="text" name="email" class="form-control" placeholder="이메일" required="required"
						style="width: 250px;">
					</td>
				</tr>
				
				<tr>
					<td>
						<input type="text" name="addr" class="form-control" placeholder="주소입력" required="required"
						style="width: 300px;">
					</td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-outline-info" style="width: 120px;">회원가입</button>
						<button type="button" class="btn btn-outline-info" style="width: 120px;"
						onclick="location.href=''">로그인</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>