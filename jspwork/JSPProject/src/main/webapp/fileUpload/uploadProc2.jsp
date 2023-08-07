<%@page import="java.util.Enumeration"%>
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
	//톰캣에 업로드 된 프로젝트 경로 구하기
	ServletContext context=getServletContext();
	//프로젝트의 upload의 실제경로구하기
	String realFolder=context.getRealPath("/upload");
	
	System.out.println(realFolder);
	
	//업로드 시 허용되는 크기지정
	int uploadsize=1024*1024*3;//3mb
	
	MultipartRequest multi=null;
	
	try{
		multi=new MultipartRequest(request,realFolder,uploadsize,"utf-8",new DefaultFileRenamePolicy());
		
		//입력값 읽기
		String nick=multi.getParameter("nick");
		%>
		
		<h2>작성자명: <%=nick %></h2>
		
		<%
		//파일타입이 여러개인 경우
		Enumeration forNames=multi.getFileNames(); //file타입만 얻어옴
	
		while(forNames.hasMoreElements())
		{
			
			String fileName=(String)forNames.nextElement(); //오류가 뜨면 왼쪽에 있는 자료형과 형을 맞춰주면 된다.
			System.out.println("file type의 name: "+fileName);
			
			//실제업로드된 파일명 얻기
			String uploadName=multi.getFilesystemName(fileName);
			
			//파일선택 안하면 null
			if(uploadName!=null){%>
			<figure>
			<img alt="" src="../upload/<%=uploadName %>" style="max-width:200px;" border="1">
			<figcaption><b><%=uploadName %></b></figcaption>
			</figure>	
				
			<%}
		}
		%>
	<%}catch(Exception e){
		
		
	}
	
	
%>
</body>
</html>