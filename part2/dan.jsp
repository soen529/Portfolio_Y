<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<script>
</script>
    <link href="../../resources/css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body>
	<!--테스트-->
	<div>
		<h1>휴먼 교육 센터 - 포트폴리오  2021-01-27 평가 문제 <윤소연></h1>
		 <ul 제목 : 목차>
			<li>1.과정 1</li>
			<li>2.과정 2</li>
		 </ul>
 	</div>
 	<div style="float:right">
		 <button onclick="openWin();">확인</button>
	</div>
	
	<div>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th><font color="red">2단</font></th>
					<th><font color="red">3단</font></th>
					<th><font color="red">4단</font></th>
					<th><font color="red">5단</font></th>
				</tr>
			</thead>
			<tfoot>
				<tr>
			   		<td><font color="blue">2단 합계:${danSum2}</font></td>
					<td><font color="blue">3단 합계:${danSum3}</font></td>
					<td><font color="blue">4단 합계:${danSum4}</font></td>
					<td><font color="blue">5단 합계:${danSum5}</font></td>	
				</tr>
			</tfoot>
		
			<tbody> 
				<tr>
					<td>${dan2}</td>
					<td>${dan3}</td>
					<td>${dan4}</td>
					<td>${dan5}</td>	
				</tr>
			</tbody>
		</table>
	</div>
	
	<div>	
		<table class="table table-bordered">
			<thead>
				<tr>
					<th><font color="red">6단</font></th>
					<th><font color="red">7단</font></th>
					<th><font color="red">8단</font></th>
					<th><font color="red">9단</font></th>
				</tr>
			</thead>
			
			<tfoot>
				<tr>
					<td><font color="blue">6단 합계:${danSum6}</font></td>
					<td><font color="blue">7단 합계:${danSum7}</font></td>
					<td><font color="blue">8단 합계:${danSum8}</font></td>
					<td><font color="blue">9단 합계:${danSum9}</font></td>	
				</tr>
			</tfoot>
			<tbody> 
				<tr>
					<td>${dan6}</td>
					<td>${dan7}</td>
				 	<td>${dan8}</td>
					<td>${dan9}</td>	
				</tr>
			</tbody>
		</table>
	</div>		
</body>
<script type="text/javascript">
function openWin(){
	var w =500;
	var h =300;
	
	var xPos =(document.body.offsetwidth/2)-(w/2);
	xPos += window.screenleft;
	var yPos =(document.body.offsetheight/2)-(h/2);
	
	window.open("http://localhost/sample/end","휴먼교육센터","width="+w+",height="+h+",left="+xPos+");
}
</script>
</html>