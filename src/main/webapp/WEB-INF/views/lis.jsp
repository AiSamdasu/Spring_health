<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<%@ taglibprefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입 페이지</title>
</head>

<body>
	성공!
	<c:if test="${not empty sessionScope.bmiList}">
	    <h1>${sessionScope.bmiList.userid}님 환영합니다!</h1>
	</c:if>
	
	<h2>${bmiList[0].userid} 님의 BMI 기록</h2>

	<table border="1">
	    <thead>
	        <tr>
	            <th>날짜</th>
	            <th>키 (cm)</th>
	            <th>몸무게 (kg)</th>
	            <th>BMI</th>
	            <th>기록 시간</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach var="bmi" items="${bmiList}">
	            <tr>
	                <td>${bmi.date}</td>
	                <td>${bmi.height}</td>
	                <td>${bmi.weight}</td>
	                <td>${bmi.bmi}</td>
	                <td>${bmi.created_at}</td>
	            </tr>
	        </c:forEach>
	    </tbody>
	</table>
</body>
</html>
