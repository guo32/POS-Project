<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>POS</title>
</head>
<body>
	<script type="text/javascript">
		alert("[입고 성공] ${productRequest.name}(${productRequest.code}) 입고되었습니다.")
	</script>
	<%@ include file="stock-product.jsp" %>
</body>
</html>