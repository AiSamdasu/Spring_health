<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="org.example.spring_caw_ktk.dto.Food" %>
<%
    Food food = (Food) request.getAttribute("food");
%>
<html>
<head>
    <title>음식 상세 정보</title>
</head>
<!-- http://localhost:8080/showFoodDetail?foodName=김치찌개 -->
<body>
<% if (food != null) { %>
<h2><%= food.getFoodName() %>의 영양 정보</h2>
<ul>
    <li>칼로리: <%= food.getCalories() %> kcal</li>
    <li>탄수화물: <%= food.getCarbohydrate() %> g</li>
    <li>단백질: <%= food.getProtein() %> g</li>
    <li>지방: <%= food.getFat() %> g</li>
</ul>
<% } else { %>
<p>해당 음식을 찾을 수 없습니다.</p>
<% } %>
</body>
</html>
