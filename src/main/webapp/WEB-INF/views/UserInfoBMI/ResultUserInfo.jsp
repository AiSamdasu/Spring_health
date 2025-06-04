<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>BMI 결과</title>
</head>
<body>

<h2>BMI 계산 결과</h2>
<p>BMI :  <strong><%= request.getAttribute("bmiINFO") %></strong></p>


<form action="${pageContext.request.contextPath}/inputKcal" method="get">
    <button type="submit">다시 입력하기  </button>
</form>

<form action="${pageContext.request.contextPath}/Test" method="get">
    <button type="submit">돌아가기 </button>
</form>

</body>
</html>
