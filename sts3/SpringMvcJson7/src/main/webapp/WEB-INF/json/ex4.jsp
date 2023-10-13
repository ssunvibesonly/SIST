<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
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
	$(function(){
		
		$("#search").keydown(function(key){
			if(key.keyCode==13){
				
				var name=$(this).val();
				//alert(name);
				
				$.ajax({
					type:"get",
					dataType:"json",
					url:"list4",
					data:{"mname":name}, //"mname은 list4에서 넘겨주는 파라메터값"
					success:(function(res){
						
						$("#mname").text(res.mname);
						$("#photo").attr("src","image/"+res.photo);
						$("#search").val('');
					})
					
				})
			}
			
		})
		
	})
</script>
<body>
<h3 class="alert alert-success">Ex4번 예제</h3>
<br>
<h4>미니언즈 이름을 입력 후 엔터를 쳐주세요</h4>
<input type="text" id="search" class="form-control" style="width:150px;">
<br><br>
<h2 id="mname"></h2>
<img alt="" src="" id="photo">
</body>
</html>