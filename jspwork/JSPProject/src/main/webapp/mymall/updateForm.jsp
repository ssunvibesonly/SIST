<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.mymall.MallDto"%>
<%@page import="model.mymall.MallDao"%>
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
	String no=request.getParameter("no");
	MallDao dao=new MallDao();
	MallDto dto=dao.updateMall(no);
	

%>
<style type="text/css">
	#selphoto{
	left:500px;
	top:200px;
	border-radius:20px;
	width:200px;
	align:center;
	position:absolute;
	
	
	
	}

</style>

<script>
      $(function(){//select에 선택한 값이 변경될 때 마다 사진의 출력이 변경됨
         //select된 선택값 얻기
         var srcImg = $("#photo").val();
         //select에 넣기
         $("#selphoto").attr("src",srcImg);
         
         $("#photo").change(function(){
            var s = $(this).val();
            $("#selphoto").attr("src",s);
         })
      })
   </script>
</head>
<body>
<form action="updateAction.jsp" method="post">
<input type="hidden" name="num" value=<%=no %>>
<table class="table table-bordered" style="width:970px">
	
	<tr>
		<th  style="width:150px">상품명</th>
		<th  style="width:300px">상품 사진</th>
		<th  style="width:150px">금액</th>
		<th  style="width:150px">입고일</th>
		<th width="200px">작성일</th>
		</tr>
		
	<tr>
	<td>
	<input type="text" class="form-control" style="width:200px"  name="sang" value="<%=dto.getSang() %>"></td>
	<td>
	<select style="width:200px" name="photo" id="photo"> <!-- name은 파라메터값을 받기 위한 것, id=는 자바스크립트 -->
		<option value="../image/쇼핑몰사진/30.jpg" <%=dto.getPhoto() %>.equals("../image/쇼핑몰사진/30.jpg")?"selected":"";>헤어밴드</option>
		<option value="../image/쇼핑몰사진/26.jpg" <%=dto.getPhoto() %>.equals("../image/쇼핑몰사진/26.jpg")?"selected":"";>플라워 헤어집게</option>
		<option value="../image/쇼핑몰사진/10.jpg" <%=dto.getPhoto() %>.equals("../image/쇼핑몰사진/10.jpg")?"selected":"";>스카프</option>
		<option value="../image/쇼핑몰사진/27.jpg" <%=dto.getPhoto() %>.equals("../image/쇼핑몰사진/27.jpg")?"selected":"";>하늘색 투피스</option>
		<option value="../image/쇼핑몰사진/8.jpg" <%=dto.getPhoto() %>.equals("../image/쇼핑몰사진/8.jpg")?"selected":"";>회색 니트</option>
	</select></td>
	<td><input type="text" class="form-control" style="width:200px" name="price" value="<%=dto.getPrice() %>"></td>
	<td><input type="date" style="width:150px" name="ipgo" value="<%=dto.getIpgo() %>"></td>
	<td><%=dto.getWriteday()%></td>
	<tr>
	<td colspan="5" align="center">
	<button type="submit" class="btn btn-warning" onclick="location.href='list.jsp'">상품 수정</button></td>
	</tr>
		
</table>
</form>
	<img alt="" src=" " id="selphoto">
</body>
</html>