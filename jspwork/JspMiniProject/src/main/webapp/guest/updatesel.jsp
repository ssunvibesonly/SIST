<%@page import="org.json.simple.JSONObject"%>
<%@page import="com.mysql.cj.xdevapi.JsonArray"%>
<%@page import="data.dao.AnswerDao"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.List"%>
<%@page import="data.dto.AnswerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

request.setCharacterEncoding("utf-8");

String idx=request.getParameter("idx");
String content=request.getParameter("content");

AnswerDao dao=new AnswerDao();
dao.updateAns(idx, content);

%>
