<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dto.SmartDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle:wght@300&family=Gamja+Flower&family=Nanum+Pen+Script&family=Noto+Serif+KR:wght@200&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
<style>
span.day{color:gray; font-size: 0.8em;}
img{max-width:300px;}
div.alist{margin-left: 20px;}
span.aday{color:gray; font-size: 0.8em;float: right;}
</style>
<script>
	$(function(){
		
		//시작할 때 리스트 호출
		list();
		
		var num=$("#num").val();
		//alert(num);
		
		//댓글부분 ajax insert
		$("#btnadd").click(function(){
			var nickname=$("#nickname").val().trim(); //trim() : 공백이 유효하게 해주는 메서드 
			var content=$("#content").val().trim();
			
			if(nickname.trim().length==0){
				swal ( "No!" ,  "닉네임을 꼭 써주세요!" ,  "error" );
				return;
			}
			if(content.trim().length==0){
				swal ( "잠깐!" ,  "댓글 내용을 꼭 써주세요!" ,  "error" );
				return;
			}
			
			$.ajax({
				type:"get",
				url:"board/insertanswer.jsp",
				dataType:"html",
				data:{"num":num,"nickname":nickname,"content":content},
				success:function(){
					//기존 입력값 지우기
					$("#nickname").val(" ");
					$("#content").val(" ");
					
					list();
				},
				statusCode:{
					404:function(){
						alert("json파일을 찾을 수 없어요")
					},
					500:function(){
						alert("서버오류..코드 다시 보기! ")
					}
				}
				
			})
		})
	})

	function list() {
		console.log("list num="+$("#num").val());
		
		$.ajax({
			type:"get",
			url:"board/listanswer.jsp",
			dataType:"json",
			data:{"num":$("#num").val()},
			success:function(res){
				//alert(res.length);
				//댓글 갯수 출력
				$("b.acount>span").text(res.length);
				
				//출력
				var s="";
				$.each(res,function(idx,item){
					s+="<div>"+item.nickname+":"+item.content;
					s+="<span class='aday'>"+item.writeday+"</span>"
					s+="<i idx="+item.idx+"class='bi bi-trash-fill adel'></i>"
					s+="</div>"
					
					
				})
				$("div.alist").html(s);
			}
			
		})
		
	}
</script>

</head>
<body>
<jsp:useBean id="dao" class="data.dao.SmartDao"/>
</body>
<%
String num=request.getParameter("num");
String currentPage=request.getParameter("currentPage");

dao.updateReadCount(num);

SmartDto dto=dao.getData(num);
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

%>
<div style="margin:30px 30px; width:500px;">
	<input type="hidden" id="num" value="<%=num%>">
	<table class="table table-bordered">
		<caption align="top">
			<b><h2><%=dto.getSubject() %></h2></b>
		</caption>
		<tr>
			<td>
				<b>작성자: <%=dto.getWriter() %></b><br>
				<span class="day"><%=sdf.format(dto.getWriteday()) %>
				&nbsp;&nbsp;조회: <%=dto.getReadcount() %></span>
			</td>
		</tr>
		<tr height="150">
			<td>
				<%=dto.getContent() %>
			</td>
		</tr>
		
		<!-- 댓글 -->
		<tr>
			<td>
				<b class="acount" id="alist">댓글<span>0</span></b>
				<div class="alist">
					댓글목록
				</div>
				<div class="aform input-group">
					<input type="text" id="nickname" class="form-control" style="width:130px;" placeholder="닉네임 입력">
					<input type="text" id="content" class="form-control" style="width:300px;" placeholder="댓글메세지">
					<button type="button" id="btnadd" class="btn btn-info">저장</button>
				</div>
			</td>
		</tr>
		
		
		<tr align="right">
		<td>
			<button type="button" class="btn btn-outline-success"
			onclick="location.href='index.jsp?main=board/smartform.jsp'">글쓰기</button>
			<button type="button" class="btn btn-outline-success"
			onclick="location.href='index.jsp?main=board/boardlist.jsp?currentPage=<%=currentPage%>'">목록</button>
			<button type="button" class="btn btn-outline-success"
			onclick="location.href='index.jsp?main=board/updateform.jsp?num=<%=num%>'">수정</button>
			<button type="button" class="btn btn-outline-success"
			onclick="funcdel(<%=num%>,<%=currentPage%>)">삭제</button>
		</td>
		</tr>
	</table>

</div>
<script>
function funcdel(num,currentPage){
	
	/* alert(num);
	alert(currentPage); */
	
	var a=confirm("삭제하려면 [확인]을 눌러주세요");
	
	if(a){
		location.href="board/deleteaction.jsp?num="+num+"&currentPage="+currentPage
		
	}
	
}

</script>


</html>