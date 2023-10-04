<%@page import="java.util.List"%>
<%@page import="data.dao.PopularSearchesDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link href="https://fonts.googleapis.com/css2?family=Dongle:wght@300&family=Nanum+Pen+Script&family=Noto+Serif+KR:wght@200&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<style>
	@import url(//fonts.googleapis.com/earlyaccess/jejugothic.css);

	@font-face {
    	font-family: 'OAGothic-ExtraBold';
    	src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2302@1.0/OAGothic-ExtraBold.woff2') format('woff2');
    	font-style: normal;
	}

	#shape{
		margin: 40px 20px 40px 20px;
		background-color: #EEEEEE;
		padding: 15px 15px 15px 15px;
	}
	div.subject,span.pspan{
		cursor: pointer;
	}
	div.list,div.select,button.btn-success{
		display: none;
	}
	div.ptop{
		font-size: 1.3em;
		margin-bottom: 12px;
	}
	@import url(//fonts.googleapis.com/earlyaccess/jejugothic.css);

	body * { 
		font-family: 'Jeju Gothic', sans-serif;
	}
</style>
<script>
	$(function(){
		
		$(subjectDivs[0]).click(function(){
			showList(0);
			console.log("�۵���");
		});
		$(subjectDivs[1]).click(function(){
			showList(1);
		});
		$(subjectDivs[2]).click(function(){
			showList(2);
		});
		$(subjectDivs[3]).click(function(){
			showList(3);
		});
		$("i.pback").click(function(){
			hideList();
		});
		
		$(buttonDivs[0]).on("click",function(){
			var age_v=$("#age").val();
			var s="<ol>";
			$.ajax({
				type:"get",
				data:{"age":age_v},
				url:"search/ageListProc.jsp",
				dataType:"json",
				success:function(res){
					$.each(res, function(i,e){s+="<li>"+e+"</li>";});
					s+="</ol>";
					$(listDivs[0]).html(s);
				}
			});
			$("button.cancel").trigger("click");
		});
		$(buttonDivs[1]).on("click",function(){
			var mbti_v=$("#mbti").val();
			var s="<ol>";
			$.ajax({
				type:"get",
				data:{"mbti":mbti_v},
				url:"search/mbtiListProc.jsp",
				dataType:"json",
				success:function(res){
					$.each(res, function(i,e){s+="<li>"+e+"</li>";});
					s+="</ol>";
					$(listDivs[1]).html(s);
				}
			});
			$("button.cancel").trigger("click");
		});
		$(buttonDivs[2]).on("click",function(){
			var gender_v=$("#gender").val();
			var s="<ol>";
			$.ajax({
				type:"get",
				data:{"gender":gender_v},
				url:"search/genderListProc.jsp",
				dataType:"json",
				success:function(res){
					$.each(res, function(i,e){s+="<li>"+e+"</li>";});
					s+="</ol>";
					$(listDivs[2]).html(s);
				}
			});
			$("button.cancel").trigger("click");
		});
		$(buttonDivs[3]).on("click",function(){
			var gender_v=$("#gender").val();
			var s="<ol>";
			$.ajax({
				type:"get",
				data:{"gender":gender_v},
				url:"search/areaListProc.jsp",
				dataType:"json",
				success:function(res){
				    $.each(res, function(i,e){s+="<li>"+e+"</li>";});
					s+="</ol>";
					$(listDivs[3]).html(s);
				}
			});
			$("button.cancel").trigger("click");
		});
	});
	
	var subjectDivs = document.getElementsByClassName("subject");
	
	var listDivs = document.getElementsByClassName("list");
	var selectDivs = document.getElementsByClassName("select");
	var buttonDivs = document.getElementsByClassName("attrsubmit");
	var currentlyDisplayedList = null;
	var currentlyDisplayedSelect = null;
	var currentlyDisplayedButton = null;
	
	function showList(index) {
	
		// Hide the currently displayed list
		if (currentlyDisplayedList !== null) {
		currentlyDisplayedList.style.display = "none";
		}
		if (currentlyDisplayedList !== null) {
		currentlyDisplayedSelect.style.display = "none";
		}
		if (currentlyDisplayedList !== null) {
		currentlyDisplayedButton.style.display = "none";
		}
			  
		// Show the selected list
		listDivs[index].style.display = "block";
		currentlyDisplayedList = listDivs[index];
		selectDivs[index].style.display = "block";
		currentlyDisplayedSelect = selectDivs[index];
		buttonDivs[index].style.display = "block";
		currentlyDisplayedButton = buttonDivs[index];
		
		$("button.modalopen").trigger("click");
	}
	
	function hideList() {
		currentlyDisplayedList.style.display = "none";
		currentlyDisplayedSelect.style.display = "none";
		currentlyDisplayedButton.style.display = "none";
	}
</script>
<body>
	<div id="shape">
		<div class="ptop"><b>�α� �˻���</b><span class="pspan" style="float: right"><i class="bi bi-backspace-fill pback"></i></span></div>
		<div class="subject">
			<span class="cat" style="font-weight: 200; color: #9E9E9E;">���̴뺰</span>
		</div>
		<div class="list">
		�ȳ��ϼ���
		</div>
		<div class="subject">
			<span class="cat" style="font-weight: 200; color: #9E9E9E;">mbti��</span>
		</div>
		<div class="list">
		2
		</div>
		<div class="subject">
			<span class="cat" style="font-weight: 200; color: #9E9E9E;">����</span>
		</div>
		<div class="list">
		3
		</div>
		<div class="subject">
			<span class="cat" style="font-weight: 200; color: #9E9E9E;">������</span>
		</div>
		<div class="list">
		4
		</div>
	</div>
	
	<div class="container mt-3">
		<button type="button" class="btn btn-primary modalopen" data-bs-toggle="modal" data-bs-target="#myModal" style="visibility: hidden"></button>
	</div>
	<!-- The Modal -->
	<div class="modal" id="myModal">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
			
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">�������ּ���~!</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>
				
				<!-- Modal body -->
				<div class="modal-body">
					<div class="select">
						<select id="age">
							<option value="10" selected>10��</option>
							<option value="20">20��</option>
							<option value="30">30��</option>
							<option value="40">40��</option>
							<option value="50">50��</option>
							<option value="60">60�� �̻�</option>
						</select>
					</div>
					<div class="select">
						<select id="mbti1">
							<option value="e" selected>E</option>
							<option value="i">I</option>
						</select>
						<select id="mbti2">
							<option value="n" selected>N</option>
							<option value="s">S</option>
						</select>
						<select id="mbti3">
							<option value="t" selected>T</option>
							<option value="f">F</option>
						</select>
						<select id="mbti4">
							<option value="p" selected>P</option>
							<option value="j">J</option>
						</select>
					</div>
					<div class="select">
						<select id="gender">
							<option value="male" selected>��</option>
							<option value="female">��</option>
						</select>
					</div>
					<div class="select">
						<select id="area">
							<option value="����" selected>����Ư����</option>
							<option value="��õ">��õ������</option>
							<option value="���">��⵵</option>
							<option value="����">������</option>
							<option value="���">��û�ϵ�</option>
							<option value="�泲">��û����</option>
							<option value="����">���ֱ�����</option>
							<option value="����">����ϵ�</option>
							<option value="����">���󳲵�</option>
							<option value="�뱸">�뱸������</option>
							<option value="�λ�">�λ걤����</option>
							<option value="���">���ϵ�</option>
							<option value="�泲">��󳲵�</option>
							<option value="����">���ֵ�</option>
						</select>
					</div>
				</div>
				
				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-success attrsubmit" id="ageBtn">����</button>
					<button type="button" class="btn btn-success attrsubmit" id="mbtiBtn">����</button>
					<button type="button" class="btn btn-success attrsubmit" id="genderBtn">����</button>
					<button type="button" class="btn btn-success attrsubmit" id="areaBtn">����</button>
					<button type="button" class="btn btn-danger cancel" data-bs-dismiss="modal">���</button>
				</div>
			
			</div>
		</div>
	</div>
</body>
</html>