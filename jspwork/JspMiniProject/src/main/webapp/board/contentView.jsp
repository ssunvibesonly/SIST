<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dto.SmartDto"%>
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
span.day{color:gray}

</style>
</head>
<body>
<jsp:useBean id="dao" class="data.dao.SmartDao"/>
</body>
<%
String num=request.getParameter("num");
String currentPage=request.getParameter("currentPage");
dao.updateReadCount(num);

SmartDto dto=dao.getData(num);
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");

%>
<div style="margin:30px 30px; width:500px;">
	<table class="table table-bordered">
		<caption align="top">
			<b><h2><%=dto.getSubject() %></h2></b>
		</caption>
		<tr>
			<td>
				<b>작성자: <%=dto.getWriter() %></b><br>
				<span class="day"><%=sdf.format(dto.getWriteday()) %>
				&nbsp;&nbsp;조회: <%=dto.getReadcount() %></span>
			</td>
		</tr>
		<tr height="150">
			<td>
				<%=dto.getContent() %>
			</td>
		</tr>
		<tr align="right">
		<td>
			<button type="button" class="btn btn-outline-success"
			onclick="location.href='index.jsp?main=board/smartform.jsp'">글쓰기</button>
			<button type="button" class="btn btn-outline-success"
			onclick="location.href='index.jsp?main=board/boardlist.jsp?currentPage=<%=currentPage%>'">목록</button>
			<button type="button" class="btn btn-outline-success"
			onclick="location.href='index.jsp?main=board/updateform.jsp?num=<%=num%>'">수정</button>
			<button type="button" class="btn btn-outline-success"
			onclick="location.href='#'">삭제</button>
		</td>
		</tr>
	</table>

</div>
</html>