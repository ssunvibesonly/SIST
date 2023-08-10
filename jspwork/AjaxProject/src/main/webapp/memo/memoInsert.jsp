<%@page import="db.memo.MemoDto"%>
<%@page import="db.memo.MemoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemoDao dao=new MemoDao();
	
	//insert할 때 엔코딩해줘야함
	request.setCharacterEncoding("utf-8");
	
	//데이터 읽기(writer,story,avata)
	String writer=request.getParameter("writer");
	String story=request.getParameter("story");
	String avata=request.getParameter("avata");
	
	MemoDto dto=new MemoDto();
	dto.setWriter(writer);
	dto.setStory(story);
	dto.setAvata(avata);
	
	//insert호출
	dao.insertMemo(dto);
	
%>