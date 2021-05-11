<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 입력</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<style>
table, tr, td {
	text-align: center;
	border: 1px solid black;
	border-collapse: collapse;
}
</style>

<style>
td input {
	text-align: center;
}
</style>

<script type="text/javascript">
	var numArr = new Array();

	function submitFunc()
	{
		document.getElementById("sungjukVo").submit();
	
		$("#h1Text").html("성적결과"); 
	
	}

</script>

</head>
<body>
<h1 id="h1Text">성적표</h1>
<form commandName="sungjukVo" action="/sungjukpyo" method="post"
		enctype="form-data">
	<table border="1">
		<thead style="backgroud-color: lightgray">
			<tr style="backgroud-color: lightgray">
				<td rowspan="2">전공</td>
				<td rowspan="2">이름</td>
				<td colspan="3">전공과목</td>
				<td colspan="3">교양 필수 과목</td>
			</tr>
			<tr style="backgroud-color: lightgray">
				<td>전산학개론</td>
				<td>자바</td>
				<td>프로그래밍</td>
				<td>통계학</td>
				<td>전산영어</td>
				<td>전산수학</td>
			</tr>
		</thead>
		<tbody border="1">
		  	<c:forEach var="sung" items ="${arrList}" varStatus="i">
			<tr>
				<td>
					<select>
						<option>전공</option>
						<option>비전공</option>
					</select>
				</td>			
				<td><input type="text" name="name" value="${arrList[i.count-1]}"></td>
				<td><input type="number" name="junge">${sungjuk.setJunge}</td>
				<td><input type="number" name="java">${sungjuk.setJava}</td>
				<td><input type="number" name="programming">${sungjuk.setProgramming}</td>
				<td><input type="number" name="tongge">${sungjuk.setTongge}</td>
				<td><input type="number" name="juneng">${sungjuk.setJuneng}</td>
				<td><input type="number" name="junCal">${sungjuk.setJunCal}</td>
			
						
		<!--			<input type="text" name="jungong" value="${arrList2[i.count-1]}">
				
				<td>${arrList}</td>
				<td>${sungjuk.setJunge}</td>
				<td>${sungjuk.setJava}</td>
				<td>${sungjuk.setProgramming}</td>
				<td>${sungjuk.setTongge}</td>
				<td>${sungjuk.setJuneng}</td>
				<td>${sungjuk.setJunCal}</td>
				<td>${sungjuk.setJunSec}</td>   <!-- 전공과목 -->  
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<button type="submit" onclick="submitFunc()">전송</button>
	<!--  <input type ="button" value="전송" onclick="insertTr()">-->
	</form>
</body>
</html>