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
			<h2 class="title" style="margin-bottom: 50px">Point of Sales System | 제품 판매</h2>
			<div>
				<%@ include file="menu.jsp" %>
			</div>			
			<div class="system-content">
				<div style="padding: 10px; width: 350px; height: 460px; overflow: auto;">
					<div style="width: 346px; height: 200px; overflow: auto;
						border-radius: 10px; border: 2px solid black; margin-bottom: 10px">
						<%@ include file="product-content.jsp" %>
					</div>
					<form action="sell-completion" method="post">
						<div class="flex">
							<input type="text" name="code" id="code"  value="${incomeRequest.code}" 
							class="long-form" placeholder="제품코드(Code)">
						</div>
						<div class="flex">
							<input type="text" name="stock" id="stock"  value="${incomeRequest.stock}"
							class="long-form" placeholder="수량(Stock)">
						</div>
						<div class="flex">
							<input type="submit" value="판매" class="long-button">
						</div>
					</form>
				</div>
			</div>
		</div>		
	</div>
</body>
</html>