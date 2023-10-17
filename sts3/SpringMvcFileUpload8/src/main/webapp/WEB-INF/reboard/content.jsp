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
<div style="margin: 100px 100px;">
	<table class="table table-bordered" style="width: 600px;">
		<caption align="top"><b>내용 보기</b></caption>
		<tr>
			<td>
				<h2>${dto.subject }</h2>
				<span style="float: right; margin-right: 20px;">
				조회:${dto.readcount }&nbsp;&nbsp;&nbsp;
				<fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd HH:mm"/></span>
				<br>
				<h5><b>작성자: ${dto.writer }</b></h5>
			</td>
		</tr>
		
		<tr>
			<td>
				<pre>${dto.content }</pre>
				<br><br>
				<c:if test="${dto.photo!='no' }">
					<c:forTokens var="pho" items="${dto.photo }" delims=","> <!-- 사진이 여러개 들어갔을때 jstl에서 split 처럼 사용하는 것(forTokens) -->
						<a href="../upload/${pho }"><img alt="" src="../upload/${pho }" style="width: 150px; height: 150px;"></a>
						<!-- img를 원래 크기대로 보고싶다면 a태그로 감싸고 href에 경로를 적어주면 된다. -->
					</c:forTokens>
				</c:if>
			</td>
		</tr>
		
		<tr>
			<td align="right">
				<button class="btn btn-outline-success" type="button"
				onclick="location.href='writeform'">글쓰기</button>
				<button class="btn btn-outline-success" type="button"
				onclick="location.href='writeform?num=${dto.num}&regroup=${dto.regroup }&restep=${dto.restep }&relevel=${dto.relevel }&currentPage=${currentPage }'">
				답글</button>
				<button class="btn btn-outline-success" type="button"
				onclick="location.href='updatepassfom?num=${dto.num}&currentPage=${currentPage }'">수정</button>
				<button class="btn btn-outline-success" type="button"
				onclick="location.href='deletepassform?num=${dto.num}&currentPage=${currentPage }'">삭제</button>
				<button class="btn btn-outline-success" type="button"
				onclick="location.href='list?currentPage=${currentPage}'">목록</button>
			</td>
		</tr>
	</table>
</div>
</body>
</html>