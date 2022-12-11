<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
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
			<h2 class="title" style="margin-bottom: 50px">Point of Sales System</h2>
			<div class="flex" style="background-color: #ffffff; border-radius: 10px; 
				padding: 10px 50px; margin-bottom: 10px">
				<b>접속자 | ${staff.name}님</b>
			</div>
			<div class="flex"><a href="system" class="long-button">시스템 접속</a></div>
		</div>
	</div>
</body>
</html>