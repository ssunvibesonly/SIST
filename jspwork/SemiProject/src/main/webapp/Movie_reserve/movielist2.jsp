<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Random"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle:wght@300&family=Gamja+Flower&family=Nanum+Pen+Script&family=Noto+Serif+KR:wght@200&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
<script>
	$(function(){
		$(".seoul").hide();
		$(".gyeonggi").hide();
		$(".incheon").hide();
		$(".gangwon").hide();
		$(".daejeon").hide();
		$(".daegu").hide();
		$(".busan").hide();
		$(".gyeongsang").hide();
		$(".jeju").hide();

		$("th.local").click(function(){
			var name=$(this).text();
			//alert(name);
			if(name!='서울'||name==null){
				$(".seoul").hide();
			}else{
				$(".seoul").show();
			}
			if(name!='경기'||name==null){
				$(".gyeonggi").hide();
			}else{
				$(".gyeonggi").show();
			}
			if(name!='인천'||name==null){
				$(".incheon").hide();
			}else{
				$(".incheon").show();
			}
			if(name!='강원'||name==null){
				$(".gangwon").hide();
			}else{
				$(".gangwon").show();
			}
			if(name!='대전'||name==null){
				$(".daejeon").hide();
			}else{
				$(".daejeon").show();
			}
			if(name!='대구'||name==null){
				$(".daegu").hide();
			}else{
				$(".daegu").show();
			}
			if(name!='부산'||name==null){
				$(".busan").hide();
			}else{
				$(".busan").show();
			}
			if(name!='경상'||name==null){
				$(".gyeongsang").hide();
			}else{
				$(".gyeongsang").show();
			}
			if(name!='제주'||name==null){
				$(".jeju").hide();
			}else{
				$(".jeju").show();
			}
			
		})
		
		
		
	})
		
</script>
<style>

#mv_name{

position:absolute;
top:200px;
left:200px;
border:2px solid gray;
width:343px;
height:500px;

}
#mv_theater{

position:absolute;
border:2px solid gray;
top:200px;
left:543px;
width:345px;
height:500px;

}

#mv_day{

position:absolute;
border:2px solid gray;
left:885px;
top:200px;
width:173px;
height:500px;

}
#mv_time{
position:absolute;
border:2px solid gray;
left:1057px;
top:200px;
width:342px;
height:500px;

}

.table{

position:absolute;
top:150px;
left:200px;
text-align:center;
width:1200px;
}

#select_info{

position:absolute;
border:2px solid gray;
top:750px;
left:200px;
width:1200px;
height:200px;


}
li{list-style: none;}

</style>
</head>
<body>
<table class="table table-bordered">
	<tr>
		<th style="width:200px;">영화</th>
		<th style="width:200px;">극장</th>
		<th style="width:100px;">날짜</th>
		<th style="width:200px;">시간</th>
	</tr>
</table>



<div align="center" id="info"></div>
<div id="mv_name" class="slider slider-y"><br><%

String [] mov={"<img src='../image/15.png' style='width:30px;'> 오펜하이머",
		"<img src='../image/15.png' style='width:30px;'> 콘크리트 유토피아",
		"<img src='../image/12.png' style='width:30px;'> 달짝지근해:7510",
		"<img src='../image/12.png' style='width:30px;'> 밀수",
		"<img src='../image/all.png' style='width:30px;'> 엘리멘탈",
		"<img src='../image/15.png' style='width:30px;'> 잠",
		"<img src='../image/15.png' style='width:30px;'> 타겟",
		"<img src='../image/15.png' style='width:30px;'> 신체모음"};

%>
<ul>
<%
for(int i=0;i<mov.length;i++){
%>
<li><b><%=mov[i] %></b></li><br>
<%
}
%>
</ul>
</div>
<div id="mv_theater">
<table class="table table-bordered" style="width:100px;position: absolute;top: 10px;left:10px;">
<%
String [] local={"서울","경기","인천","강원","대전","대구","부산","경상","제주"};

for(int a=0;a<local.length;a++){%>
	<tr><th class="local" style="cursor: pointer;"><%=local[a] %></th></tr>
 
<% }%></table><%

String[] seoul={"강남","강변","건대입구","구로","대학로","동대문","등촌","명동","미아","방학"};
String[] gyeonggi={"경기광주","고양백석","고양행신","광교","광교상현","광명역","구리","구리갈매","기흥","김포","김포운양"};
String[] incheon={"계양","부평","연수역","인천","인천가정","인천논현","인천도화","인천시민공원","인천연수","인천학익","주안역"};
String[] gangwon={"강릉","기린","원주","원통","인제","춘천"};
String[] daejeon={"논산","당진","대전","대전가오","대전탄방","대전터미널","서산","세종","아산","유성노은"};
String[] daegu={"대구","대구수성","대구스타디움","대구아카데미","대구연경","대구월성","대구죽전"};
String[] busan={"대연","동래","부산명지","서면","서면삼정타워","아시아드","울산동구","울산삼산"};
String[] gyeongsang={"거제","경산","고성","구미","김천율곡","김해","김해율하","김해장유","마산","안동","창원"};
String[] jeju={"광양","광주금남로","광주상무","광주용봉","광주첨단","광주터미널","광주하남","나주","목포","서전주"};%>

<table class="table table-bordered seoul"style="position: absolute;left: 120px;width:200px;top:10px;"><% 
for(int seo=0;seo<seoul.length;seo++){%>
	<tr><td><%=seoul[seo] %></td></tr>
<%}

%>
</table>
<table class="table table-bordered gyeonggi"style="position: absolute;left: 120px;width:200px;top:10px;"><% 
for(int gye=0;gye<gyeonggi.length;gye++){%>
	<tr><td><%=gyeonggi[gye] %></td></tr>
<%}

%>
</table>
<table class="table table-bordered incheon"style="position: absolute;left: 120px;width:200px;top:10px;"><% 
for(int in=0;in<incheon.length;in++){%>
	<tr><td><%=incheon[in] %></td></tr>
<%}

%>
</table>
<table class="table table-bordered gangwon"style="position: absolute;left: 120px;width:200px;top:10px;"><% 
for(int gang=0;gang<gangwon.length;gang++){%>
	<tr><td><%=gangwon[gang] %></td></tr>
<%}

%>
</table>
<table class="table table-bordered daejeon"style="position: absolute;left: 120px;width:200px;top:10px;"><% 
for(int dae=0;dae<daejeon.length;dae++){%>
	<tr><td><%=daejeon[dae] %></td></tr>
<%}

%>
</table>
<table class="table table-bordered daegu"style="position: absolute;left: 120px;width:200px;top:10px;"><% 
for(int daeg=0;daeg<daegu.length;daeg++){%>
	<tr><td><%=daegu[daeg] %></td></tr>
<%}

%>
</table>
<table class="table table-bordered busan"style="position: absolute;left: 120px;width:200px;top:10px;"><% 
for(int bu=0;bu<busan.length;bu++){%>
	<tr><td><%=busan[bu] %></td></tr>
<%}

%>
</table>
<table class="table table-bordered gyeongsang"style="position: absolute;left: 120px;width:200px;top:10px;"><% 
for(int gs=0;gs<gyeongsang.length;gs++){%>
	<tr><td><%=gyeongsang[gs] %></td></tr>
<%}

%>
</table>
<table class="table table-bordered jeju" style="position: absolute;left: 120px;width:200px;top:10px;"><% 
for(int je=0;je<jeju.length;je++){%>
	<tr><td><%=jeju[je] %></td></tr>
<%}

%>

</table>

</div>
<div id="mv_day"></div>
<div id="mv_time">
<%
String [] time={"7:00","10:30","12:40","14:00","14:40","15:20","16:00","17:10","18:20","19:00","19:50","21:00","22:10","23:40"}; //랜덤으로 돌려서 sort

List<String> timelist=new ArrayList<String>();

for(String tl:time){
	timelist.add(tl);
}
Random rand=new Random();
int random=rand.nextInt(timelist.size());
System.out.println(timelist.get(random));



%>
<b><%=timelist.get(random) %></b>

</div>
<div id="select_info"></div>


</body>
</html>