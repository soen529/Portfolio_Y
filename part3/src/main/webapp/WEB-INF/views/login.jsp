<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
	<link type="text/css" href="${path}/resources/css/ui.css" rel="stylesheet"/>
</head>
<body>
		<h1><a href="home.jsp" class="homelogo"><img src="../../../resources/img/logo.jpg"></a></h1>
		<input type="text" name="id" placeholder="아이디"></input><br>
		<input type="text" name="password" placeholder="비밀번호"></input><br>
		<button type="button" name="login"><a href="home.jsp">Login</a></button>
	
	<footer>
		<div id="sns">
			<a href="페이스북 주소"><img src="img/facebook.png" width="18px" height="18px" class="fb"></a>
			
			<a href="트위터 주소"><img src="img/twitter.png" width="18px" height="18px" class="twit"></a>
			
			<a href="인스타그램 주소"><img src="img/instagram.png" width="18px" height="18px" class="insta"></a>
		</div>
		<!-- 1.1 -->
	</footer>
</body>
</html>