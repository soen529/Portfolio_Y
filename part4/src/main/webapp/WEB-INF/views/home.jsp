<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
<style>
	table,tr,td,th {
		text-align:center;
		border:1px solid black;
		border-collapse:collapse;
	}
</style>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
	//function fileSend(){
/*
$("#request").click(function(){
		var params = {
			fileName :"aaa.file"
		}
		
		$("start_ajax").click(function(){
			$.ajax({
				type:"POST",
				url:"/uploadAjax",
				data : params,
				success:function(result){
					alert("성공");
				},
				error:function(XMLHttpRequest,status,error){
					alert("실패");
				}
			});
		});
	//	});	
	//}
*/
</script>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>순서</th>
				<th>파일명</th>
				<th>파일사이즈</th>
				<th>업로드<th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var= "arrList" items="${arrList}" varStatus="i">
				<tr>
					<td>${i.count}</td>
					<td><a href="http://localhost:9000/download?fileName=${arrList.fileName}">${arrList.fileName}</a></td>
					<td>${arrList.fileSize}</td>
					<td><button type="button" name="upload">업로드</button><td>
				</tr>			
			</c:forEach>

		</tbody>
	</table>

	<br>
	<br>
	<br> <p>&nbsp;&nbsp;&nbsp;</p>
	<form action ="fileUpload" method="post" enctype="multipart/form-data">
		<input id="mediaFile" type ="file" name="mediaFile"></input>
		<!--  <input type="submit">전송</input>-->
	</form>
	
	<!-- <button onclick="fileSend();">파일 전송하는 버튼</button> -->
	<button id="request">서버와 통신시작</button>

</body>
<script>
$("#request").click(function(){
	var params = {
		fileName :"aaa.file"
	}
	
	//$("start_ajax").click(function(){
		$.ajax({
			type:"POST",
			url:"/uploadAjax",
			data : params,
			contentType : "applixation/json",
			success:function(result){
				alert("성공");
				
				alert(result);
			},
			error:function(XMLHttpRequest,status,error){
				alert("실패");
			}
		});
	});
</script>
</html>
