<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Vector"%>
<%@page import="db.simpleguest.SimpleGuestDTO"%>
<%@page import="db.simpleguest.SimpleGuestDAO"%>
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
<script>
function funcdel(number){
	var y=confirm("삭제하시겠습니까?");
	if(y){
		location.href='deleteForm.jsp?num='+number;
		
	}else{
		alert("취소되었습니다.");
	}
	
}


</script>
<style>
#conbox{
	border:1px solid gray;
	float:right;
	width:550px;
	height:100px;
	
}

</style>
<%
	SimpleGuestDAO dao=new SimpleGuestDAO();
	Vector<SimpleGuestDTO> list=dao.getAllData();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

%>
<body>
<div style="margin:50px; 100px;">
<button type="button" onclick="location.href='insertForm.jsp'" class="btn btn-success"
style="margin-left:970px">글쓰기</button>
<br><br> 
<div align="center">
<form>
	
	<table class="table table-bordered" style="width:700px;">

		
		<%
		
		int num=list.size();
		if(num==0){%>
			<tr>
				<td style="text-align:center">저장된 방명록이 없습니다.</td>
			</tr>
		<% }else{
			for(int i=0;i<list.size();i++){
				SimpleGuestDTO dto=list.get(i);%>
				<tr>
				<td>No.<%=num %> | 작성자: <span><b><%=dto.getNick() %></b></span>&nbsp;&nbsp;
				<b>작성일:<%=sdf.format(dto.getWriteday())%></b>
				<br><br>
				<img src="../image/만화이미지/<%=dto.getImage() %>.png" style="width:100px">
				<div id="conbox">&nbsp;<%=dto.getStory()%></div></td>
				
			</tr>
			
			<tr  style="float:right; border: 1px solid white">
			<td><button type="button" class="btn btn-warning" id="btn1" class="btn"
			onclick="location.href='updateForm.jsp?num=<%=dto.getNum() %>'">수정</button>
			<button type="button" class="btn btn-danger" id="btn2" class="btn" 
			onclick="funcdel(<%=dto.getNum()%>)">
			삭제</button></td>
			</tr>
			
			<% 
			num--;
			}
			
		}%>

		
	</table>
</form>
</div>
</div>
</body>
</html>