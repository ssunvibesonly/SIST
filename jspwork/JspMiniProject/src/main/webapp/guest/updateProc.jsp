<%@page import="data.dao.guestDao"%>
<%@page import="data.dto.guestDto"%>
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
 //db에 저장할 아이디 얻기
 String myid=(String)session.getAttribute("myid");
	//실제경로
	String realPath=getServletContext().getRealPath("/save");
	System.out.println(realPath);
	
	int uploadsize=1024*1024*3;
	
	MultipartRequest multi=null;
	try{
		multi=new MultipartRequest(request,realPath,uploadsize,"utf-8",new DefaultFileRenamePolicy());
		

		//주의 request가 아닌 multi 변수로 모든 폼데이터를 읽어야 한다.
		String content=multi.getParameter("content");
		String photoname=multi.getFilesystemName("photo");
		
		//num
		String num=multi.getParameter("num");
		String currentPage=multi.getParameter("currentPage");
		
		//dao
			
		guestDao dao=new guestDao();
		
		//기존의 포토 가져오기
		String old_photo=dao.getData(num).getPhotoname();
		
		//dto에 저장
		guestDto dto=new guestDto();
		dto.setNum(num);
		dto.setMyid(myid);
		dto.setContent(content);
		dto.setPhotoname(photoname==null?old_photo:photoname);
		
		//dao
		
		dao.insertGuest(dto);
		
		//방명록 목록으로 이동
		response.sendRedirect("../index.jsp?main=guest/guestlist.jsp?currentPage="+currentPage);
		
	}catch(Exception e){
		e.printStackTrace();
		
	}
	
%>
</body>
</html>