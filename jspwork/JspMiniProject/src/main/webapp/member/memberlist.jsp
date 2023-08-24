<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dao.MemberDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="data.dto.MemberDto"%>
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
<%
   //절대경로잡기
   String root = request.getContextPath();
%>
</head>
<%

MemberDao dao=new MemberDao();
List<MemberDto> list=dao.getAllMembers();
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
int no=1;

%>
<script>
function funcdel(num){
	var y=confirm("삭제하시겠습니까?")
	if(y){
		location.href='member/memberdelete.jsp?num='+num;
		alert("삭제되었습니다.")
	}
		
		else{
			alert("삭제가 취소 되었습니다.")
		}
	
}

</script>
<body>
<form>
	가입 회원은 총 <%=list.size() %>입니다.
	<table class="table table-bordered" style="width:1000px;">
		<caption align="top"><b>전체 회원 목록</b></caption>
		<tr>
		<th width="120">번호</th>
		<th width="120">이름</th>
		<th width="150">ID</th>
		<th width="200">HP</th>
		<th width="250">이메일</th>
		<th width="250">주소</th>
		<th width="350">가입일</th>
		<th width="150">삭제</th>
		
		<%
		
		for(MemberDto dto:list){%>
			<tr align="center">
				<td><%=no++ %></td>
				<td width="120"><%=dto.getName() %></td>
				<td width="120"><%=dto.getId() %></td>
				<td width="150"><%=dto.getHp() %></td>
				<td width="250"><%=dto.getEmail() %></td>
				<td width="350"><%=dto.getAddr() %></td>
				<td width="150"><%=sdf.format(dto.getGaipday()) %></td>
				<td>
				<button type="button" class="btn btn-danger" onclick="funcdel(<%=dto.getNum()%>)">강퇴</button>
				</td>
			
			</tr>
			
			
			
		
		<%//for(int i=0;i<list.size();i++){
			//MemberDto dto=list.get(i);%>
			<%-- <td width="50"><%=i+1 %></td>
			<td width="100"><%=dto.getName() %></td>
			<td width="120"><%=dto.getId() %></td>
			<td width="150"><%=dto.getHp() %></td>
			<td width="250"><%=dto.getEmail() %></td>
			<td width="350"><%=dto.getAddr() %></td>
			<td width="150"><%=sdf.format(dto.getGaipday()) %></td>
			<td>
			<button type="button" class="btn btn-warning">수정</button>
			<button type="button" class="ben ben-danger">삭제</button>
			</td> --%>
			
		<%}
		
		
		
		%>
		
		
		</tr>
	</table>


</form>



</body>
</html>