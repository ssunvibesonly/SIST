<%@page import="model.commute.commuteDao"%>
<%@page import="model.commute.commuteDto"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.memberSawon.memberAdminDto"%>
<%@page import="model.memberSawon.memberAdminDao"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String id = request.getParameter("id");
SimpleDateFormat sdfday=new SimpleDateFormat("yyyy-MM-dd");
SimpleDateFormat sdftime=new SimpleDateFormat("h:mm a");


memberAdminDao dao=new memberAdminDao();
memberAdminDto dto=dao.selectOne(id);


commuteDto dtocomm=new commuteDto();

dtocomm.setId2(id);
dtocomm.setPosition2(dto.getPosition());
dtocomm.setName2(dto.getName());
dtocomm.setDepartment2(dto.getDepartment());

commuteDao daocomm=new commuteDao();
daocomm.insertComm(dtocomm);

%>
