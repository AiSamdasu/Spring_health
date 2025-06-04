<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="org.example.spring_caw_ktk.dto.User" %>
<%
    User user = (User) request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
    <title>칼로리 입력</title>
</head>
<body>

<h2><%= user.getNickname() %>회원 <br> 키와 몸무게 입력</h2>

<form action="${pageContext.request.contextPath}/submitUserInfo" method="post">
    <input type="hidden" name="userId" value="<%= user.getId() %>">
    <label>키 (cm): <input type="number" name="height" required></label><br>
    <label>몸무게 (kg): <input type="number" name="weight" required></label><br>
    <button type="submit">BMI 계산 및 저장</button>
</form>

</body>
</html>
