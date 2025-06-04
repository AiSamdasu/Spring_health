<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>메인 페이지</title>
</head>

<body>
<form action="${pageContext.request.contextPath}/Test" method="get">
    <button type="submit">Test01로 이동</button>
</form>

<!-- 음식 파트 -->

<h2>선택된 음식 목록</h2>

<%
    Map<String, Integer> foodCountMap = (Map<String, Integer>) request.getAttribute("foodCountMap");
    Map<String, Integer> foodTotalCalMap = (Map<String, Integer>) request.getAttribute("foodTotalCalMap");

    if (foodCountMap != null && !foodCountMap.isEmpty()) {
        List<String> foodKeys = new ArrayList<>(foodCountMap.keySet());
%>
<ul>
    <%
        for (int i = 0; i < foodKeys.size(); i++) {
            String name = foodKeys.get(i);
            int count = foodCountMap.get(name);
            int total = foodTotalCalMap.get(name);
    %>
    <li><%= name %> - <%= count %>개 - <%= total %> kcal</li>
    <%
        }
    %>
</ul>
<%
} else {
%>
<p>선택된 음식이 없습니다.</p>
<%
    }
%>

<!-- User 정보 입력해서 DB저장 파트 -->
<form action="${pageContext.request.contextPath}/inputKcal" method="get">
    <button type="submit">BMI 수정및 확인하기  </button>
</form>

<!-- 칼로리 확인 파트 input 부분을 sum으로 수정 예정 -->

<form action="${pageContext.request.contextPath}/evaluateKcal" method="post">
    <input type="number" name="SumKcal" placeholder="총 칼로리" required>
    <button type="submit">내 칼로리 확인</button>
</form>

<h2>당신의 BMI: <%= request.getAttribute("bmi") %></h2>
<h2>총 섭취 칼로리: <%= request.getAttribute("sumKcal") %> kcal</h2>
<h2>결과: <strong><%= request.getAttribute("grade") %></strong></h2>


<!-- 운동 파트 -->

<h2>운동 리스트</h2>

<%
    Map<String, Integer> exerciseCountMap = (Map<String, Integer>) request.getAttribute("exerciseCountMap");
    Map<String, Integer> exerciseTotalCalMap = (Map<String, Integer>) request.getAttribute("exerciseTotalCalMap");

    if (exerciseCountMap != null && !exerciseCountMap.isEmpty()) {
        List<String> exerciseKeys = new ArrayList<>(exerciseCountMap.keySet());
%>
<ul>
    <%
        for (int i = 0; i < exerciseKeys.size(); i++) {
            String name = exerciseKeys.get(i);
            int count = exerciseCountMap.get(name);
            int total = exerciseTotalCalMap.get(name);
    %>
    <li><%= name %> - <%= count %>개 - <%= total %> kcal</li>
    <%
        }
    %>
</ul>
<%
} else {
%>
<p>선택된 운동이 없습니다.</p>
<%
    }
%>

</body>
</html>
