<%@page import="db.simpleguest.SimpleGuestDAO"%>
<%@page import="db.simpleguest.SimpleGuestDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

request.setCharacterEncoding("utf-8");

String num=request.getParameter("num");
String nick=request.getParameter("nick");
String pass=request.getParameter("pass");
String image=request.getParameter("image");
String story=request.getParameter("story");




SimpleGuestDAO dao=new SimpleGuestDAO();

//비밀번호가 맞으면 수정...수정 후 목록으로 이동
if(dao.isEqualPass(num, pass)){
	SimpleGuestDTO dto=new SimpleGuestDTO();
	
	dto.setNum(num);
	dto.setNick(nick);
	dto.setPass(pass);
	dto.setImage(image);
	dto.setStory(story);
	
	dao.updateGuest(dto);
	
	response.sendRedirect("guestList.jsp");
}else{//틀리면 자바 스크립트로 경고 후 이전 화면으로 이동
	%>
	<script>
		alert("비밀번호가 틀렸습니다.");
		history.back(); //이전페이지로 돌아간다.
	</script>
	
	
<%}
%>
<%-- 
<!-- 자바 빈즈로 변경하려면? (단순하게 폼에 넣어주기만 할 때 사용한다. 삼항연산자와 같은 조건문이나 multi 들어갈 땐 따로 해줘야 한다)
	useBean은 new로 객체를 생성하는 것과 같다 -->

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







 --%>