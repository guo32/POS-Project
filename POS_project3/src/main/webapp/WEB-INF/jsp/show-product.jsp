<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<h2 class="title" style="margin-bottom: 50px">Point of Sales System | 재고 관리</h2>
			<div>
				<%@ include file="menu.jsp" %>
			</div>			
			<div class="system-content">
				<div style="padding: 10px; width: 356px; height: 480px; overflow: auto;">
					<%@ include file="product-content.jsp" %>
				</div>				
			</div>
		</div>		
	</div>	
</body>
</html>