<%@page import="db.ajaxboard.ajaxBoardDto"%>
<%@page import="db.ajaxboard.ajaxBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String unum=request.getParameter("unum");
	String uwriter=request.getParameter("uwriter");
	String usubject=request.getParameter("usubject");
	String ustory=request.getParameter("ustory");
	String uavata=request.getParameter("uavata");
	
	ajaxBoardDto dto=new ajaxBoardDto();
	dto.setNum(unum);
	dto.setWriter(uwriter);
	dto.setSubject(usubject);
	dto.setStory(ustory);
	dto.setAvata(uavata);

	ajaxBoardDao dao=new ajaxBoardDao();
	dao.updateBoard(dto);
	
	
%>