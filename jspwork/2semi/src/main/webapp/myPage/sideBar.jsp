<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<style>

div.menu {
	position:absolute;
	border : 1px solid gray;
	width : 100px;
	height : 150px;
	
}

.sidebar {
    height: 800px;
    width: 220px;
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


</style>
<body>

<div class="menu">
<button onclick="toggleSidebar()" style="width:40px; height:40px;"><i class="bi bi-menu-app" style="font-size:20px; border:none;"></i></button><br><br>
</div>

<!-- ���̵�� -->
<div class="sidebar">
	<button type="button" style="margin-left:15px; margin-top:20px; border:none;" onclick="toggleSidebar()">
	<i class="bi bi-menu-app" style="font-size:20px;"></i></button>
	<br><br>
    &nbsp;&nbsp;<a href="index.jsp">&nbsp;<i class="bi bi-house-door"></i>&nbsp;&nbsp;&nbsp;&nbsp;<b>Ȩ</b></a><br><br>
    &nbsp;&nbsp;<a href="#">&nbsp;<i class="bi bi-person-lines-fill"></i>&nbsp;&nbsp;&nbsp;&nbsp;<b>��������</b></a><br><br>
    &nbsp;&nbsp;<a href="index.jsp?main=myPage/secure.jsp">&nbsp;<i class="bi bi-shield-shaded"></i>&nbsp;&nbsp;&nbsp;&nbsp;<b>����</b></a><br><br>
    &nbsp;&nbsp;<a href="index.jsp?main=admin/adminBoard.jsp">&nbsp;<i class="bi bi-telephone-outbound-fill"></i>&nbsp;&nbsp;&nbsp;<b>������</b></a>
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
</script>

</body>
</html>