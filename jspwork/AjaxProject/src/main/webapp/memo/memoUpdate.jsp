<%@page import="db.memo.MemoDto"%>
<%@page import="db.memo.MemoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String unum=request.getParameter("unum");
	String uwriter=request.getParameter("uwriter");
	String ustory=request.getParameter("ustory");
	String uavata=request.getParameter("uavata");
	
	MemoDto dto=new MemoDto();
	dto.setNum(unum);
	dto.setWriter(uwriter);
	dto.setStory(ustory);
	dto.setAvata(uavata);
	
	MemoDao dao=new MemoDao();
	dao.updateMemo(dto);
%>