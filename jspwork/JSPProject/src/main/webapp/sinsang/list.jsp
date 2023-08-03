<%@page import="model.sinsang.SinSangDto"%>
<%@page import="java.util.Vector"%>
<%@page import="model.sinsang.SinSangDao"%>
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

<%
	SinSangDao dao=new SinSangDao();
	Vector<SinSangDto> list=dao.getAllDatas();
	
%>
<body>
<button type="button" class="btn btn-info" onclick="location.href='insertForm.jsp'">데이터 추가</button>
<br>
<table class="table table-bordered" style="width:700px;">
	<tr class="table-info" style="text-align:center;">
	<th width="60">번호</th>
	<th width="100">이름</th>
	<th width="250">주소</th>
	<th width="250">날짜</th>
	<th width="150">편집</th>
	</tr>
	
	<%
	for(int i=0;i<list.size();i++){
		
		SinSangDto dto=list.get(i); //자료형이 SinSangDto
		%>
		<tr>
			<td><%=i+1 %></td>
			<td><%=dto.getName()%></td>
			<td><%=dto.getAddr()%></td>
			<td><%=dto.getSdate()%></td>
			<td><button type="button" class="btn btn-info btn-s"
			onclick="location.href='updateForm.jsp?num=<%=dto.getNum()%>'">수정</button><button type="button" class="btn btn-danger btn-s"
			onclick="location.href='delete.jsp?num=<%=dto.getNum()%>'">삭제</button></td> <!-- 페이지가 이어질 땐 ? -->
			
			
		</tr>
		
		
	<%}
	%>
</table>

</body>
</html>