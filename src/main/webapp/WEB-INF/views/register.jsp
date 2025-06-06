<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입 페이지</title>
	<%@ include file="bootstrap/bootstrap.jsp" %> 
</head>

<body>
	<form action="/register" method="post">>
		<div class="row mb-3">
		  <label for="userid" class="col-sm-2 col-form-label">userid</label>
		  <div class="col-sm-10">
		    <input type="text" class="form-control" name="userid" id="userid" value="${registerRequest.userid}">
		  </div>
		</div>
		
		<div class="row mb-3">
		  <label for="password" class="col-sm-2 col-form-label">password</label>
		  <div class="col-sm-10">
		    <input type="password" class="form-control" name="password" id="password" value="${registerRequest.password}">
		  </div>
		</div>
		
		<div class="row mb-3">
		  <label for="nickname" class="col-sm-2 col-form-label">nickname</label>
		  <div class="col-sm-10">
		    <input type="text" class="form-control" name="nickname" id="nickname" value="${registerRequest.nickname}">
		  </div>
		</div>

		<div class="row mb-3">
		  <label for="name" class="col-sm-2 col-form-label">name</label>
		  <div class="col-sm-10">
		    <input type="text" class="form-control"name="name" id="name" value="${registerRequest.name}">
		  </div>
		</div>
		
		<div class="row mb-3">
		  <label for="age" class="col-sm-2 col-form-label">age</label>
		  <div class="col-sm-10">
		    <input type="text" class="form-control" name="age" id="age" value="${registerRequest.age}">
		  </div>
		</div>

		
		
		<div class="row mb-3">
		  <label for="gender" class="col-sm-2 col-form-label">gender</label>
		  <div class="col-sm-10">
			<input type="text" class="form-control" name="gender" id="gender" value="${registerRequest.gender}">
		  </div>
		</div>
		
		<button type="submit" class="btn btn-primary">회원가입</button>
		
	</form>
</body>
</html>
