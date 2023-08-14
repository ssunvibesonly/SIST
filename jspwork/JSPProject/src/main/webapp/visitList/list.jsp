<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.visitlist.visitListDAO"%>
<%@page import="model.visitlist.visitListDTO"%>
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
<%

 visitListDAO dao=new visitListDAO();
 Vector<visitListDTO> list=dao.selecVisit();
 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	visitListDTO a=new visitListDTO();
 
%>
<script>
function funcdel(num){
	var yes=confirm("삭제하시겠습니까?");
	if(yes){
		location.href="deleteForm.jsp?num="+num;
	}else{
		alert("취소되었습니다.");
		
	}
	
	
}

</script>
<body>
<form >
<button type="button" onclick="location.href='insertForm.jsp'">방명록 작성</button>
<table class="table table-bordered" style="width:500px">
	<%
	
	int num=list.size();
	if(num==0){%>
	<tr>
		<td>저장된 방명록이 없습니다.</td>
	</tr>

	<%}
		for(int i=0;i<list.size();i++){
		visitListDTO dto=list.get(i);
		%>
		
			<tr>
				<td>no.<%=i+1 %>&nbsp;&nbsp;작성자:<%=dto.getNick() %><span style="float:right">작성일:<%=sdf.format(dto.getWriteday()) %></span></td>
			
			</tr>
			<tr >
				<td>
				<img src='<%=dto.getImage() %>'>
				<div style="border:2px solid gray; width:300px; height:200px;float:right"><%=dto.getStory() %></div>
				</td>
			</tr>
			<tr>
			<td>
			<button type="button" class="btn btn-danger" onclick="funcdel(<%=dto.getNum()%>)">
			삭제</button>
			<button type="button" class="btn btn-warning" onclick="location.href='updateForm.jsp?num=<%=dto.getNum()%>'">수정</button></td>
			</tr>
		
		<%}
	%>

</table>


</form>
</body>
</html>