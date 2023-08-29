<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://fonts.googleapis.com/css2?family=Black+And+White+Picture&family=Cute+Font&family=Diphylleia&family=Dongle:wght@300&family=Hi+Melody&family=Nanum+Brush+Script&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>

<title>찐 테스트</title>
<style>
.swiper {
	width: 100%;
	height: 100%;
}

.swiper-slide {
	text-align: center;
	font-size: 18px;
	background: #fff;
	/* 요소 내부의 내용을 수직 중앙 정렬하는 스타일 설정 */
	display: flex; /* 표준 방식 */
	/* 요소 내용을 수직으로 중앙 정렬 */
	justify-content: center; /* 수평 가운데 정렬 */
	/* 요소 내용을 수직으로 중앙 정렬 */
	align-items: center; /* 수직 가운데 정렬 */
}

.swiper-slide img {
	display: block;
	width: 60%;
	height: 60%;
	object-fit: cover;
}

.swiper-button-next {
	opacity: 0.1; /*투명도 조절 */
}

.swiper-button-prev {
	opacity: 0.1; /*투명도 조절 */
}

.video-wrap {
	position: relative;
}

.video-overlay {
	width: 100%; /* 요소의 너비를 부모 요소의 100%로 설정 */
	height: 100%; /* 요소의 높이를 부모 요소의 100%로 설정 */
	display: flex; /* 내부 요소들을 플렉스 박스로 배치 */
	flex-direction: column; /* 내부 요소들을 세로 방향으로 배치 */
	text-align: left; /* 내부 텍스트를 가운데 정렬 */
	color: white; /* 텍스트 색상을 흰색으로 설정 */
	
}

#videoname1 {
	font-size: 25pt;
	position: absolute;
	top: 300px;
	left: 150px;
}

#videoname2 {
	font-size: 13pt;
	position: absolute;
	top: 400px;
	left: 150px;
}

#moviechart1 {
	text-decoration: none;
	color: black;
	position: absolute;
	left: 70px;
}

#futuremovie1 {
	text-decoration: none;
	color: black;
	position: absolute;
	left: 350px;
}

#btnall {
	position: absolute;
	right: 100px;
}

.btnwrap {
	background-color: white; /* 배경 하얀색으로 변경 */
	display: flex; /* 내부 요소들을 플렉스 박스로 배치 */
	align-items: center; /* 요소들을 세로 축에서 가운데로 정렬 */
	height: 150px; /* div높이 정리*/
}

<!--
처음 가져오면 기본 버튼 없애줌 -->div.swiper-button-prev.swiper-button-disabled::after
	{
	display: none;
}
</style>
</head>
<%
//절대경로잡기
String root = request.getContextPath();

//기본페이지
String mainPage = "layout/main.jsp";

//url을 통해서 main값을 얻어 메인 페이지에 출력한다
if (request.getParameter("main") != null) {
	mainPage = request.getParameter("main");
}
%>
<body>
	<!-- 비디오  -->
	<div class="video-wrap">
		<div class="video-overlay">
			<strong class="videoname1" id="videoname1">오펜하이머</strong> <span
				class="videoname2" id="videoname2"> THE WORLD FOREVER CHANGES
				<br> 세상을 영원히 바꾸다 8월 15일 대개봉!
			</span>
		</div>
		<video autoplay muted>
			<source src="<%=root%>/image/opvideo2.mp4" type="video/mp4">
		</video>
	</div>

	<div class="movie chart wrap">
		<div class="content">
			<div class="btnwrap">
				<h3>
					<a href="#" id="moviechart1"><i
						class="bi bi-bar-chart-line-fill"></i>영화 순위</a>
				</h3>

				<h3>
					<a href="#" id="futuremovie1"><i class="bi bi-film"></i>상영 예정작</a>
				</h3>
				<button type="button" id="btnall" class="btn btn-outline-danger"
					name="btnall" onclick="location.href=''">전체보기</button>
			</div>

			<!-- Swiper -->
			<div class="swiper mySwiper">
				<div class="swiper-wrapper">

					<div class="swiper-slide">
						<%
						for (int i = 1; i <= 10; i++) {
						%>
						<div class="1page container" align="center">
							<img src="<%=root%>/image/movie<%=i%>.jpeg"><br>
							<h3 class="block"><%=i%>.영화제목
							</h3>
							<h6>좋아요 99%&nbsp;예매율56%</h6>
						</div>
						<%
						if (i % 5 == 0) {
						%>
					</div>
					<div class="swiper-slide">
						<%
						}
						}
						%>

					</div>
					<div class="swiper-button-next">
						<img src="<%=root%>/image/rightarrow.png"
							style="width: 100px; height: 100px;">
					</div>
					<div class="swiper-button-prev">
						<img src="<%=root%>/image/leftarrow.png"
							style="width: 100px; height: 100px;">
					</div>

				</div>
			</div>

		</div>
	</div>

	<!-- 이벤트 -->
	<div class="event"></div>

	<script
		src="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.js"></script>

	<!-- Initialize Swiper -->
	<script>
		var swiper = new Swiper(".mySwiper", {
			spaceBetween : 30,
			centeredSlides : true,

			pagination : {
				el : ".swiper-pagination",
				clickable : true,
			},
			navigation : {
				nextEl : ".swiper-button-next",
				prevEl : ".swiper-button-prev",
			},
		});
	</script>
</body>
</html>