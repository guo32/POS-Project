<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>POS</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css"/>
</head>
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
				</div>
			</div>
		</div>		
	</div>
</body>
</html>