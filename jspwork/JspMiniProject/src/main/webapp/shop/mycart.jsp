<%@page import="data.dao.MemberDao"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.HashMap"%>
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
<title>Insert title here</title>
<style>
div.sangpum{
	cursor: pointer;
	
}
div.sangpum>img{
	width:50px;
	height:70px;
	border: 1px solid gray;
	
}
i.del{cursor: pointer;}

</style>
</head>

<%
  //로그인 id 
  String id=(String)session.getAttribute("myid");
  ShopDao dao=new ShopDao();
  
  //장바구니 목록
  List<HashMap<String, String>> list=dao.getCartList(id);
  NumberFormat nf=NumberFormat.getCurrencyInstance();
  
  MemberDao mdao=new MemberDao();
  
  String name=mdao.getName(id);
  
	//총금액을 위한 초기값
		int allmoney=0;

%>
<body>
<h4 class="alert alert-warning"><%=name %>님의 장바구니 목록</h4>
<table class="table table-bordered" style="width:1000px;">
	<tr>
		<th style="width:30px;"><input type="checkbox" id="allcheck"></th>
		<th style="width:200px;">상품정보</th>
		<th style="width:200px;">상품명</th>
		<th style="width:200px;">사진</th>
		<th style="width:200px;">가격</th>
		<th style="width:200px;">총 금액</th>
		<th style="width:200px;">갯수</th>
		<th style="width:200px;">장바구니 추가일</th>
	</tr>
	<%
	for(int i=0;i<list.size();i++){
		HashMap<String,String> map=list.get(i);
		
		//사진 
		String photo=map.get("photo");
		
		
		//갯수 형변환
		int cnt=Integer.parseInt(map.get("cnt"));
		//가격 형변환
		int price=Integer.parseInt(map.get("price"));
		
		
		%>
		<tr>
			<td>
				<input type="checkbox" idx="<%=map.get("idx") %>" class="idx">
			</td>
			<td>
				<%=map.get("name") %>
			</td>
			<td>
				<%=map.get("sangpum") %>
			</td>
			<td>
				<div class="sangpum" shopnum="<%= map.get("shopnum") %>">
				<img alt="" src="shopsave/<%=photo %>" style="width:200px;height: 200px;">
				
				</div>
			</td>
			<td>
				<%=nf.format(price) %>
			</td>
			<td>
				<%
					price*=cnt;
					allmoney+=price;
					
				%>
				<i class="bi bi-trash3 del" idx="<%=map.get("idx")%>"></i><%=nf.format(price) %>
			</td>
			<td>
				<%=cnt %>개
			</td>
			<td>
				<%=map.get("cartday") %>
			</td>
		</tr>
		
		
		
	<%}
	%>
	<tr>
		<td colspan="8">
			<button type="button" class="btn btn-danger" id="btncartdel">선택상품 삭제</button>
			<span style="font-size: 2em;float: right;">
			총 주문금액: <b style="color:green;"><%=nf.format(allmoney) %>원</b>
			</span>
		</td>
		</tr>
</table>

<script>
//전체 선택시 체크박스 선택 해제
$("#allcheck").click(function(){
	
	var chk=$(this).is(":checked");
	console.log(chk);
	
	//전체 체크값을 글 앞의 체크에 일괄 전달
	$(".idx").prop("checked",chk); //prop 값을 전달하는 메서드 
	
});

//상품 클릭시 디테일로
$("div.sangpum").click(function(){
	
	var shopnum=$(this).attr("shopnum");
	location.href="index.jsp?main=shop/detailPage.jsp?shopnum="+shopnum;
})
$("#btncartdel").click(function(){
	
	//체크한 갯수
	var cnt=$(".idx:checked").length;
	
	//인덱스 번호 넘기기
	//var idx=$(".idx:checked").attr("idx");
	//alert(idx);
	
	if(cnt==0){
		
		alert("삭제할 상품을 선택해주세요")
		
		return;
	}else{
		
		var a=confirm(cnt+"개의 글을 삭제하려면 [확인]을 눌러주세요");
		
		if(a){
			
			//체크된 곳의 value값 얻기(num)
			var idx="";
			$(".idx:checked").each(function(i){
				
				idx+=$(this).attr("idx")+",";
			//
			alert(idx);
			})
			
			//마지막 컴마를 제거하기
			idx=idx.substring(0,idx.length-1);
			
			console.log(idx);
			
			//삭제파일로 전송
			location.href="shop/cartdelete.jsp?idx="+idx;
			
		}
	}
	
})

</script>
</body>
</html>