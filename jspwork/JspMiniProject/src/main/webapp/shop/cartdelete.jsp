<%@page import="data.dao.ShopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String idx=request.getParameter("idx");

String [] idxs=idx.split(",");

ShopDao dao=new ShopDao();

for(int i=0;i<idxs.length;i++){
	dao.deleteCart(idxs[i]);
	
}


response.sendRedirect("../index.jsp?main=shop/mycart.jsp");
%>
