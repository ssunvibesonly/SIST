<%@page import="javax.swing.ImageIcon"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="javax.lang.model.util.SimpleAnnotationValueVisitor14"%>
<%@page import="member.model.MemberDTO"%>
<%@page import="java.util.Vector"%>
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
<style>
.pdesign{
	border-radius:100px;
	width:150px;
	height:150px;
}

</style>
<%
MemberDAO dao=new MemberDAO();
Vector<MemberDTO> list=dao.getAllData();
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
ImageIcon a=new ImageIcon("photo");

%>


</head>
<body>
<form >
	<button type="button" onclick="location.href='addForm.jsp'"
	class="btn btn-info">로그인 화면</button>
	
	<table class="table table-bordered">
		<tr>
			<th>번호</th>
			<th>ID</th>
			<th>PASSWORD</th>
			<th>회원명</th>
			<th>핸드폰</th>
			<th>가입일</th>
			<th>편집</th>
		</tr>
		<%
		for(int i=0;i<list.size();i++){
			MemberDTO dto=list.get(i);
			%>
			<tr>
			<td><%=i+1 %></td>
			<td><%=dto.getId() %></td>
			<td><%=dto.getPass() %></td>
			<td><img src="../<%=dto.getImage() %>" class="pdesign"><br>
			<div style="margin-left:50px"><%=dto.getName() %></div></td>
			<td><%=dto.getHp() %></td>
			<td><%=sdf.format(dto.getGaip()) %></td>
			<td>
			<input type="button" value="수정" class="btn btn-warning"
			onclick="funcmod('<%=dto.getNum()%>')">
			<input type="button" value="삭제" class="btn btn-danger"
			onclick="funcdel('<%=dto.getNum()%>')">
			</td>
			</tr>
			
		<%}
		
		%>
		
		
	</table>

</form>
</body>
</html>