<%@page import="data.dto.SmartAnswerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="data.dao.SmartAnswerDao"/>
<jsp:useBean id="dto" class="data.dto.SmartAnswerDto"/>
<jsp:setProperty property="*" name="dto"/>
<%

	request.setCharacterEncoding("utf-8");
	dao.insertSmartAnswer(dto);

%>