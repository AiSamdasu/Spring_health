<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ include file="bootstrap/bootstrap.jsp" %>
<%@ page import="org.example.spring_caw_ktk.dto.Food" %>
<%
    Food food = (Food) request.getAttribute("food");
%>

<!DOCTYPE html>
<html>

<head>
    <title>calendar_kcal</title>
	<!-- Bootstrap CSS  -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

	<!-- Bootstrap JS + Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</head>

<body> 
	
	<jsp:include page="cal.jsp"/>

    <main>
		
		<div class="d-flex" style="height: 100vh;">
		  <!-- 왼쪽 사이드바 -->
		  <div class="d-flex flex-column flex-shrink-0 p-3 text-bg-dark" style="width: 260px;">
		    <hr>
		    <ul class="nav nav-pills flex-column mb-auto">
				
		      <li class="nav-item">
		        <a href="${pageContext.request.contextPath}/MainPage" class="nav-link text-white" aria-current="true"> 
		          <svg class="bi pe-none me-2" width="16" height="16" aria-hidden="true">
		            <use xlink:href="#home"></use>
		          </svg>
		          HOME
		        </a>
		      </li>
			  <li>
			  	<a href="${pageContext.request.contextPath}/calendar_kcal" class="nav-link active">
			  	<svg class="bi pe-none me-2" width="16" height="16" aria-hidden="page">
			  	<use xlink:href="#speedometer2"></use>
			  	</svg>
			  	Kcal
			  	</a>
			  </li>
			  <li>
			    <a href="${pageContext.request.contextPath}/calendar_bmi" class="nav-link text-white">
			      <svg class="bi pe-none me-2" width="16" height="16" aria-hidden="true">
			        <use xlink:href="#speedometer2"></use>
			      </svg>
			      BMI
			    </a>
			  </li>
			  <li>
			    <a href="${pageContext.request.contextPath}/calendar_exercise" class="nav-link text-white">
			      <svg class="bi pe-none me-2" width="16" height="16" aria-hidden="true">
			        <use xlink:href="#table"></use>
			      </svg>
			      Exercise
			    </a>
			  </li>
		    </ul>
		    <hr>
			<div class="dropdown">
			  <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle"
			     data-bs-toggle="dropdown" aria-expanded="false">
			    <strong>${sessionScope.loginMember.nickname}님</strong>
			  </a>
			  <ul class="dropdown-menu dropdown-menu-dark text-small shadow">
			    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Sign out</a></li>
			  </ul>
			</div>
		  </div>
		  
		  
		  <!-- 캘린더 본문 영역 -->
		  <div class="flex-grow-1 d-flex flex-column"style="overflow: hidden;">

			  <!-- FullCalendar 영역  -->
			  <div style="padding: 16px;">
			  	<div style="flex-grow: 1; overflow: hidden;" >
			    	<div id="calendar" style="height: 100%;"></div>
			  	</div>
			  </div>

			</div>
			
			<!-- 오른쪽 사이드바 (추가 설명) -->
			  <div class="d-flex flex-column flex-shrink-0 p-3 border-start" style="width: 220px; background-color: #f8f9fa;">
			    <hr>
				<h5>오늘의 섭취량</h5>
				<hr>

				<c:choose>
				  <c:when test="${not empty todayKcalList}">
				    <p>오늘 먹은 음식</p>
				    <c:forEach var="kcal" items="${todayKcalList}">
				      <p>- <c:out value="${kcal.food_name}" /></p>
				    </c:forEach>

				    <p>칼로리: 
				      <c:out value="${totalCalories}" /> kcal
				    </p>
				  </c:when>
				  <c:otherwise>
				    <p>오늘의 식단 기록이 없습니다.</p>
				  </c:otherwise>
				</c:choose>

				
				<hr>
				<p> 잘 하고 있어요!
				
			  </div>

		</div>

    </main>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>

</body>

<!--fullCalendar 스크립트-->
<script>
	
	
	$(document).ready(function(){
			$('#calendar').fullCalendar({
				
				selectable:true,
				selectHelper:true,
				select: function (start) {
				  // 클릭한 날짜를 YYYY-MM-DD 형식으로 변환
				  var selectedDate = moment(start).format('YYYY-MM-DD');

				  // <input id="date">에 설정
				  $('#date').val(selectedDate);

				  // 모달 열기
				  $('#exampleModalToggle').modal('show');//exampleModal
				},
				buttonText:{
					today: 'Today'
				},
				// 이벤트들
				events: [
				  <c:forEach var="kcal" items="${kcalList}" varStatus="status">
				  {
				    title: '${kcal.classify} : ${kcal.calories}kcal',
				    start: '${kcal.date}'
				  }<c:if test="${!status.last}">,</c:if>
				  </c:forEach>
				]

				
				
			});
		});
	  </script>
	  
</html>


<!--모달 : 직접 입력하기-->
<div class="modal fade" id="exampleModalToggle" aria-hidden="true" aria-labelledby="exampleModalToggleLabel" tabindex="-1">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalToggleLabel">직접 입력하기</h1>
		<!--
		<button class="btn" data-bs-target="#exampleModalToggle2" data-bs-toggle="modal">선택 추가하기</button>-->
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
	  <form action="calendar_kcal" method="post">
      <div class="modal-body">

				<div class="form-check form-check-inline">
				<input class="form-check-input" type="radio" name="classify" id="classify" value="아침">
				<label class="form-check-label" for="inlineRadio1">아침</label>
				</div>
				<div class="form-check form-check-inline">
				<input class="form-check-input" type="radio" name="classify" id="classify" value="점심">
				<label class="form-check-label" for="inlineRadio2">점심</label>
				</div>
				<div class="form-check form-check-inline">
				<input class="form-check-input" type="radio" name="classify" id="classify" value="저녁">
				<label class="form-check-label" for="inlineRadio3">저녁</label>
				</div><hr>
				
			<!--직접 입력
		  <div class="row mb-3">
		    <label for="food_name" class="col-sm-2 col-form-label">food_name</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="food_name" id="food_name"required>
		    </div>
		  </div>

		  <div class="row mb-3">
		    <label for="calories" class="col-sm-2 col-form-label">Calories</label>
		    <div class="col-sm-10">
		      <input type="number" class="form-control" name="calories" id="calories"required>
		    </div>
		  </div>-->
		  
		  
		  
		  <!-- 검색 입력 -->
		  <div class="input-group mb-3">
		    <input type="text" class="form-control" id="searchInput" placeholder="음식 이름 입력">
		    <button type="button" class="btn btn-secondary" id="searchBtn">검색</button>
		  </div>

		  <!-- 결과 표시 -->
		  <div id="resultList" class="list-group"></div>
		  
		  <!-- 선택 결과를 form에 반영 -->
		  <!-- 선택된 음식 정보를 서버에 전달할 hidden input -->
		  <input type="hidden" name="food_name" id="selectedFoodName" value="">
		  <input type="hidden" name="calories" id="selectedFoodCalories" value="">

		  
		  <input type="hidden" class="form-control" name="date" id="date">
		  <input type="hidden" class="form-control" name="userid" id="userid" value="${sessionScope.loginMember.userid}" required>
		
      </div>
      <div class="modal-footer">
		<p id="selectedFoodDisplay"></p>
		<button type="submit" class="btn btn-primary">저장</button>
      </div>
	  </form>
    </div>
  </div>
</div>



<script src="${pageContext.request.contextPath}/js/Food/SearchFood.js"></script>
