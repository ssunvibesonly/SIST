<%@page import="java.text.NumberFormat"%>
<%@page import="data.dto.ShopDto"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.ShopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle:wght@300&family=Gamja+Flower&family=Nanum+Pen+Script&family=Noto+Serif+KR:wght@200&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>

<script>
$(function(){
	
	//이미지 누르면 shopnum 경고창으로 띄우기
	
	$("a.godetail").click(function(){
		
		var num=$(this).attr("shopnum");
		alert(num);
		
		location.href="index.jsp?main=shop/detailPage.jsp?shopnum="+num;
	})
	
})

</script>
</head>
<style>
img.photo{

width:200px;
height:230px;
border: 1px solid gray;
border-radius: 20px;
margin-bottom: 10px;
}

tr{
padding: 10px;
}

</style>
<%
ShopDao dao=new ShopDao();
List<ShopDto> list=dao.getAllData();
	
%>
<body>
<div class="container mt-3">
  <br>
  <!-- Nav tabs -->
  <ul class="nav nav-tabs" role="tablist">
    <li class="nav-item">
      <a class="nav-link active" data-bs-toggle="tab" href="#tabs-1">전체</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-bs-toggle="tab" href="#tabs-2">아우터</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-bs-toggle="tab" href="#tabs-3">상의</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-bs-toggle="tab" href="#tabs-4">하의</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-bs-toggle="tab" href="#tabs-5">악세서리</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-bs-toggle="tab" href="#tabs-6">세트</a>
    </li>
  </ul>

  <!-- Tab panes -->
  <div class="tab-content">
    <div id="tabs-1" class="container tab-pane active"><br>
      <p>
      	<table class="table table-bordered" style="width: 700px;">
      		<caption align="top"><b>전체 상품 목록</b></caption>
      		<tr>
      			<%
      			NumberFormat nf=NumberFormat.getCurrencyInstance();
      			int i=0;
      			for(ShopDto dto:list){
      				String photo=dto.getPhoto();
      				
      				//할인율 20%~50% 랜덤 할인율
      				int sale=(int)(Math.random()*31)+20;
      				%>
      				<td>
      					<a shopnum="<%=dto.getShopnum() %>" style="cursor: pointer;" class="godetail">
      					<img alt="" src="shopsave/<%=photo%>" class="photo"></a>
      					
      					<br>
      					<%=dto.getSangpum() %><br>
      					<b style="color: red;font-size: 1.2em;"><%=sale %>%</b>
      					<span style="float: right;">
      						<div style="color: gray;font-size: 13px;"> 
      							<%
      							int price=(int)(dto.getPrice()-(dto.getPrice()*(sale/100.0)));
      							%>
      							<strike><%=nf.format(dto.getPrice()) %></strike>
      						</div>
      						<div style="color: black; font-size: 16px;">
      							<%=nf.format(price) %>
      						</div>
      					</span>
      				</td>

      				<%
      				if((i+1)%4==0){
      					%>
      					</tr>

      					<% 
      				}
      				i++;
      				%>
      			
      			<%}
      			%>
      		</tr>
      	</table>
      </p>
    </div>
    <div id="tabs-2" class="container tab-pane"><br>
      <p>
      	<table class="table table-bordered" style="width: 200px;">
      		<caption align="top"><b>아우터</b></caption>
      		<tr>
      			<%
      			NumberFormat nf1=NumberFormat.getCurrencyInstance();
      			int i1=0;
      			for(ShopDto dto:list){
      				String photo=dto.getPhoto();
      				
      				if(dto.getCategory().equals("아우터"))
      				{

      				//할인율 20%~50% 랜덤 할인율
      				int sale=(int)(Math.random()*31)+20;
      				%>
      				<td>
      					<a shopnum="<%=dto.getShopnum() %>" style="cursor: pointer;" class="godetail">
      					<img alt="" src="shopsave/<%=photo%>" class="photo"></a>
      					<br>
      					<%=dto.getSangpum() %><br>
      					<b style="color: red;font-size: 1.2em;"><%=sale %>%</b>
      					<span style="float: right;">
      						<div style="color: gray;font-size: 13px;"> 
      							<%
      							int price=(int)(dto.getPrice()-(dto.getPrice()*(sale/100.0)));
      							%>
      							<strike><%=nf1.format(dto.getPrice()) %></strike>
      						</div>
      						<div style="color: black; font-size: 16px;">
      							<%=nf1.format(price) %>
      						</div>
      					</span>
      				</td>

      				<%
      				if((i1+1)%4==0){
      					%>
      					</tr>

      					<% 
      				}
      				i++;
      				%>
      			
      			<%}
      			}
      			%>
      		</tr>
      	</table>
      </p>
    </div>
    <div id="tabs-3" class="container tab-pane"><br>
      <p>
      	      	<table class="table table-bordered" style="width: 400px;">
      		<caption align="top"><b>상의</b></caption>
      		<tr>
      			<%
      			NumberFormat nf2=NumberFormat.getCurrencyInstance();
      			int i2=0;
      			for(ShopDto dto:list){
      				String photo=dto.getPhoto();
      				
      				if(dto.getCategory().equals("상의"))
      				{

      				//할인율 20%~50% 랜덤 할인율
      				int sale=(int)(Math.random()*31)+20;
      				%>
      				<td>
      					<a shopnum="<%=dto.getShopnum() %>" style="cursor: pointer;" class="godetail">
      					<img alt="" src="shopsave/<%=photo%>" class="photo"></a>
      					<br>
      					<%=dto.getSangpum() %><br>
      					<b style="color: red;font-size: 1.2em;"><%=sale %>%</b>
      					<span style="float: right;">
      						<div style="color: gray;font-size: 13px;"> 
      							<%
      							int price=(int)(dto.getPrice()-(dto.getPrice()*(sale/100.0)));
      							%>
      							<strike><%=nf2.format(dto.getPrice()) %></strike>
      						</div>
      						<div style="color: black; font-size: 16px;">
      							<%=nf2.format(price) %>
      						</div>
      					</span>
      				</td>

      				<%
      				if((i2+1)%4==0){
      					%>
      					</tr>

      					<% 
      				}
      				i++;
      				%>
      			
      			<%}
      			}
      			%>
      		</tr>
      	</table>
      </p>
    </div>
    <div id="tabs-4" class="container tab-pane"><br>
      <p>
      	      	<table class="table table-bordered" style="width: 200px;">
      		<caption align="top"><b>하의</b></caption>
      		<tr>
      			<%
      			NumberFormat nf3=NumberFormat.getCurrencyInstance();
      			int i3=0;
      			for(ShopDto dto:list){
      				String photo=dto.getPhoto();
      				
      				if(dto.getCategory().equals("하의"))
      				{
      					
      				
      				
      				//할인율 20%~50% 랜덤 할인율
      				int sale=(int)(Math.random()*31)+20;
      				%>
      				<td>
      					<a shopnum="<%=dto.getShopnum() %>" style="cursor: pointer;" class="godetail">
      					<img alt="" src="shopsave/<%=photo%>" class="photo"></a>
      					<br>
      					<%=dto.getSangpum() %><br>
      					<b style="color: red;font-size: 1.2em;"><%=sale %>%</b>
      					<span style="float: right;">
      						<div style="color: gray;font-size: 13px;"> 
      							<%
      							int price=(int)(dto.getPrice()-(dto.getPrice()*(sale/100.0)));
      							%>
      							<strike><%=nf3.format(dto.getPrice()) %></strike>
      						</div>
      						<div style="color: black; font-size: 16px;">
      							<%=nf3.format(price) %>
      						</div>
      					</span>
      				</td>

      				<%
      				if((i3+1)%4==0){
      					%>
      					</tr>

      					<% 
      				}
      				i++;
      				%>
      			
      			<%}
      			}
      			%>
      		</tr>
      	</table>
      </p>
    </div>
    <div id="tabs-5" class="container tab-pane"><br>
      <p>
      	      	<table class="table table-bordered" style="width: 400px;">
      		<caption align="top"><b>악세서리</b></caption>
      		<tr>
      			<%
      			NumberFormat nf4=NumberFormat.getCurrencyInstance();
      			int i4=0;
      			for(ShopDto dto:list){
      				String photo=dto.getPhoto();
      				
      				if(dto.getCategory().equals("악세서리"))
      				{
      					
      				
      				
      				//할인율 20%~50% 랜덤 할인율
      				int sale=(int)(Math.random()*31)+20;
      				%>
      				<td>
      					<a shopnum="<%=dto.getShopnum() %>" style="cursor: pointer;" class="godetail">
      					<img alt="" src="shopsave/<%=photo%>" class="photo"></a>
      					<br>
      					<%=dto.getSangpum() %><br>
      					<b style="color: red;font-size: 1.2em;"><%=sale %>%</b>
      					<span style="float: right;">
      						<div style="color: gray;font-size: 13px;"> 
      							<%
      							int price=(int)(dto.getPrice()-(dto.getPrice()*(sale/100.0)));
      							%>
      							<strike><%=nf4.format(dto.getPrice()) %></strike>
      						</div>
      						<div style="color: black; font-size: 16px;">
      							<%=nf4.format(price) %>
      						</div>
      					</span>
      				</td>

      				<%
      				if((i4+1)%4==0){
      					%>
      					</tr>

      					<% 
      				}
      				i++;
      				%>
      			
      			<%}
      			}
      			%>
      		</tr>
      	</table>
      </p>
    </div>
    <div id="tabs-6" class="container tab-pane"><br>
      <p>
      	      	<table class="table table-bordered" style="width: 400px;">
      		<caption align="top"><b>세트</b></caption>
      		<tr>
      			<%
      			NumberFormat nf5=NumberFormat.getCurrencyInstance();
      			int i5=0;
      			for(ShopDto dto:list){
      				String photo=dto.getPhoto();
      				
      				if(dto.getCategory().equals("세트"))
      				{
      					
      				
      				
      				//할인율 20%~50% 랜덤 할인율
      				int sale=(int)(Math.random()*31)+20;
      				%>
      				<td>
      					<a shopnum="<%=dto.getShopnum() %> style="cursor: pointer;" class="godetail">
      					<img alt="" src="shopsave/<%=photo%>" class="photo"></a>
      					<br>
      					<%=dto.getSangpum() %><br>
      					<b style="color: red;font-size: 1.2em;"><%=sale %>%</b>
      					<span style="float: right;">
      						<div style="color: gray;font-size: 13px;"> 
      							<%
      							int price=(int)(dto.getPrice()-(dto.getPrice()*(sale/100.0)));
      							%>
      							<strike><%=nf5.format(dto.getPrice()) %></strike>
      						</div>
      						<div style="color: black; font-size: 16px;">
      							<%=nf5.format(price) %>
      						</div>
      					</span>
      				</td>

      				<%
      				if((i5+1)%4==0){
      					%>
      					</tr>

      					<% 
      				}
      				i++;
      				%>
      			
      			<%}
      			}
      			%>
      		</tr>
      	</table>
      </p>
    </div>
  </div>
</div>
</body>
</html>