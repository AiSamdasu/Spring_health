<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>TestPage</title>
    <%@ include file="./bootstrap/bootstrap.jsp" %>

</head>
<body>
<h2>TestPage</h2>
<form action="${pageContext.request.contextPath}/searchFoodPage" method="get">
    <button type="submit">searchFoodPage 이동</button>
</form>

<form action="${pageContext.request.contextPath}/MainPage" method="get">
    <button type="submit">MainPage 이동</button>
</form>

<form action="${pageContext.request.contextPath}/searchExercisePage" method="get">
    <button type="submit">searchExercisePage 이동</button>
</form>

</body>
</html>
