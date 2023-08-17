<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="model.commute.commuteDto"%>
<%@page import="model.memberSawon.memberAdminDao"%>
<%@page import="model.memberSawon.memberAdminDto"%>
<%@page import="model.commute.commuteDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");

request.setCharacterEncoding("utf-8");

commuteDao daocomm=new commuteDao();
commuteDto dtocomm=new commuteDto();

int num2=daocomm.getAllMax(id);
daocomm.updateComm(id, num2);
%>
