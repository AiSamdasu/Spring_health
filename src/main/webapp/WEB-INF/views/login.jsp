<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>로그인</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      background-color: #f8f9fa;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    .login-container {
      background-color: #ffffff;
      padding: 30px;
      border: 1px solid #dee2e6;
      border-radius: 10px;
      width: 100%;
      max-width: 400px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.05);
    }

    .login-container h2 {
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
  <div class="login-container">
    <h2>로그인</h2>
    <form action="/login" method="post">
      <div class="mb-3">
        <label for="userid" class="form-label">아이디</label>
        <input type="text" class="form-control" name="userid" id="userid" value="${loginRequest.userid}" required>
      </div>
      <div class="mb-3">
        <label for="password" class="form-label">비밀번호</label>
        <input type="password" class="form-control" name="password" id="password" value="${loginRequest.password}" required>
      </div>
      <button type="submit" class="btn btn-primary">로그인</button>
    </form>
  </div>
  <!--에러창-->
  <% String error = request.getParameter("error"); %>
  <% if ("id".equals(error)) { %>
  <script>
    alert("아이디가 존재하지 않습니다.");
  </script>
  <% } else if ("pw".equals(error)) { %>
  <script>
    alert("비밀번호가 일치하지 않습니다.");
  </script>
  <% } else if ("unknown".equals(error)) { %>
  <script>
    alert("알 수 없는 오류가 발생했습니다.");
  </script>
  <% } %>

</body>
</html>
