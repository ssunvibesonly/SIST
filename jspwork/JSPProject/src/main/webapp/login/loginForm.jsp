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
<style type="text/css">
	div.loginform{
		width:500px;
		margin-top:100px;
		margin-left:200px;
	}
</style>
</head>
<body>
<%
	//세션으로부터 아이디와 세이브체크값 얻기(get set하는 곳의 순서가 있는게 아니라 loginAction에서 set한거 필요한곳에 get하면 된다.)
	String myid=(String)session.getAttribute("idok");
	String saveid=(String)session.getAttribute("saveok");
	
	boolean save=true;
	
	if(saveid==null){
		myid=""; //아이디 저장을 체크하지 않을 경우 아이디 없앤다.
		save=false; //체크하지 않을 경우 false,그 이외에는 초기값이 true니까 true가 된다.
		
	}
	
%>
  <div class="loginform">
  	<form action="loginAction.jsp" method="post">
  		<input type="text" name="id" style="width:200px;"
  		class="form-control" placeholder="로그인 아이디" required="required" value=<%=myid %>><br>
  		<input type="password" name="pass" style="width:200px" class="form-control" placeholder="로그인 비밀번호" required="required"><br>
  		<label><input type="checkbox" name="savecheck" <%=save?"checked":"" %>>아이디 저장</label><br><br> <!-- //value값이 없으면 null이나 on으로 나옴 -->
  		<button type="submit" class="btn btn-success btn-lg"
  		style="width:200px;">로그인</button>
  	</form>
  </div>
</body>
</html>