<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>오늘의 BMI</title>
</head>
<body>
    <h2>오늘의 건강 상태</h2>
	<c:choose>
	    <c:when test="${not empty todayBmi}">
			<p>weight: ${todayBmi.weight}</p>
			<p>height: ${todayBmi.height}</p>
	        <p>BMI: ${todayBmi.bmi}</p>
	    </c:when>
	    <c:otherwise>
	        <p>오늘의 BMI 기록이 없습니다.</p>
	    </c:otherwise>
	</c:choose>

</body>
</html>
