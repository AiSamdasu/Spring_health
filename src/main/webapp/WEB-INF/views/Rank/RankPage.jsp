<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, org.example.spring_caw_ktk.dto.Rank" %>
<html>
<head>
    <title>랭킹</title>
    <%@ include file="../bootstrap/bootstrap.jsp" %>
</head>
<body>
<h2>🏆 유저 랭킹</h2>
<table border="1">
    <tr><th>순위</th><th>사용자 ID</th><th>점수</th><th>갱신 시간</th></tr>
    <c:forEach var="rank" items="${rankList}" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${rank.userid}</td>
            <td>${rank.score}</td>
            <td>${rank.updatedAt}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
