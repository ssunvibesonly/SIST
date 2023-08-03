<%@page import="model.myteam.TeamDto"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.myteam.TeamDao"%>
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
<script type="text/javascript">
function funcdel(num){
	var yes=confirm("삭제하시겠습니까?")
	
	if(yes){
		location.href='teamdelete.jsp?num='+num;
	}else
		location.href='list.jsp';
		
}


</script>
<%

	TeamDao dao=new TeamDao();
	ArrayList<TeamDto> list=dao.getAllMyTeams();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
%>
</head>
<body>
	<a href="addForm.jsp">팀원추가</a>
	<br>
	<table class="table table-bordered" style="width: 800px">
		<tr align="center">
		<th width="60">번호</th>
		<th width="120">이름</th>
		<th width="100">운전면허</th>
		<th width="260">주소</th>
		<th width="160">작성일</th>
		<th width="120">수정|삭제</th>
		
		</tr>
		
		<%
			for(int i=0;i<list.size();i++)
			{
				TeamDto dto=list.get(i);//i번지의 dto꺼낸다.
			%>			
				<tr>
				<td align="center"><%=i+1 %></td>
				<td align="center"><%=dto.getName() %></td>
				<td align="center"><%=dto.getDriver() %></td>
				<td><%=dto.getAddr() %></td>
				<td><%=sdf.format(dto.getWriteday()) %></td> <!-- sdf.format으로 감싸주면 내가 지정한 날짜 형식에 맞춰서 출력된다. -->
				<td>
					<button type="button" class="btn btn-warning btn-sm"
					onclick="location.href='updateForm.jsp?num=<%=dto.getNum()%>'">수정</button>

					<button type="button" class="btn btn-danger btn-sm"
					onclick="funcdel(<%=dto.getNum()%>)">삭제</button>
					
				</td>
				
				
				</tr>
			<%} %>
		
		
</table>
</body>
</html>