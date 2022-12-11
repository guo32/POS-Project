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
			<div>
				<%@ include file="menu.jsp" %>
			</div>			
			<div class="system-content">
				<div class="flex">
					<p>메뉴를 선택하세요.</p>
				</div>	
			</div>
		</div>		
	</div>	
</body>
</html>