<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>calendar_excercise</title>
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
		        <a href="${pageContext.request.contextPath}/MainPage" class="nav-link text-white " aria-current="true">
		          <svg class="bi pe-none me-2" width="16" height="16" aria-hidden="true">
		            <use xlink:href="#home"></use>
		          </svg>
		          HOME
		        </a>
		      </li>
			  <li>
			  	<a href="${pageContext.request.contextPath}/calendar_kcal" class="nav-link text-white">
			  	<svg class="bi pe-none me-2" width="16" height="16" aria-hidden="true">
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
		        <a href="${pageContext.request.contextPath}/calendar_exercise" class="nav-link active">
		          <svg class="bi pe-none me-2" width="16" height="16" aria-hidden="page">
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
		  	<h5>오늘의 운동</h5>
		  	<hr>
			<p>운동 종류 : 
			<p>-
			<p>-
		    <p>소모 칼로리 : 000000</p>
		  	
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
				  $('#exampleModal').modal('show');
				},
				buttonText:{
					today: 'Today'
				},
				// 이벤트들
				events: [
				  <c:forEach var="exercise" items="${exerciseList}" varStatus="status">
				  {
				    title: '${exercise.exercise_name}(${exercise.calories}kcal)',
				    start: '${exercise.date}'
				  }<c:if test="${!status.last}">,</c:if>
				  </c:forEach>
				]


				
			});
		});
	  </script>
	  
</html>

<!-- 모달 -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">기록하기</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
	  <!--모달 내용-->
      <div class="modal-body">
		<form action="calendar_exercise" method="post">
			
			<!--
		  <div class="row mb-3">
		    <label for="userid" class="col-sm-2 col-form-label">userid</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="userid" id="userid" value="${sessionScope.loginMember.userid}" required>
		    </div>
		  </div>
		  -->
		  <div class="row mb-3">
		    <label for="exercise_name" class="col-sm-2 col-form-label">exercise_name</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="exercise_name" id="exercise_name"required>
		    </div>
		  </div>

		  <div class="row mb-3">
		    <label for="calories" class="col-sm-2 col-form-label">calories</label>
		    <div class="col-sm-10">
		      <input type="number" class="form-control" name="calories" id="calories"required>
		    </div>
		  </div>

		  <input type="hidden" class="form-control" name="userid" id="userid" value="${sessionScope.loginMember.userid}" required>
		  <input type="hidden" class="form-control" name="date" id="date">

		  <div class="modal-footer">
		    <button type="submit" class="btn btn-primary">저장</button>
		  </div>
		</form>
      </div>
     
    </div>
  </div>
</div>