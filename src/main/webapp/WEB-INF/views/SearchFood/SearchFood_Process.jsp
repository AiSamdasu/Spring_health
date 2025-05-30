<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>음식 검색</title>

    <!-- 외부 CSS -->
    <link rel="stylesheet" href="<c:url value='/css/Food_css/SearchFood.css' />">

    <!-- jQuery CDN -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
<h2>음식 검색</h2>
<input type="text" id="searchInput" placeholder="음식 이름 입력">
<button id="searchBtn">검색</button>

<ul id="resultList"></ul>


<script src="<c:url value='/js/Food/SearchFood.js' />"></script>
</body>
</html>
