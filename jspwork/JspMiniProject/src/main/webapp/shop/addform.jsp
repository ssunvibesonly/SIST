<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
<body>
	<div class="inputform" style="width: 500px;">
		<form action="shop/addaction.jsp" method="post" enctype="multipart/form-data  ">
			<table class="table table-bordered">
				<caption align="top"><b>상품 등록</b></caption>
					<tr>
						<td style="width:150px;" class="table-success">
							<b>카테고리</b><br></td>
							<td>
							<select class="form-control" name="category" required="required" style="width:200px;">
								<option value="아우터">아우터</option>
								<option value="상의">상의</option>
								<option value="하의">하의</option>
								<option value="악세서리">악세서리</option>
								<option value="세트">세트</option>
							</select>
						</td>
					</tr>
					<tr>
						<td style="width:150px;" class="table-success"><b>상품명</b></td>
						<td><input type="text" name="sangpum" class="form-control" required="required"
						style="width:200px;" placeholder="상품명 입력"></td>
					</tr>
					<tr>
						<td style="width:200px;" class="table-success"><b>상품 이미지</b></td>
						<td><input type="file" name="photo" class="form-control" required="required"
						style="width:400px;"></td>
					</tr>
					<tr>
						<td style="width:230px;" class="table-success"><b>상품 가격</b></td>
						<td><input type="text" name="price" class="form-control" required="required"
						style="width:200px;" placeholder="상품 가격 입력"></td>
					</tr>
					<tr>
						<td style="width:230px;" class="table-success"><b>입고일</b></td>
						<td>
						<%
						//현재 날짜 구하기
						SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
						String day=sdf.format(new Date());
						%>
						
						<input type="date" name="ipgoday" class="form-control" required="required"
						value="<%=day %>" style="width:400px;"></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<button type="submit" class="btn btn-outline-success" style="width:100px;">상품 저장</button>
							<button type="button" class="btn btn-outline-success" style="width:100px;"
							onclick="location.href='index.jsp?main=shop/shoplist.jsp'">상품 목록</button>
						</td>
					</tr>
			</table>
			
		</form> <!-- multipart는 post로만 간다. -->
	</div>
</body>
</html>