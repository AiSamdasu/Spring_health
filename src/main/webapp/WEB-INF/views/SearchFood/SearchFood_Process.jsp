<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>음식 검색</title>
    <%@ include file="../bootstrap/bootstrap.jsp" %>
    <link rel="stylesheet" href="<c:url value='/css/Food_css/SearchFood.css' />">



</head>
<body>
<h2>음식 칼로리 검색</h2>

<div class="inner_box">
    <button id="searchAllBtn" class="SearchAllbtn">모든 음식 검색</button>
    <div class="search-part-row">
        <input type="text" id="searchInput" class="SearchTXT" placeholder="음식 또는 키워드를 입력하시오">
        <button id="searchBtn" class="Searchbtn">검색</button>
    </div>

</div>

<!-- 모달 영역 -->
<div id="resultModal" class="modal">
    <div class="modal-content">
        <span class="close-btn">&times;</span>
        <h3>검색 결과</h3>
        <ul id="resultList"></ul>
    </div>
</div>

<script src="<c:url value='/js/Food/SearchFood.js' />"></script>
</body>
</html>
