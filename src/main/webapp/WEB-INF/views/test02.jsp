<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입 페이지</title>
	<%@ include file="bootstrap/bootstrap.jsp" %> 
</head>

<body>
	<form action="/test02" method="post">>
		
		<div class="row mb-3">
			  <label for="userid" class="col-sm-2 col-form-label">userid</label>
			  <div class="col-sm-10">
			    <input type="text" class="form-control" name="userid" id="userid" value="${registerRequest.userid}">
			  </div>
		</div>
		<div class="row mb-3">
		  <label for="height" class="col-sm-2 col-form-label">height_cm</label>
		  <div class="col-sm-10">
		    <input type="number" class="form-control" name="height" id="height" value="${registerRequest.height}">
		  </div>
		</div>
		
		<div class="row mb-3">
		  <label for="weight" class="col-sm-2 col-form-label">weight_kg</label>
		  <div class="col-sm-10">
		    <input type="number" class="form-control" name="weight" id="weight" value="${registerRequest.weight}">
		  </div>
		</div>
		
		<div class="row mb-3">
		  <label for="date" class="col-sm-2 col-form-label">date</label>
		  <div class="col-sm-10">
		    <input type="date" class="form-control" name="date" id="date" value="${registerRequest.date}">
		  </div>
		</div>
		
		
		
		<button type="submit" class="btn btn-primary">회원가입</button>
		
	</form>
</body>
</html>
