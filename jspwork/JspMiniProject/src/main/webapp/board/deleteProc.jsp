<%@page import="java.io.File"%>
<%@page import="data.dao.guestDao"%>
<%@page import="data.dto.guestDto"%>
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
<%

//db뿐만 아니라 업로드된 파일도 지우기
String num=request.getParameter("num");
String currentPage=request.getParameter("currentPage");

//db로부터 저장된 이미지명 얻기
guestDao dao=new guestDao();
String photoname=dao.getData(num).getPhotoname();

//db삭제
dao.deleteGuest(num);

//파일삭제
String realPath=getServletContext().getRealPath("/save");

//파일객체 생성
File file=new File(realPath+"/"+photoname);

//파일 삭제
file.delete();

//보낸페이지로 이동
response.sendRedirect("../index.jsp?main=guest/guestlist.jsp?currentPage="+currentPage);

%>
<body>

</body>
</html>