<%@page import="member.model.MemberDTO"%>
<%@page import="member.model.MemberDAO"%>
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
	
	String realPath=getServletContext().getRealPath("/upload");
	int uploadSize=1024*1024*3;
	
	MultipartRequest multi=null;
	multi=new MultipartRequest(request,realPath,uploadSize,"utf-8",new DefaultFileRenamePolicy());
	String num=multi.getParameter("num");
	//dao선언
	MemberDAO dao=new MemberDAO();
	
	//dto
	MemberDTO dto=new MemberDTO();
	//MemberDTO ima=dao.getDta(num);
	
	dto.setNum(num);
	dto.setId(multi.getParameter("id"));
	dto.setPass(multi.getParameter("pass"));
	dto.setName(multi.getParameter("name"));
	dto.setHp(multi.getParameter("hp"));
	
	
	//dto.setImage(multi.getFilesystemName("uploadImage"))
	String photo=multi.getFilesystemName("uploadImage");
	System.out.println(photo);
	
	if(photo==null){
		//dto.setImage("upload/"+ima.getImage()); //사진이 없는 경우
		String p=dao.getDta(dto.getNum()).getImage();
		dto.setImage(p);
		
	}else{
		dto.setImage("upload/"+photo);
	}
		

	//db에 insert
	dao.updateMember(dto);
	
	//성공 후 이동
	response.sendRedirect("memberList.jsp");
%>
</body>
</html>