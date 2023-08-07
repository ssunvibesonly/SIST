<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.intro.IntroDao"%>
<%@page import="model.intro.IntroDto"%>
<%@page import="java.util.Vector"%>
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
<script type="text/javascript">
function funcdel(num){
	var yes=confirm("삭제하시겠습니까?")
	
	if(yes){
		location.href='deleteAction.jsp?num='+num;
	}else
		location.href='list_intro.jsp';
		
}


</script>

<%
	request.setCharacterEncoding("utf-8");


	IntroDao dao=new IntroDao();
	Vector<IntroDto> list=dao.getAllData();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	
	
%>
<body style="background-color:darkslategray;">

<h1 style="margin-left:100px;margin-top:50px;color:white;font-size:50pt;font-family:'Noto Serif KR'; font-weight:bold;">사용자 DB</h1>
<hr style="color:white; border:2px solid white">
<div style="margin-left:400px; margin-top:80px;">
<table class="table table-bordered" style="width:900px; text-align:center">

	<tr >
		<th>번호</th>
		<th>이름</th>
		<th>MBTI</th>
		<th>연락처</th>
		<th>주소</th>
		<th>가입일</th>
		<th>편집</th>
	</tr>
	
	<%
	for(int i=0;i<list.size();i++){
		IntroDto dto=list.get(i);
		 %>
		<tr>
			<td><%=i+1%></td>
			<td><a href='detailPage.jsp?num=<%=dto.getNum() %>'><%=dto.getName() %></a></td>
			<td><%=dto.getMbti() %></td>
			<td><%=dto.getHp() %></td>
			<td><%=dto.getCity()%></td>
			<td><%=sdf.format(dto.getGaip()) %></td>
			<td><button type="button" name="btn1" class="btn btn-outline-warning"
			onclick="location.href='updateForm.jsp?num=<%=dto.getNum()%>'">수정</button>
			<button type="button" class="btn btn-danger btn-sm"
					onclick="funcdel(<%=dto.getNum()%>)">삭제</button>
		</tr>	
		
		
	<%}%>
	
</table>
<button type="button" class="btn btn-success" onclick="location.href='insertForm.jsp'"
style="margin-left:765px;">
		프로필 등록</button>
</div>
</body>
</html>