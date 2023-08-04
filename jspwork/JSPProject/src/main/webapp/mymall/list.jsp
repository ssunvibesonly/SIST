<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.mymall.MallDao"%>
<%@page import="model.mymall.MallDto"%>
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
<script>
		<!-- 사용자가 정의한 사용자 정의 함수는 window.onload나 $(function())안해줘도 된다 : 호출한거 따라가서 출력되므로-->
		function funcdel(no){
			
			var yes=confirm("삭제하시겠습니까?")
			if(yes){
				
				location.href="deleteMall.jsp?no="+no;
			}else
				location.href="list.jsp";
		}
			
			


</script>
<%

	MallDao dao=new MallDao();
	Vector<MallDto> list=dao.getAllData();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //시간,날짜 ()안의 형식대로 출력하게 해주는 클래스
	NumberFormat nf = NumberFormat.getCurrencyInstance();
%>
</head>
<body>
<div style="margin-left:300px">
	<br>
	<button type="button" onclick="location.href='addForm.jsp'"
	class='btn btn-warning' style="margin-left:950px" >상품추가로 이동</button>
	<br><br>
	<table class="table table-bordered" style="width:1100px;">
	<tr style="text-align:center; ">
		<th style="width:70px; background-color:lightgrey; border:2px solid gray">번호</th>
		<th  style="width:150px; background-color:lightgrey; border:2px solid gray">상품명</th>
		<th  style="width:300px; background-color:lightgrey; border:2px solid gray ">상품 사진</th>
		<th  style="width:150px; background-color:lightgrey; border:2px solid gray">금액</th>
		<th  style="width:150px; background-color:lightgrey; border:2px solid gray">입고일</th>
		<th style="width:150px; background-color:lightgrey; border:2px solid gray">작성일</th>
		<th style="background-color:lightgrey; border:2px solid gray"></th>
		</tr>
		
	<%
		
		for(int i=0;i<list.size();i++)
		{	MallDto dto=list.get(i);
		%>
			<tr style="text-align:center;">
			<td valign="middle"><%=i+1 %></td>
			<td valign="middle"><%=dto.getSang() %></td>
			<td valign="middle"><img style="width:150px; height:150px;"src="<%=dto.getPhoto() %>"></td>
			<td valign="middle"><%=nf.format(Integer.parseInt(dto.getPrice()))%></td>
			<td valign="middle"><%=dto.getIpgo()%></td>
			<td valign="middle"><%=sdf.format(dto.getWriteday()) %></td>
			<td valign="middle"><button type="button" class="btn btn-outline-info"
		style="width:100px" onclick="location.href='updateForm.jsp?no=<%=dto.getNo() %>'">수정</button><br>
		<button type="button" class="btn btn-outline-danger"
		style="width:100px" onclick="funcdel(<%=dto.getNo()%>)" id="btn1">삭제</button></td>
			</tr>
			
		<%}
	%>
	
	
	
	</table>
	</div>
</body>
</html>