<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>POS</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css"/>
</head>
<script type="text/javascript">
	function checkPassword() {
		var password = document.newStaff.password.value;
		var confirmPassword = document.newStaff.confirmPassword.value;
		
		if(password != confirmPassword) {
			alert("[비밀번호 확인] 비밀번호가 일치하지 않습니다.");
			return false;
		}
	}
</script>
<body>
	<div class="wrap-content">
		<div class="content">
			<h2 class="title" style="margin-bottom: 50px">Point of Sales System | 직원 관리</h2>
			<div>
				<%@ include file="menu.jsp" %>
			</div>			
			<div class="system-content">
				<div style="padding: 10px; width: 350px; height: 480px; overflow: auto;">
					<div class="flex">
						<a href="register" class="menu-button2" style="margin-right: 5px">직원추가</a>
						<a href="show-staff" class="menu-button2">직원목록</a>
					</div>
					<form name="newStaff" action="register-completion" method="post" onsubmit="return checkPassword()">
						<div class="flex">
							<input type="text" name="id" id="id"  value="${registerRequest.id}"
							class="long-form" placeholder="아이디(ID)">
						</div>
						<div class="flex">
							<input type="text" name="name" id="name" value="${registerRequest.name}"
							class="long-form" placeholder="이름(Name)">
						</div>
						<div class="flex">
							<input type="password" name="password" id="password" value="${registerRequest.password}"
							class="long-form" placeholder="비밀번호(PW)">
						</div>
						<div class="flex">
							<input type="password" name="confirmPassword" id="confirmPassword" value="${registerRequest.confirmPassword}"
							class="long-form" placeholder="비밀번호 확인(PW Confirm)">
						</div>
						<div style="margin: 15px">
							<input type="radio" name="role" value="staff"> staff
							<input type="radio" name="role" value="manager"> manager
						</div>
						<div class="flex">
							<input type="submit" value="직원등록" class="long-button">
						</div>
					</form>
				</div>
			</div>
		</div>		
	</div>
</body>
</html>