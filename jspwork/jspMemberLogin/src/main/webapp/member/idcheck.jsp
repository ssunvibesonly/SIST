<%@page import="member.model.MemberDAO"%>
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
<%
	String key=request.getParameter("key");//처음 호출 시 null 이라고 생각하자! 큰 의미 x
	System.out.println("[ "+key+" ]");		//무언가 값을 보낼때는 key값을 얼마든지 줄 수 있다. addForm에 빈 내용들을 가지고 온다고 생각
											//key가 addForm태그에 없으므로 그냥 전체 가져온다고 생각
	if(key==null){
		//null일 경우에 폼을 나타낸다.
		%>
		<div style="margin:10px 30px">
			<form action="idcheck.jsp" method="post" class="form-inline">
				<b>아이디를 입력해주세요.</b><br>
				<input type="text" name="id" class="form-control" style="width:120px">
				 <input type="hidden" name="key" value="yes"><!-- value는 그냥 형식상 써주신 것이다. -->
				<button type="submit" class="btn btn-outline-info"
				style="margin-left:10px;">중복체크</button>
			</form>
		</div>
		
	<%}else{
		//action처리
		String id=request.getParameter("id");
		
		//dao에서 id존재 유무에 관한 메서드..
		MemberDAO dao=new MemberDAO();
		boolean b=dao.isIdCheck(id);
		
		if(b){
			//존재하는 경우
			%>
			<div style="margin: 10px 30px;">
			<h5><%=id %>는 이미 가입된 아이디 입니다.</h5>
			<img alt="" src="../image/avata/b6.png" width="60" align="left">
			<button type="button" class="btn btn-danger btn-xs"
			onclick="location.href='idcheck.jsp'">다시 입력</button>
 			</div>
			
		<%}else{
			//존재하지 않는 경우
			%>
			<div style="margin: 10px 30px;">
			<h5><%=id %>는 사용가능한 아이디입니다.</h5>
			<img alt="" src="../image/avata/b2.png" width="60" align="left">
			<button type="button" class="btn btn-success btn-xs"
			onclick="saveID('<%=id%>')">적용하기</button>
			<button type="button" class="btn btn-danger btn-xs"
			onclick="location.href='idcheck.jsp'">다시 입력</button>
 			</div>
			
		<%}
		
	}
%>
<script type="text/javascript">

function saveID(id){
	//alert(id); //아이디 제대로 넘어오는지 확인
	//부모창: opener
	//현재창의 아디를 부모창의 id에 나타내준다.
	//opener.mid.value =id; //id에 id를 줄시에는 폼아이디 없어도 가능
	//opener.mfrm.mid.value=id; form에 id가 있을 시 id는 name만으로도 가능
	opener.$("#mid").val(id); //제이쿼리로도 줄 수 있다.
	
	//현재창 닫기
	window.close();
	
	
}
</script>
</body>
</html>