<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>calendar_bmi</title>
</head>

<body> 
	
	<jsp:include page="cal.jsp"/>

    <main>
		
		<div class="d-flex" style="height: 100vh;">
		  <!-- 왼쪽 사이드바 -->
		  <div class="d-flex flex-column flex-shrink-0 p-3 text-bg-dark" style="width: 280px;">
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
		        <a href="${pageContext.request.contextPath}/calendar_bmi" class="nav-link active">
		          <svg class="bi pe-none me-2" width="16" height="16" aria-hidden="page">
		            <use xlink:href="#speedometer2"></use>
		          </svg>
		          BMI
		        </a>
		      </li>
			  <li>
			    <a href="${pageContext.request.contextPath}/calendar_excercise" class="nav-link text-white">
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
		        <img src="https://github.com/mdo.png" alt="" width="32" height="32" class="rounded-circle me-2">
		        <strong>mdo</strong>
		      </a>
		      <ul class="dropdown-menu dropdown-menu-dark text-small shadow">
		        <li><a class="dropdown-item" href="#">New project...</a></li>
		        <li><a class="dropdown-item" href="#">Settings</a></li>
		        <li><a class="dropdown-item" href="#">Profile</a></li>
		        <li><hr class="dropdown-divider"></li>
		        <li><a class="dropdown-item" href="#">Sign out</a></li>
		      </ul>
		    </div>
		  </div>

		  <!-- 오른쪽 본문 -->
		  <div class="flex-grow-1 p-4" id='calendar'></div>
		  

		</div>

				
		<c:if test="${not empty sessionScope.bmiList}">
			    <h1>${sessionScope.bmiList.userid}님 환영합니다!</h1>
			</c:if>
			<h2>${bmiList[0].userid} 님의 BMI 기록</h2>
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
				  <c:forEach var="bmi" items="${bmiList}">
				  {
				    title: 'BMI : ${bmi.bmi}',
				    start: '${bmi.date}',
				    color: (function() {
				      var bmiVal = ${bmi.bmi};
				      if (bmiVal < 18.5) return 'blue';
				      else if (bmiVal < 23) return 'green';
				      else if (bmiVal < 25) return 'orange';
				      else return 'red';
				    })()
				  },
				  </c:forEach>
				],
				dayRender: function(date, cell) {
					var newdate = moment(date).format('YYYY-MM-DD');
					if (newdate === '2025-06-05') {
						cell.css("background", "yellow");
					}
				}
				
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
		<form action="calendar_bmi" method="post">
		  <div class="row mb-3">
		    <label for="userid" class="col-sm-2 col-form-label">userid</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="userid" id="userid" value="${sessionScope.loginMember.userid}" required>
		    </div>
		  </div>

		  <div class="row mb-3">
		    <label for="height" class="col-sm-2 col-form-label">height_cm</label>
		    <div class="col-sm-10">
		      <input type="number" step="0.1" class="form-control" name="height" id="height"required>
		    </div>
		  </div>

		  <div class="row mb-3">
		    <label for="weight" class="col-sm-2 col-form-label">weight_kg</label>
		    <div class="col-sm-10">
		      <input type="number" step="0.1" class="form-control" name="weight" id="weight"required>
		    </div>
		  </div>

		  
		      <input type="hidden" class="form-control" name="date" id="date">

		  <div class="modal-footer">
		    <button type="submit" class="btn btn-primary">저장</button>
		  </div>
		</form>
      </div>
     
    </div>
  </div>
</div>