<%@page import="data.dao.SearchDao"%>
<%@page import="data.dao.SearchDao_v2"%>
<%@page import="data.dto.SearchResult"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Dongle:wght@300&family=Nanum+Pen+Script&family=Noto+Serif+KR:wght@200&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%-- <%
	//String inputWords=(request.getParameter("inputWords")==null?"":request.getParameter("inputWords"));
	String inputWords="�����غ�";
	%>
	<div class="box-menu">
		<ul class="box-menu">
			<li id="tabView0">��ü</li>
			<li id="tabView1">������</li>
			<li id="tabView2">����</li>
			<li id="tabView3">�ڽ�</li>
		</ul>
	</div>
	<br><hr width="900">
	<div style="width: 900px;"><i class="bi bi-grip-vertical" style="margin-right: 10px;margin-left: 20px"></i><i class="bi bi-grip-horizontal"></i>
		<ul class="sort-menu" style="float: right;margin-right: 40px">
			<li>���õ���</li>
			<li>�ֽż�</li>
			<li>�α��</li>
		</ul></div><br><hr width="900">
	<%
	SearchDao searchDao=new SearchDao();
	List<SearchResult> list=searchDao.searchAllTablesColumns(inputWords);
	
	for(int i=0;i<list.size();i++)
	{
		SearchResult result=list.get(i);
	%>
		<div>
			<img width="50" height="50" src="<%=result.getColumn().equals("photo")?result.getValue():"" %>">
		</div>
		<div>
			<span>
				<%=result.getValue() %>
			</span>
		</div>
	<%}
	%> --%>
	
	<%
	String inputWords=(request.getParameter("inputWords")==null?"":request.getParameter("inputWords"));
	%>
	<div class="container mt-3">
		<!-- Nav tabs -->
		<ul class="nav nav-tabs" role="tablist">
			<li class="nav-item">
				<a class="nav-link active" data-bs-toggle="tab" href="#tabsAll">��ü</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" data-bs-toggle="tab" href="#tabsTourSpot">������</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" data-bs-toggle="tab" href="#tabsMyCourse">�������ڽ�</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" data-bs-toggle="tab" href="#tabsRecomCourse">��õ�ڽ�</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" data-bs-toggle="tab" href="#tabsReview">����</a>
			</li>
		</ul>
		
		<!-- Tab panes -->
		<div class="tab-content">
			<div id="tabsAll" class="container tab-pane active"><br>
				<nav class="navbar navbar-expand-sm bg-light navbar-light">
					<div class="container-fluid">
						<div class="collapse navbar-collapse justify-content-between" id="collapsibleNavbar">
							<ul class="navbar-nav">
								<li class="nav-item">
									<a class="nav-link" href="#"><i class="bi bi-three-dots-vertical"></i></a>
								</li>
								<li class="nav-item">
									<a class="nav-link" href="#"><i class="bi bi-three-dots"></i></a>
								</li>
							</ul>
							<ul class="navbar-nav">
								<li class="nav-item">
									<a class="nav-link" href="#">���õ���</a>
								</li>
								<li class="nav-item">
									<a class="nav-link" href="#">�ֽż�</a>
								</li>
								<li class="nav-item">
									<a class="nav-link" href="#">�α��</a>
								</li>
							</ul>
						</div>
					</div>
				</nav>
			</div>
		</div>
		
		<div id="tabsTourSpot" class="container tab-pane fade"><br>
			<h3>Menu 1</h3>
			<p>������</p>
		</div>
		<div id="tabsMyCourse" class="container tab-pane fade"><br>
			<h3>Menu 2</h3>
			<p>�������ڽ�</p>
		</div>
		<div id="tabsRecomCourse" class="container tab-pane fade"><br>
			<h3>Menu 2</h3>
			<p>��õ�ڽ�</p>
		</div>
		<div id="tabsReview" class="container tab-pane fade"><br>
			<h3>Menu 2</h3>
			<p>����</p>
		</div>
	
	</div>
</body>
</html>