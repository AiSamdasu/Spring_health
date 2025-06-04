<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

SearchExercise

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>운동 검색</title>
    <%@ include file="../bootstrap/bootstrap.jsp" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Exercise_css/SearchExercise.css">


</head>

<body>
<h2>운동 칼로리 검색</h2>
<!-- 동적으로 경로 지정  -->
<form action="${pageContext.request.contextPath}/Test" method="get">
    검색 완료 -> <button type="submit">Test01로 이동</button>
</form>

<div class="inner_box">
    <button id="searchAllBtn" class="SearchAllbtn">모든 운동 검색</button>
    <div class="search-part-row">
        <input type="text" id="searchInput" class="SearchTXT" placeholder="운동명 또는 키워드를 입력하시오">
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


<script src="${pageContext.request.contextPath}/js/Exercise/SearchExercise.js"></script>
</body>
</html>
