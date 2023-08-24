<%@page import="java.util.StringTokenizer"%>
<%@page import="data.dao.MemberDao"%>
<%@page import="data.dto.MemberDto"%>
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
<%
String num=request.getParameter("num");
MemberDao dao=new MemberDao();
MemberDto dto=dao.seleUpMember(num);

//이메일 구분하기(@기준으로)_#1
 int idx=dto.getEmail().indexOf('@');
String email1=dto.getEmail().substring(0, idx);//0~(idx-1)
String email2=dto.getEmail().substring(idx+1);

 
/*  //@을 구분자로 분리_#2
 StringTokenizer st=new StringTokenizer(dto.getEmail(),"@");
 String email1=st.nextToken();
 String email2=st.nextToken();
  */
 
 
%>
<body>
<form action="member/updateaction.jsp" method="post" onsubmit="return check(this)"> <!-- submit하기 전에 check(this)해야 submit 된다. -->
	<input type="hidden" name="num" value="<%= num%>">
	<table class="table table-bordered" style="width:500px;">
		<caption align="top" style="text-align: center;"><b>회원가입</b></caption>
			<tr>
			<th style="width:100px;">아이디</th>
				<td style="width:300px;">
					<%=dto.getId() %>
				</td>
			</tr>
			<tr>
			<th>비밀번호</th>
				<td style="width:300px;">
					<input type="password" name="pass" placeholder="비밀번호" class="form-group"required="required"
					style="width:120px;">
					<input type="password" name="pass2" placeholder="비밀번호 확인" class="form-group"required="required"
					style="width:120px;">
					
				</td> 
			</tr>
			<tr>
			<th>이름</th>
				<td style="width:300px;">
					<input type="text" name="name" class="form-group" value="<%=dto.getName() %>"
					style="width:120px;">
				</td> 
			</tr>
			<tr>
			<th>핸드폰번호</th>
				<td style="width:300px;">
					<input type="text" name="hp" placeholder="핸드폰번호" class="form-group"required="required"
					style="width:120px;" value="<%=dto.getHp()%>">
				</td> 
			</tr>
			<tr>
			<th>주소</th>
				<td style="width:300px;">
					<input type="text" name="addr" value="<%=dto.getAddr() %>" class="form-group"required="required"
					style="width:120px;">
				</td> 
			</tr>
			<tr>
			<th>이메일</th>
			<td style="width:300px;">
				<input type="text" name="email1" class="form-group" required="required" value="<%=email1 %>"
				style="width:120px;">
				<b>@</b>
				<input type="text" name="email2" id="email2" required="required" style="width:120px" value="<%=email2 %>">
				<select id="selemail" class="form-group" style="width:100px;">
					<option value="-" >직접입력</option>
					<option value="naver.com" >네이버</option>
					<option value="google.com">Gmail</option>
					<option value="nate.com">네이트</option>
					<option value="daum.net">다음</option>
				
				</select>
	
			</td>		
			</tr>
			<tr>
				<td colspan="2">
				<button type="submit" class="btn btn-outline-info" style="width:100px;">수정완료</button>
				<button type="reset" class="btn btn-outline-warning" style="width:100px;">초기화</button>
				</td>
			
			</tr>

	</table>


</form>
</body>
</html>