<%@page import="db.memo.MemoDto"%>
<%@page import="db.memo.MemoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

 String num=request.getParameter("num");

 MemoDao dao=new MemoDao();
 
 dao.deleteMemo(num);

%>