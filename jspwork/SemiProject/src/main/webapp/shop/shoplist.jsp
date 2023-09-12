<%@page import="java.text.NumberFormat"%>
<%@page import="Dto.ShopDto"%>
<%@page import="java.util.List"%>
<%@page import="Dao.ShopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle:wght@300&family=Gamja+Flower&family=Nanum+Pen+Script&family=Noto+Serif+KR:wght@200&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<%
ShopDao dao=new ShopDao();
List<ShopDto> list=dao.getAllData();

%>

<style>
.indexcolor{
color: white;
}


</style>
<body>
<div class="container mt-3">
  <hr style="border: 5px solid white;">
  <h2 style="color: white;">스토어</h2>
  <hr style="border: 5px solid white;">
  <br>
  <!-- Nav pills -->
  <ul class="nav nav-pills" role="tablist">
    <li class="nav-item">
      <a class="nav-link active" data-bs-toggle="pill" href="#home">전체보기</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-bs-toggle="pill" href="#menu1">패키지</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-bs-toggle="pill" href="#menu2">팝콘</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-bs-toggle="pill" href="#menu3">음료</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-bs-toggle="pill" href="#menu4">콤보</a>
    </li>
  </ul>

  <!-- Tab panes -->
  <div class="tab-content">
    <div id="home" class="container tab-pane active"><br>
      <h3 class="indexcolor">전체 보기</h3>
      
		<div align="center">
			
				<% NumberFormat nf1=NumberFormat.getCurrencyInstance();
				for(int i=0;i<list.size();i++){
					ShopDto dto=list.get(i);
					%>
					
					<a shopnum=<%=dto.getShop_num() %> style="cursor: pointer;" class="detailpage"
					href="#"><div style="float: left;">
					<img src="shopimg/<%=dto.getShop_photo()%>" style="width:200px;height: 300px;"><br>
					<h4><%=dto.getShop_sangpum() %></h4>
					<h5><%=dto.getShop_detail() %></h5>
					<h6><%=nf1.format(dto.getShop_price()) %>원</h6>
					</div></a>
				<%
				if(i%4==0){
				%>
					
					<br>
				<%}
				
				}

				%>
		</div>
    </div>
    <div id="menu1" class="container tab-pane fade"><br>
      <h3 class="indexcolor">패키지</h3>
      <div align="center">
			
				<%NumberFormat nf2=NumberFormat.getCurrencyInstance();
				for(int i=0;i<list.size();i++){
					ShopDto dto=list.get(i);
					if(dto.getShop_category().equals("패키지")){%>
					
					<a shopnum=<%=dto.getShop_num() %> style="cursor: pointer;" class="detailpage"
					href="#"><div style="float: left;">
					<img src="shopimg/<%=dto.getShop_photo()%>" style="width:200px;height: 300px;"><br>
					<h4><%=dto.getShop_sangpum() %></h4>
					<h5><%=dto.getShop_detail() %></h5>
					<h6><%=nf2.format(dto.getShop_price()) %>원</h6>
					</div></a>

					<%}
				if(i%4==0){
				%>
					
					<br>
				<%}
				
				}

				%>
		</div>
    </div>
    <div id="menu2" class="container tab-pane fade"><br>
      <h3 class="indexcolor">팝콘</h3>
		<div align="center">
			
				<%NumberFormat nf3=NumberFormat.getCurrencyInstance();
				for(int i=0;i<list.size();i++){
					ShopDto dto=list.get(i);
					if(dto.getShop_category().equals("팝콘")){%>
					
					<a shopnum=<%=dto.getShop_num() %> style="cursor: pointer;" class="detailpage"
					href="#"><div style="float: left;">
					<img src="shopimg/<%=dto.getShop_photo()%>" style="width:200px;height: 300px;"><br>
					<h4><%=dto.getShop_sangpum() %></h4>
					<h5><%=dto.getShop_detail() %></h5>
					<h6><%=nf3.format(dto.getShop_price()) %>원</h6>
					</div></a>

					<%}
				if(i%4==0){
				%>
					
					<br>
				<%}
				
				}

				%>
		</div>    </div>
     <div id="menu3" class="container tab-pane fade"><br>
      <h3 class="indexcolor">음료</h3>
      <div align="center">
			
				<%NumberFormat nf4=NumberFormat.getCurrencyInstance();
				for(int i=0;i<list.size();i++){
					ShopDto dto=list.get(i);
					if(dto.getShop_category().equals("음료")){%>
					
					<a shopnum=<%=dto.getShop_num() %> style="cursor: pointer;" class="detailpage"
					href="#"><div style="float: left;">
					<img src="shopimg/<%=dto.getShop_photo()%>" style="width:200px;height: 300px;"><br>
					<h4><%=dto.getShop_sangpum() %></h4>
					<h5><%=dto.getShop_detail() %></h5>
					<h6><%=nf4.format(dto.getShop_price()) %>원</h6>
					</div></a>

					<%}
				if(i%4==0){
				%>
					
					<br>
				<%}
				
				}

				%>
		</div>
    </div>
     <div id="menu4" class="container tab-pane fade"><br>
      <h3 class="indexcolor">콤보</h3>
      <div align="center">
			
				<% NumberFormat nf=NumberFormat.getCurrencyInstance();
				for(int i=0;i<list.size();i++){
					ShopDto dto=list.get(i);
					if(dto.getShop_category().equals("콤보")){%>
					
					<a shopnum=<%=dto.getShop_num() %> style="cursor: pointer;" class="detailpage"
					href="#"><div style="float: left;">
					<img src="shopimg/<%=dto.getShop_photo()%>" style="width:200px;height: 300px;"><br>
					<h4><%=dto.getShop_sangpum() %></h4>
					<h5><%=dto.getShop_detail() %></h5>
					<h6><%=nf.format(dto.getShop_price()) %>원</h6>
					</div></a>

					<%}
				if(i%4==0){
				%>
					
					<br>
				<%}
				
				}

				%>
		</div>
    </div>
  </div>
</div>
</body>
</html>