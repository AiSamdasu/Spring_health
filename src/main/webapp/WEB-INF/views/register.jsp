<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>회원가입</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      background-color: #f8f9fa;
      display: flex;
      justify-content: center;
      align-items: center;
      min-height: 100vh;
    }

    .register-container {
      background-color: #ffffff;
      padding: 30px;
      border: 1px solid #dee2e6;
      border-radius: 10px;
      width: 100%;
      max-width: 500px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.05);
    }

    .register-container h2 {
      text-align: center;
      margin-bottom: 25px;
      font-size: 24px;
      color: #343a40;
    }

    .form-label {
      font-weight: 500;
    }

    .btn-primary {
      width: 100%;
    }
  </style>
</head>
<body>
  <div class="register-container">
    <h2>회원가입</h2>
    <form action="/register" method="post">
      <div class="mb-3">
        <label for="userid" class="form-label">아이디</label>
        <input type="text" class="form-control" name="userid" id="userid" value="${registerRequest.userid}" required>
      </div>

      <div class="mb-3">
        <label for="password" class="form-label">비밀번호</label>
        <input type="password" class="form-control" name="password" id="password" value="${registerRequest.password}" required>
      </div>

      <div class="mb-3">
        <label for="nickname" class="form-label">닉네임</label>
        <input type="text" class="form-control" name="nickname" id="nickname" value="${registerRequest.nickname}" required>
      </div>

      <div class="mb-3">
        <label for="name" class="form-label">이름</label>
        <input type="text" class="form-control" name="name" id="name" value="${registerRequest.name}" required>
      </div>

      <div class="mb-3">
        <label for="age" class="form-label">나이</label>
        <input type="number" class="form-control" name="age" id="age" value="${registerRequest.age}" required>
      </div>

      <div class="mb-3">
		<label class="form-label d-block">성별</label>
		<div class="form-check form-check-inline">
		  <input class="form-check-input" type="radio" name="gender" id="male" value="남성" >
		    ${registerRequest.gender == '남성' ? 'checked' : ''} 
		  <label class="form-check-label" for="male">남성</label>
		</div>
		<div class="form-check form-check-inline">
		  <input class="form-check-input" type="radio" name="gender" id="female" value="여성" >
		    ${registerRequest.gender == '여성' ? 'checked' : ''}
		  <label class="form-check-label" for="female">여성</label>
		</div>
      </div>

      <button type="submit" class="btn btn-primary">회원가입</button>
    </form>
  </div>
  
  
  <!--에러창-->
  <% String error = request.getParameter("error"); %>
  <% if ("id".equals(error)) { %>
  <script>
    alert("아이디가 중복됩니다.");
  </script>
  <% } else if ("nickname".equals(error)) { %>
  <script>
    alert("닉네임이 중복됩니다.");
  </script>
  <% } else if ("unknown".equals(error)) { %>
  <script>
    alert("알 수 없는 오류가 발생했습니다.");
  </script>
  <% } %>

</body>
</html>
