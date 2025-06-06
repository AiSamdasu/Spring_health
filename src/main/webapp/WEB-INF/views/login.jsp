<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입 페이지</title>
	<%@ include file="bootstrap/bootstrap.jsp" %> 
</head>

<body>
	<form action="/login" method="post">>
		<div class="row mb-3">
		  <label for="userid" class="col-sm-2 col-form-label">userid</label>
		  <div class="col-sm-10">
		    <input type="text" class="form-control" name="userid" id="userid" value="${loginRequest.userid}">
		  </div>
		</div>
		
		<div class="row mb-3">
		  <label for="password" class="col-sm-2 col-form-label">password</label>
		  <div class="col-sm-10">
		    <input type="password" class="form-control" name="password" id="password" value="${loginRequest.password}">
		  </div>
		</div>
		<button type="submit" class="btn btn-primary">로그인</button>
	</form>
</body>
</html>
