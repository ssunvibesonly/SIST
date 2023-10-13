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
<body>
<h3>ex2번 예제</h3>
<button type="button" id="btn2" class="btn btn-success">list json 데이터 출력2</button>
<div id="box">
<script type="text/javascript">
	$("#btn2").click(function(){
		
		$.ajax({
			type:"get",
			dataType:"json",
			url:"list2",
			success:function(res){
				$("#box").empty();
				$("#box").append("상품명: "+res.sang+"<br>");
				$("#box").append("색상: "+res.color +"<br>");
				$("#box").append("가격: "+res.price +"<br>");
				
			}
			
		})
	})


	</script>
	</div>
</body>
</html>