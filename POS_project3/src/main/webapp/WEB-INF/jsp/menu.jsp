<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="cs.skuniv.POS.dto.Staff" %>
<div style="float: left; border-right: 2px solid black; 
	border-radius: 10px 0 0 10px; background-color: aliceblue; height: 480px;">	
	<div style="border-bottom: 2px solid black">
		<b class="flex" style="margin-top: 10px">접속자</b>
		<p class="flex">${staff.name}님</p>
	</div>
	<div><a href="system" class="menu-button">홈</a></div>
	<div><a href="stock-product" class="menu-button">입고</a></div>
	<div><a href="sell-product" class="menu-button">판매</a></div>
	<div><a href="show-product" class="menu-button">재고</a></div>
	<div><a href="show-stats" class="menu-button">통계</a></div>
	<c:if test="${staff.role == 'manager'}">
		<div><a href="manage-staff" class="menu-button">직원관리</a></div>
	</c:if>
	<div><a href="logout" class="menu-button">로그아웃</a></div>	
</div>