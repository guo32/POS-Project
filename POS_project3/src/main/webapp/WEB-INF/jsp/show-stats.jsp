<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>POS</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
</head>
<body>
	<div class="wrap-content">
		<div class="content">
			<h2 class="title" style="margin-bottom: 50px">Point of Sales System | 통계</h2>
			<div>
				<%@ include file="menu.jsp" %>
			</div>			
			<div class="system-content">
				<div style="padding: 10px; width: 356px; height: 460px; overflow: auto;">
					<!-- 그래프 : Chart.js(open source) -->
					<canvas id="bar-chart" width="330" height="200"></canvas> <!-- 누적 판매량 -->
					<p align="center"><b>최다 판매 제품</b></p>
					<ul>
						<c:forEach var="product" items="${maxList}">
							<li>${product.code}(${product.name}) </li>
						</c:forEach>
					</ul>
					<canvas id="bar-chart2" width="330" height="200"></canvas> <!-- 일자별 매출액 -->
					<canvas id="bar-chart3" width="330" height="200"></canvas> <!-- 월별 매출액 -->					
				</div>				
			</div>
		</div>		
	</div>
</body>
<!-- 그래프 : Chart.js(open source) -->
<script type="text/javascript">
	// 제품별 누적 판매량
	var codeData = new Array();
	var stockData = new Array();
	
	<c:forEach var="data" items="${numberOfSales}">
		codeData.push("${data.key}");
		stockData.push("${data.value}");
	</c:forEach>
	
	new Chart(document.getElementById("bar-chart"), {
	    type: 'bar',
	    data: {	    	
	      labels: codeData,
	      datasets: [
	        {
	          label: "Sales Data",
	          data: stockData
	        }
	      ]
	    },
	    options: {
	      legend: { display: false },
	      title: {
	        display: true,
	        text: '제품별 누적 판매량'
	      }
	    }
	});
	
	
	// 일자별 매출액
	var dateData = new Array();
	var priceData = new Array();
	
	<c:forEach var="data2" items="${sales}">
		dateData.push("${data2.key}");
		priceData.push("${data2.value}");
	</c:forEach>
	
	new Chart(document.getElementById("bar-chart2"), {
	    type: 'bar',
	    data: {	    	
	      labels: dateData,
	      datasets: [
	        {
	          label: "Sales Data",
	          data: priceData
	        }
	      ]
	    },
	    options: {
	      legend: { display: false },
	      title: {
	        display: true,
	        text: '일자별 매출액'
	      }
	    }
	});
	
	// 월별 매출액
	var monthData = new Array();
	
	<c:forEach var="data3" items="${monthSales}">
		monthData.push("${data3}");
	</c:forEach>
	
	new Chart(document.getElementById("bar-chart3"), {
	    type: 'bar',
	    data: {	    	
	      labels: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12],
	      datasets: [
	        {
	          label: "Sales Data",
	          data: monthData
	        }
	      ]
	    },
	    options: {
	      legend: { display: false },
	      title: {
	        display: true,
	        text: '월별 매출액'
	      }
	    }
	});
</script>
</html>