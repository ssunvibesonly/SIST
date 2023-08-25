<%@page import="data.dao.MemberDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dto.guestDto"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.guestDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle:wght@300&family=Gamja+Flower&family=Nanum+Pen+Script&family=Noto+Serif+KR:wght@200&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
	span.day{
	
	float:right;
	font-size:11pt;
	color:gray;
	}

</style>
<title>Insert title here</title>
</head>
<%
//로그인 상태 확인 후 입력폼을 나타낼것_회원만 보이게
String loginok=(String)session.getAttribute("loginok");

guestDao dao=new guestDao();

int totalCount=dao.getToalCount(); //전체 갯수
int totalPage; //총 페이지 수
int startPage; //각 블럭에서 보여질 시작 페이지
int endPage; //각 블럭에서 보여질 끝 페이지
int startNum; //db에서 가져올 글의 시작 번호 (mysql은 첫글이 0, oracle은 첫글이 1)
int perPage=3; //한 페이지당 보여질 글의 갯수
int perBlock=5; //한 블럭당 보여질 페이지 갯수
int currentPage; //현재 페이지
int no; //각 페이지당 출력할 시작 번호

//현재 페이지 읽기(단 null일 경우는 1페이지로 준다) 
if(request.getParameter("currentPage")==null)
      	currentPage=1;
else
         currentPage=Integer.parseInt(request.getParameter("currentPage")); //파라미터로 받을 땐 무조건 문자열이라 parsing / 계산을 해야하므로 int로 형변환해줌
   
  //총 페이지수 구하기
  //총 글의 갯수/한 페이지당 보여질 갯수로 나눔(7/5=1)
  //나머지가 1이라도 있으면 무조건 +1페이지(1+1=2페이지가 필요)
	totalPage=totalCount/perPage+(totalCount%perPage==0?0:1);

  //각 블럭당 보여야 할 시작페이지
  //perBlock=5일 경우는 현재페이지 1~5 시작:1 끝:5
  //현재페이지 13 시작:11 끝:15
	startPage=(currentPage-1)/perBlock*perBlock+1;
   
	endPage=startPage+perBlock-1;
  
   //총 페이지가 23일 경우 마지막 블럭은 25가 아니라 23이다
    if(endPage>totalPage)
      	endPage=totalPage;
	
   //각 페이지에서 보여질 시작 번호
   //1페이지: 0, 2페이지:5, 3페이지:10...
   startNum=(currentPage-1)*perPage;
   
   //각 페이지 필요한 게시글 가져오기
   
   List<guestDto> list=dao.getList(startNum, perPage);
   SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
   
   //마지막 페이지 남은 한개글 지우면 빈페이지만 남는다.(해결책)이전페이지로 간다.
   if(list.size()==0&&currentPage!=1){
	   %>
	   <script type="text/javascript">
	   location.href='index.jsp?main=guest/guestlist.jsp?currentPage='+<%=currentPage-1%>;
	   </script>

   <%
   }
%>
<body>
<%
if(loginok!=null){%>
	
	<jsp:include page="addform.jsp"/>
	<hr align="left" width="700">
<%}

%>
<b>총 <%=totalCount %>개의 글이 있습니다.</b>

<%
	MemberDao mdao=new MemberDao();
	for(guestDto dto:list){
		
		//이름얻기
		String name=mdao.getName(dto.getMyid());%>
		
		<table class="table" style="width:600px;">
			<tr>
				<td>
				 <i class="bi bi-person-check"></i><%=name %>(<%=dto.getMyid() %>)
				
			
			
			<%
			//로그인한 아이디
			String myid=(String)session.getAttribute("myid");
			
			//로그인한 아이디와 글쓴아이디가 같을 경우에만 수정, 삭제 보여야 한다.
			if(loginok!=null && dto.getMyid().equals(myid)){%>
				<a href="index.jsp?main=guest/updateform.jsp?num=<%=dto.getNum() %>&currentPage=<%=currentPage%>" style="color:black;"><i class="bi bi-pencil-square"></i>수정</a>
				<a onclick="funcdel(<%=dto.getNum() %>)" style="color:black;"><i class="bi bi-trash"></i>삭제</a>
				<script>
				function funcdel(num){
					var y=confirm("삭제하시겠습니까?")
					if(y){
						location.href='guest/deleteProc.jsp?num='+num+'&currentPage='+<%=currentPage%>;
					}else{
						alert("취소되었습니다.")
					}
				}
				
				</script>
				
			<%}
			%>
			<span><%=sdf.format(dto.getWriteday()) %></span>
			</td>
			</tr>
			<tr height="120">
				<td>
					<!-- 이미지가 null이 아닌 경우만 출력 -->
					<%
					 if(dto.getPhotoname()!=null){%>
					 	<a href="save/<%=dto.getPhotoname()%>" target="_blank"> <!-- 클릭 시 사진 크게 -->
						<img src="save/<%=dto.getPhotoname()%>" align="left" style="width:100px;"hspace="20" ></a>
					 <%}
					%>
					
					<%=dto.getContent().replace("\n", "<br>")%> <!-- 이걸 안해주면 content 내의 내용이 한줄로 쭈우웅ㄱ 나온다. -->
				</td>
			</tr>
			
			<!-- 댓글 추천 -->
			<tr>
			  <td>
			  	<span class="answer" style="cursor:pointer;" num=<%=dto.getNum() %>>댓글0</span>
			  	<span class="likes" style="margin-left:20px; cursor:pointer;" num=<%=dto.getNum() %>>추천</span>
			  	<span class="chu"><%=dto.getChu() %></span>
			  </td>
			</tr>
		</table>
	<%}%>
	<!-- 페이지 번호 출력 -->

	<div align="center">
		<ul class="pagination justify-content-center">
		  <%
		  //이전
		  if(startPage>1){
			  %>
			 		<li>
		  				<a class="page-link" href="index.jsp?main=guest/guestlist.jsp?currentPage=<%=startPage-1 %>">이전</a>
		  			</li>
			 
		  <%}
		  	for(int pp=startPage;pp<=endPage;pp++){
		  		if(pp==currentPage){
		  			%>
		  			<li class="page-item active">
		  				<a class="page-link" href="index.jsp?main=guest/guestlist.jsp?currentPage=<%=pp %>"><%=pp %></a>
		  			</li>
		  			
		  		<%}else
		  		{%>
		  			<li>
		  				<a class="page-link" href="index.jsp?main=guest/guestlist.jsp?currentPage=<%=pp %>"><%=pp %></a>
		  			</li>
		  		<%}
		  	}
		  	//다음
		  	if(endPage<totalPage){%>
		  		<li>
					<a class="page-link" href="index.jsp?main=guest/guestlist.jsp?currentPage=<%=endPage+1 %>">다음</a>
				</li>
		  	<%}
		  	
		  	%>
		  
		  
		
		
		</ul>
	</div>



</body>
</html>