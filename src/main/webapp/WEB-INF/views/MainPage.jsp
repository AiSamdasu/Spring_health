<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>메인 페이지</title>
</head>

<!--  음식 검색 받아오는 코드, 추후에 켈린더랑 연동  -->


<body>
<h2>선택된 음식 목록</h2>

<%
    List<String> names = (List<String>) session.getAttribute("selectedFoodNames");
    List<Integer> cals = (List<Integer>) session.getAttribute("selectedCaloriesList");

    if (names != null && cals != null && names.size() == cals.size()) {
        Map<String, Integer> countMap = new HashMap<>();
        Map<String, Integer> totalCalMap = new HashMap<>();

        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            int cal = cals.get(i);

            countMap.put(name, countMap.getOrDefault(name, 0) + 1);
            totalCalMap.put(name, totalCalMap.getOrDefault(name, 0) + cal);
        }
%>
<ul>
    <%
        for (String name : countMap.keySet()) {
            int count = countMap.get(name);
            int total = totalCalMap.get(name);
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


<!--  운동 검색 받아오는 코드, 추후에 켈린더랑 연동  -->





</body>
</html>
