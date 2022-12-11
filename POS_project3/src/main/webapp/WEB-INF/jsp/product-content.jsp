<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table>
	<tr>
		<th>코드</th>
		<th>제품명</th>
		<th>수량</th>
		<th>가격</th>
		<th>입고일</th>
	</tr>
	<c:forEach var="product" items="${products}">
		<tr>
			<td>${product.code}</td>
			<td>${product.name}</td>
			<td>${product.stock}개</td>
			<td>${product.price}원</td>
			<td>${product.date}</td>
		</tr>
	</c:forEach>
</table>