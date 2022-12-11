<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css"/>
</head>
<script type="text/javascript">
	function loginCheck() {
		if(!document.loginForm.id.value) {
			alert("아이디를 입력하세요.");
			return false;
		}
		if(!document.loginForm.password.value) {
			alert("비밀번호를 입력하세요.");
			return false;
		}
	}
</script>
<body>
	<div class="wrap-content">		
		<div class="content">
			<h2 class="title flex" style="margin-bottom: 20px">Login</h2>
			<form name="loginForm" action="login-success" method="post" onsubmit="return loginCheck()">
				<div>
					<input type="text" name="id" id="id" 
					class="long-form" placeholder="아이디(ID)">
				</div>
				<div>
					<input type="password" name="password" id="password" 
					class="long-form" placeholder="비밀번호(PW)">
				</div>
				<div class="flex">
					<input type="submit" value="로그인" class="long-button">
				</div>				
			</form>
		</div>
	</div>	
</body>
</html>