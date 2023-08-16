<%@page import="javax.swing.ImageIcon"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="javax.lang.model.util.SimpleAnnotationValueVisitor14"%>
<%@page import="member.model.MemberDTO"%>
<%@page import="java.util.Vector"%>
<%@page import="member.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle:wght@300&family=Gamja+Flower&family=Nanum+Pen+Script&family=Noto+Serif+KR:wght@200&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<script>
function funcdel(num){
	//alert(num);
	/* $("#btnmdel").attr("num",num); */
	$("#myModal").modal();
	
	$("#btnmdel").click(function(){
		//버튼에 있는 num값 읽어오기
		//var num=$(this).attr("num");
		
		//이동
		location.href="deleteMember.jsp?num="+num;
	})
}


</script>
<style>
.pdesign{
	border-radius:100px;
	width:150px;
	height:150px;
}

</style>
<%
MemberDAO dao=new MemberDAO();
Vector<MemberDTO> list=dao.getAllData();
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
String loginok=(String)session.getAttribute("loginok");
String id=(String)session.getAttribute("idok");
%>


</head>
<body>
<form >
<%
	if(loginok!=null){%>
		<button type="button" class="btn btn-outline-danger" onclick="location.href='logoutAction.jsp'">로그아웃</button>
	<% }else{%>
	<button type="button" class="btn btn-info" onclick="location.href='loginMain.jsp'">로그인</button>
	<% }
%>

	
	<br>
	<b>총 <%=list.size() %>명의 멤버가 있습니다.</b>
	<table class="table table-bordered">
		<tr>
			<th>번호</th>
			<th>ID</th>
			<th>PASSWORD</th>
			<th>회원명</th>
			<th>핸드폰</th>
			<th>가입일</th>
			<th>편집</th>
		</tr>
		<%
		for(int i=0;i<list.size();i++){
			MemberDTO dto=list.get(i);
			%>
			<tr>
			<td><%=i+1 %></td>
			<td><%=dto.getId() %></td>
			<td><%=dto.getPass() %></td>
			<td><img src="../<%=dto.getImage() %>" class="pdesign"><br>
			<div style="margin-left:50px"><%=dto.getName() %></div></td>
			<td><%=dto.getHp() %></td>
			<td><%=sdf.format(dto.getGaip()) %></td>
			<td>
			
			<%
			  /*  로그인한 본인꺼만 수정/삭제 보이도록  */

			  /* 로그인한 본인꺼만 나오도록  */
			  if(loginok!=null && dto.getId().equals(id)) {%>
				  <input type="button" value="수정" class="btn btn-warning" onclick="location.href='updateForm.jsp?num=<%=dto.getNum()%>'">
				  <input type="button" value="삭제" class="btn btn-danger" onclick="funcdel(<%=dto.getNum()%>)">
							</td>
							</tr>
			  <% }else{%>
			  
			<h5>권한 없음</h5>
			
		<%}
		
		}%>
		</td>
		</tr>
	</table>
	
	<!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">회원탈퇴</h4>
        </div>
        <div class="modal-body">
          <p>회원탈퇴를 원하시면 [탈퇴확인]을 눌러주세요</p>
          <button type="button" class="btn btn-danger" id="btnmdel" num="">탈퇴확인</button> 
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>

</form>
</body>
</html>