<%@page import="member.model.MemberDTO"%>
<%@page import="member.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css2?family=Dongle:wght@300&family=Gamja+Flower&family=Nanum+Pen+Script&family=Noto+Serif+KR:wght@200&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
<%
String num=request.getParameter("num");
MemberDAO dao=new MemberDAO();
MemberDTO dto=dao.getDta(num);

%>
</head>
<body>
  <div style="margin: 50px; 100px;">
  	<form action="updateProc.jsp" method="post" enctype="multipart/form-data" class="form-inline"  id="mfrm">
  	<!-- hidden -->
  	<input type="hidden" name="num" value="<%=num%>">
  		<table class="table table-bordered" style="width:500px;">
  			<caption align="top"><b>회원수정</b></caption>
  			<tr>
  				<td style="background-color:#66cdaa" width="120">아이디</td>
  				<td>
  					<b><%=dto.getId() %></b>
  				</td>
  			</tr>
  			<tr>
  				<td style="background-color:#66cdaa" width="120">비밀번호</td>
  				<td>
  					<input type="password" name="pass" class="form-control" style="width:120px;"
  					value="<%=dto.getPass() %>">
  				</td>
  			</tr>
  			<tr>
  				<td style="background-color:#66cdaa" width="120">이름</td>
  				<td>
  					<input type="text" name="name" class="form-control" style="width:120px;"
  					required="required" value="<%=dto.getName()%>">
  				</td>
  			</tr>
  			<tr>
  				<td style="background-color:#66cdaa" width="120">사진</td>
  				<td>
  					<input type="file" name="uploadImage" class="form-control" style="width:250px;"
  					>
  				</td>
  			</tr>
  			<tr>
  				<td style="background-color:#66cdaa" width="120">핸드폰</td>
  				<td>
  					<input type="text" name="hp" class="form-control" style="width:200px;"
  					required="required" value="<%=dto.getHp()%>">
  				</td>
  			</tr>
  			<tr>
  			
  			</tr>
  				<td colspan="2" align="center">
  					<button type="submit" class="btn btn-success" style="width:150px;"
  					id="btnGaip" onclick="funcsuccess()">회원정보 수정</button>
  					
  				</td>
  		</table>
  	</form>
  </div>
  
  <script>

  function funcsuccess(){
		alert("회원정보가 수정되었습니다.");
		
		
	}
  </script>
</body>
</html>