<%@page import="java.text.SimpleDateFormat"%>
<%@page import="db.quiz.QuizBoardDao"%>
<%@page import="db.quiz.QuizBoardDto"%>
<%@page import="java.util.List"%>
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
QuizBoardDao dao=new QuizBoardDao();
List<QuizBoardDto>list=dao.getAllData();
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

%>
<body>

<table class="table table-bordered">
<tr>
<%
for(int i=1;i<=list.size();i++)
{ QuizBoardDto dto=list.get(i-1);%>


	<td>
	<img style="width:100px;" src="<%=dto.getImgname() %>" ><br>
	<span>작성자:<%=dto.getWriter() %></span><br>
	<span>작성일:<%=sdf.format(dto.getWriteday()) %></span>
	</td>
	
	<%
	if(i%3==0){
		%>
		</tr><tr>
	<%}
		
	
} 

%>
</tr>
</table>

</body>
</html>