<%@page import="db.quiz.QuizBoardDao"%>
<%@page import="db.quiz.QuizBoardDto"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
<%
	String realpath=getServletContext().getRealPath("/imgfolder");

	int filesize=1024*1024*5; //약 5mb
	
	MultipartRequest multi=null;
	multi=new MultipartRequest(request,realpath,filesize,"utf-8",new DefaultFileRenamePolicy());
	System.out.println(realpath); //실제 경로 위치 나옴
	
	QuizBoardDao dao=new QuizBoardDao();
	
	QuizBoardDto dto=new QuizBoardDto();
	
	dto.setWriter(multi.getParameter("writer"));
	dto.setTitle(multi.getParameter("title"));
	dto.setContent(multi.getParameter("content"));
	
	String photo=multi.getFilesystemName("uploadfile");
	
	if(photo==null){
		dto.setImgname("../image/noimage.png");
		
	}else{
		
		dto.setImgname("../imgfolder/"+photo);
		
	}
	dao.insertQuiz(dto);
	
	response.sendRedirect("quizform.jsp");
	
	
	%>	

	
	

</body>
</html>