<%@page import="java.text.SimpleDateFormat"%>
<%@page import="db.quiz.QuizBoardDao"%>
<%@page import="db.quiz.QuizBoardDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle:wght@300&family=Gamja+Flower&family=Nanum+Pen+Script&family=Noto+Serif+KR:wght@200&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
</head>
<body>

<%
QuizBoardDao dao=new QuizBoardDao();

int totalCount=dao.getTotalList();
int totalPage;
int startPage;
int endPage;
int startNum;
int perPage=5;
int perBlock=5;
int currentPage;
int no;

if(request.getParameter("currentPage")==null)
	currentPage=1;
else{
	currentPage=Integer.parseInt(request.getParameter("currentPage"));
}

totalPage=totalCount/perPage+(totalCount%perPage==0?0:1);
System.out.println(totalPage);

startPage=(currentPage-1)/perBlock*perBlock+1;

endPage=startPage+perBlock-1;

if(endPage>totalPage)
	endPage=totalPage;

System.out.println(endPage);

startNum=(currentPage-1)*perPage;

no=totalCount-(currentPage-1)*perPage;

List<QuizBoardDto> list=dao.getPagingList(startNum, perPage);
%>
<div>
<br>
<button type="button" onclick="location.href='quizform.jsp'" class="btn btn-warning">글쓰기</button>
<br><br>
<h4><b>작성된 게시글의 갯수는 <%=totalCount %>개 입니다.</b></h4>
<table class="table table-bordered">
	<tr>
	<th>번호</th>
	<th>작성자</th>
	<th>제목</th>
	<th>작성일</th>
	<th>조회수</th>
	</tr>
	<%
	if(list.size()==0)
	{%>
		<tr>
		<td><b>등록된 게시글이 없습니다.</b></td>
		</tr>
	<%}else{
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			for(int i=0;i<list.size();i++){
				QuizBoardDto dto=list.get(i);%>
				
				<tr>
				<td><%=no-- %></td>
				<td><%=dto.getWriter() %></td>
				<td><a href="contentView.jsp?num=<%=dto.getQ_num()%>"><%=dto.getTitle() %>&nbsp;&nbsp;&nbsp;<img src="<%=dto.getImgname() %>" width="50px"></a></td>
				<td><%=dto.getWriteday() %></td>
				<td><%=dto.getReadcount() %></td>
				</tr>
			<%}
	
		
		
	 }%>

</table>
<div>

<ul class="pagination justify-content-center">
	<%
	if(startPage>1){%>
		<li>
		<a href="quizlist.jsp?current<%=currentPage %>"><%=currentPage %></a>
		</li>
	<%}
	  	for(int pp=startPage;pp<=endPage;pp++){
	  		if(pp==currentPage){
	  			%>
	  			<li class="page-item active">
	  				<a class="page-link" href="quizlist.jsp?currentPage=<%=pp %>"><%=pp %></a>
	  			</li>
	  			
	  		<%}else
	  		{%>
	  			<li>
	  				<a class="page-link" href="quizlist.jsp?currentPage=<%=pp %>"><%=pp %></a>
	  			</li>
	  		<%}
	  	}
	  	//다음
	  	if(endPage<totalPage){%>
	  		<li>
				<a class="page-link" href="quizlist.jsp?currentPage=<%=endPage+1 %>">다음</a>
			</li>
	  	<%}
	  	
	  	%>
	


</ul>


</div>
</div>
<button type="button" onclick="location.href='quizimagelist.jsp'" class="btn btn-danger">이미지리스트</button>
</body>
</html>