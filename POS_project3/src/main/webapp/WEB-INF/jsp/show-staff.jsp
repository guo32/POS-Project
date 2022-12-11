<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>POS</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css"/>
<style>
	th, td {
		padding: 5px;
	}
</style>
</head>
<body>
	<div class="wrap-content">
		<div class="content">
			<h2 class="title" style="margin-bottom: 50px">Point of Sales System | 직원 관리</h2>
			<div>
				<%@ include file="menu.jsp" %>
			</div>			
			<div class="system-content">
				<div style="padding: 10px; width: 356px; height: 480px; overflow: auto;">
					<div class="flex">
						<a href="register" class="menu-button2" style="margin-right: 5px">직원추가</a>
						<a href="show-staff" class="menu-button2">직원목록</a>
					</div>	
					<table style="width: 350px; margin-top: 10px;">
						<tr>
							<th>아이디</th>
							<th>비밀번호</th>
							<th>이름</th>
							<th>직책</th>
						</tr>
						<c:forEach var="staff" items="${staffs}">
							<tr>
								<td>${staff.id}</td>
								<td>${staff.password}</td>
								<td>${staff.name}</td>
								<td>${staff.role}</td>				
							</tr>
						</c:forEach>
					</table>
				</div>				
			</div>
		</div>		
	</div>
</body>
</html>