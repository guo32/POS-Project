<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<h2 class="title" style="margin-bottom: 50px">Point of Sales System | 제품 입고</h2>
			<div>
				<%@ include file="menu.jsp" %>
			</div>			
			<div class="system-content">
				<div style="padding: 10px; width: 350px; height: 480px; overflow: auto;">
					<form action="stock-completion" method="post">
						<div class="flex">
							<input type="text" name="code" id="code"  value="${productRequest.code}" 
							class="long-form" placeholder="제품코드(Code)">
						</div>
						<div class="flex">
							<input type="text" name="name" id="name"  value="${productRequest.name}"
							class="long-form" placeholder="제품명(Name)">
						</div>
						<div class="flex">
							<input type="text" name="stock" id="stock"  value="${productRequest.stock}"
							class="long-form" placeholder="수량(Stock)">
						</div>
						<div class="flex">
							<input type="text" name="price" id="price"  value="${productRequest.price}"
							class="long-form" placeholder="가격(Price)">
						</div>
						<div class="flex">
							<input type="submit" value="입고" class="long-button">
						</div>
					</form>
				</div>
			</div>
		</div>		
	</div>
</body>
</html>