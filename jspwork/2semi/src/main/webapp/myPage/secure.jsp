<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>����</title>
</head>
<style>
@import url(//fonts.googleapis.com/earlyaccess/jejugothic.css);
body * { 
 font-family: 'Jeju Gothic', sans-serif;
 background-color: 
}
.bi.bi-box-arrow-in-right {
  background-color: wheat; /* ������ �����ϰ� �����մϴ�. */
}
.sidebar {
    height: 800px;
    width: 190px;
    position: fixed;
    top: 100px;
    left: -250px; /* �ʱ⿡�� ȭ�� �ۿ� ��ġ */
    background-color: wheat;
    transition: left 0.3s ease;
    z-index: 999; /* �� �κ��� �߰��ؼ� sidebar�� �ٸ� ��� ���� ��Ÿ������ ���� */
}

        /* ���̵�� ��ũ ��Ÿ�� (���콺 ȣ�� ��) */
.sidebar a:hover {
            background-color: #555;
        }

        /* ���� �κ� ��Ÿ�� */
.content {
            margin-left: 0; /* ���̵�ٰ� ���� �� ���� �κ��� �ű�� ���� ���� */
            padding: 20px;
        }

        /* ���̵�� ���� �� �ִϸ��̼� */
.sidebar.open {
   left: 0;
        }
        
div.top {
	border : 0px solid gray;
	margin-left:460px;
	margin-top:120px;
}

div.contatiner {
	position: relative;
    display: flex;
    flex-direction: column;
}
</style>
<%
String root=request.getContextPath();
//�α��� ����
String loginok = (String)session.getAttribute("loginok");

String myid =(String)session.getAttribute("myid");
%>
<body>
<button type="button" onclick="toggleSidebar()" style="margin-top:150px; border:none; margin-left:15px;"><i class="bi bi-menu-app" style="font-size:20px;"></i></button><br><br>


<div class="container" style="margin-left:330px; margin-top:-100px; width:1500px; height:2000px; border-radius:20px;">
    <br><br>
    <div class="row">
        <div class="col-md-4" style="margin-bottom:30px;"> <!-- ���� �� (�̹���) -->
            <img src="<%=root %>/jeju/img1.JPG" alt="���� �̹���" style="margin-left:215px; width:900px; height:200px;">
        </div><br>
    </div>
    <hr><br><br>

		<!-- div�ȿ� ��й�ȣ ���� div��  -->
		<div class="secure" style="margin-left:170px; border-radius:20px; border:1px solid gray; width:1000px; height:1000px; ">
			<br>
			<legend><b font-size="22px">&nbsp;&nbsp;&nbsp;��&nbsp;��</b></legend><br><hr><br>
			<div class="recentLogin" style=" width: 800px; margin-left:50px; border:1px solid gray; height:120px; border-radius:10px;">
			<b>�ֱ� �α��� ��¥ : </b></div><br><br>
			
			<div class="recentLogin" style=" width: 800px; margin-left:50px; border:1px solid gray; height:120px; border-radius:10px; cursor:pointer;" onclick="updatepass()">
			<b>��й�ȣ �����ϱ� �� </b></div><br><br>
		
			<div class="recentLogin" style=" width: 800px; margin-left:50px; border:1px solid gray; height:120px; border-radius:10px; cursor:pointer" onclick="location.href='https://www.naver.com/'">
			<b>Q �˻��ϱ�</b></div><br><br>
			
			<div class="recentLogin" style=" width: 800px; margin-left:50px; border:1px solid gray; height:120px; border-radius:10px; cursor:pointer;" onclick="question()">
			<b>������ �ǰ� ������ </b></div><br><br>
			
			<div class="recentLogin" style=" width: 800px; margin-left:50px; border:1px solid gray; height:120px; border-radius:10px; cursor:pointer;" onclick="money()">
			<b>�Ŀ��ϱ�</b></div>
		</div>
</div> <!-- ���� container �ݴ� div��  -->


<!-- ���̵�� -->
<div class="sidebar open">
	<button type="button" style="margin-left:15px; margin-top:50px; border:none;" onclick="toggleSidebar()">
	<i class="bi bi-box-arrow-in-right" style="font-size:24px;"></i></button>
	<br><br><br>
    &nbsp;&nbsp;<a href="index.jsp">&nbsp;<i class="bi bi-house-door"></i>&nbsp;&nbsp;&nbsp;&nbsp;Ȩ</a><br><br>
    &nbsp;&nbsp;<a href="#">&nbsp;<i class="bi bi-person-lines-fill"></i>&nbsp;&nbsp;&nbsp;&nbsp;��������</a><br><br>
    &nbsp;&nbsp;<a href="#">&nbsp;<i class="bi bi-shield-shaded"></i>&nbsp;&nbsp;&nbsp;&nbsp;����</a><br><br>
    &nbsp;&nbsp;<a href="index.jsp?main=admin/adminBoard.jsp">&nbsp;<i class="bi bi-telephone-outbound-fill"></i>&nbsp;&nbsp;&nbsp;������</a>
    <!-- �α��λ��¸� �α׾ƿ� , �α׾ƿ� ���¸� �α������� ���̰��ϱ� 0905 ����� -->
    <br><br><br><br><br><br><br><br><br><br>
    &nbsp;&nbsp;<a href="index.jsp?main=login/logoutAction.jsp">&nbsp;<i class="bi bi-door-closed-fill"></i>&nbsp;&nbsp;&nbsp;�α׾ƿ�</a><br>
    
    <%
		// ������ �α����ϸ� �޴��� �ϳ� �� �߰� ����� 0905 �����
    %>
</div>

<script>
    // ���̵�� ����/�ݱ� �Լ�
    function toggleSidebar() {
        var sidebar = document.querySelector('.sidebar');
        sidebar.classList.toggle('open');
    }
    
    function money() {
   	 let a= "�������� ������ �Ŀ��� �������� �����ڸ� �츳�ϴ� �����մϴ�."; 
   	 let b = "�Ŀ����� : īī����ũ 3333050489678 ������\n";
   	 let c = "�Ŀ����� : īī����ũ 1234567890123 ���ÿ�\n";
   	 let d = "�Ŀ����� : īī����ũ 7979 25 81760 ������";

   	 alert(a);
   	 alert(b+c+d);
    }
    
    function updatepass() { 
    	var w = window.screen.width/2-500; 
    	var h = window.screen.height/2-200;
    	
        var url = 'index.jsp?main=myPage/updatePass.jsp&myid=<%=myid %>';
        
        window.open(url , "passchange" , "scrollbars=yes , width:1000 , height=400 , left="+w+",top="+h);
    }
    
    function question() {
    		location.href='index.jsp?main=admin/adminBoard.jsp';
    }

</script>


</body>
</html>