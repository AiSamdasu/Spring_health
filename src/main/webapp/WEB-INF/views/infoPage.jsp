
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>식단 관리 시스템</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@ include file="./bootstrap/bootstrap.jsp" %>
    <style>
        body {
            background-color: #f8f9fa;
        }
        .center-box {
            max-width: 500px;
            margin: 50px auto;
            text-align: center;
        }
        .example-img {
            width: 100%;
            max-height: 500px;
            object-fit: contain;
            border-radius: 15px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-bottom: 40px;
        }
        .d-grid form {
            margin-bottom: 10px;
        }

        .d-grid form button {
            width: 100%;
            height: 60px;
            font-size: 1.25rem;
            font-weight: bold;
        }
    </style>
</head>
<body>

<div class="container center-box">
    <div class="container center-box">
        <div id="imageCarousel" class="carousel slide" data-bs-ride="carousel" data-bs-interval="3000">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="${pageContext.request.contextPath}/images/ex1.png" class="d-block w-100 example-img"  alt="예시 이미지 1">
                </div>
                <div class="carousel-item">
                    <img src="${pageContext.request.contextPath}/images/ex2.png" class="d-block w-100 example-img"  alt="예시 이미지 2">
                </div>

                <div class="carousel-item">
                    <img src="${pageContext.request.contextPath}/images/ee2.png" class="d-block w-100 example-img"  alt="예시 이미지 5">
                </div>
                <div class="carousel-item">
                    <img src="${pageContext.request.contextPath}/images/ee3.png" class="d-block w-100 example-img" alt="예시 이미지 6">
                </div>
            </div>

            <button class="carousel-control-prev" type="button" data-bs-target="#imageCarousel" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">이전</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#imageCarousel" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">다음</span>
            </button>
        </div>
    <div class="d-grid gap-3 mt-4">
        <!-- 로그인 버튼-->
        <form action="${pageContext.request.contextPath}/login" method="get" >
            <button class="btn btn-primary btn-lg" type="submit">로그인 하러가기</button>
        </form>
        <!-- 회원가입 버튼-->
        <form action="${pageContext.request.contextPath}/register" method="get" >
            <button class="btn btn-success btn-lg" type="submit">회원가입  </button>
        </form>

    </div>
</div>

<!-- Bootstrap JS (선택사항, 동작 필요 시 포함) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
