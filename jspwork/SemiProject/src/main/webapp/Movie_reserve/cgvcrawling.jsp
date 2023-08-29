<%@page import="org.jsoup.nodes.Element"%>
<%@page import="org.jsoup.select.Elements"%>
<%@page import="org.jsoup.Jsoup"%>
<%@page import="org.jsoup.nodes.Document"%>
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

String URL="http://www.cgv.co.kr/ticket/";
Document doc=Jsoup.connect(URL).get();
System.out.println(doc);
//cgv연결

Elements elements=doc.select("div.ah_roll_area ul li");
//div안에 있는 ah_roll_area 클래스 안의 ul안의 li 데이터를 가져온다.

out.println(elements.size()+"개 가져옴<br>");
//몇개의 데이터가 가져와졌는지 출력

for(Element e:elements){
	out.println(e.text()+"<br>");
	//가져온 데이터 출력
}
%>

  

</body>
</html>