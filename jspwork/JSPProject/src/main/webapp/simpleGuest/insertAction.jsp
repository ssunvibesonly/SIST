<%@page import="db.simpleguest.SimpleGuestDAO"%>
<%@page import="db.simpleguest.SimpleGuestDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

/* request.setCharacterEncoding("utf-8");

String nick=request.getParameter("nick");
String pass=request.getParameter("pass");
String image=request.getParameter("image");
String story=request.getParameter("story");

SimpleGuestDTO dto=new SimpleGuestDTO();
dto.setNick(nick);
dto.setPass(pass);
dto.setImage(image);
dto.setStory(story);

SimpleGuestDAO dao=new SimpleGuestDAO();
dao.insertSimple(dto);

response.sendRedirect("guestList.jsp");
 */
 

%>

<!-- 자바 빈즈로 변경하려면? (단순하게 폼에 넣어주기만 할 때 사용한다. 삼항연산자와 같은 조건문이나 multi 들어갈 땐 따로 해줘야 한다)
	useBean은 new로 객체를 생성하는 것과 같다 / DTO에 있는 객체명이랑 태그에 있는 name명이 같아야 사용 가능 -->

<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="dao" class="db.simpleguest.SimpleGuestDAO"/>
<jsp:useBean id="dto" class="db.simpleguest.SimpleGuestDTO"/>

<jsp:setProperty property="*" name="dto"/>

<%

dao.insertSimple(dto);
//목록으로 이동
response.sendRedirect("guestList.jsp");
%>







