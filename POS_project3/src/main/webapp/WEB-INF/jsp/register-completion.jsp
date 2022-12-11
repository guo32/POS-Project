<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>POS</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css"/>
</head>
<body>
	<script type="text/javascript">
		alert("[등록 성공] ${registerRequest.name}님이 등록되었습니다.")
	</script>
	<%@ include file="register.jsp" %>
</body>
</html>