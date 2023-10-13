<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle:wght@300&family=Gamja+Flower&family=Nanum+Pen+Script&family=Noto+Serif+KR:wght@200&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>

<c:if test="${total==0 }">
   <div class="alert alert-success">
      존재하는 회원이 없습니다.
   </div>
</c:if>
   
<c:if test="${total>0 }">
   <div class="alert alert-success">
      총 ${total }명의 회원이 존재합니다.
   </div>
</c:if>
<br><br>
   <button type="button" class="btn btn-info btn-sm" onclick="location.href='writeform'">글쓰기</button>
   
<hr>
<table class="table table-bordered" style="width: 800px;">
   <tr>
      <th>번호</th>
      <th>이름</th>
      <th>사진</th>
      <th>운전면허</th>
      <th>주소</th>
      <th>작성일</th>
      <th>편집</th>
   </tr>
   <tr>
      <c:forEach var="dto" items="${list }" varStatus="i">
         <tr>
            <td align="center">${i.count}</td>
            <td>${dto.name }</td>
            <td>
            	<c:if test="${dto.photo!=null }">
            		<img alt="" src="../photo/${dto.photo }" width="50" height="50" class="img-circle">
            	</c:if>
            	
            	<c:if test="${dto.photo==null }">
            		<img alt="" src="../photo/이미지없음.png" width="50" height="50" class="img-circle">
            	</c:if>
            </td>
            <td>${dto.driver }</td>
         <td>${dto.addr }</td>
         <td><fmt:formatDate value="${dto.gaipday }" pattern="yyyy-MM-dd"/> </td>
         <td>
         	<button type="button" class="btn btn-outline-info btn-sm" 
         	onclick="location.href='uform?num=${dto.num}'">수정</button>
         	<button type="button" class="btn btn-outline-danger btn-sm" 
         	onclick="location.href='delete?num=${dto.num}'">삭제</button>
         </td>
         </tr>
         
      </c:forEach>
   </tr>
</table>

</body>
</html>