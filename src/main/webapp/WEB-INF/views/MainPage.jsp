<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>캘린더 슬라이드</title>

    <%@ include file="./bootstrap/bootstrap.jsp" %>
    <style>
        .carousel-img {
            height: 300px;
            object-fit: cover;
            border-radius: 10px;
            margin-bottom: 1rem;
        }

        .carousel-caption {
            background-color: rgba(0,0,0,0.5);
            border-radius: 10px;
        }

        .carousel-control-prev-icon,
        .carousel-control-next-icon {
            background-color: black;
            background-size: 100%, 100%;
            border-radius: 50%;
            width: 3rem;
            height: 3rem;
        }


        .carousel-control-prev,
        .carousel-control-next {
            width: 5%;
        }
    </style>
</head>
<body class="bg-light">

<div class="container text-center mt-5">
    <h2 class="mb-4 fw-bold">나의 건강 캘린더나 순위 보기 <br> 화살표를 눌러 확인 하세요</h2>

    <!-- 슬라이드 시작 -->
    <div id="calendarCarousel" class="carousel slide mb-5" data-bs-ride="carousel">
        <div class="carousel-inner">

            <!-- 슬라이드 1 -->
            <div class="carousel-item active text-center">
                <img src="${pageContext.request.contextPath}/images/ee3.png"
                     class="d-block w-100 carousel-img mx-auto" alt="캘린더 1">
                <div class="mt-3">
                    <form action="${pageContext.request.contextPath}/calendar_bmi" method="get">
                        <button type="submit" class="btn btn-primary btn-lg">📅 BMI 캘린더 보기</button>
                    </form>
                </div>
            </div>

            <!-- 슬라이드 2 -->
            <div class="carousel-item text-center">
                <img src="${pageContext.request.contextPath}/images/ee3.png"
                     class="d-block w-100 carousel-img mx-auto" alt="캘린더 2">
                <div class="mt-3">
                    <form action="${pageContext.request.contextPath}/calendar_kcal" method="get">
                        <button type="submit" class="btn btn-success btn-lg">📅 Kcal 캘린더 보기</button>
                    </form>
                </div>
            </div>

            <!-- 슬라이드 3 -->
            <div class="carousel-item text-center">
                <img src="${pageContext.request.contextPath}/images/ee4.png"
                     class="d-block w-100 carousel-img mx-auto" alt="캘린더 3">
                <div class="mt-3">
                    <form action="${pageContext.request.contextPath}/calendar_exercise" method="get">
                        <button type="submit" class="btn btn-warning btn-lg">📅 운동 캘린더 보기</button>
                    </form>
                </div>
            </div>

            <!-- 슬라이드 4 -->
            <div class="carousel-item text-center">
                <img src="${pageContext.request.contextPath}/images/ee1.png"
                     class="d-block w-100 carousel-img mx-auto" alt="캘린더 4">
                <div class="mt-3">
                    <form action="${pageContext.request.contextPath}/rank" method="get">
                        <button type="submit" class="btn btn-info btn-lg">🏆 순위 보기</button>
                    </form>
                </div>
            </div>

        </div>

        <!-- 이전/다음 버튼 -->
        <button class="carousel-control-prev" type="button" data-bs-target="#calendarCarousel" data-bs-slide="prev">
            <span class="carousel-control-prev-icon"></span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#calendarCarousel" data-bs-slide="next">
            <span class="carousel-control-next-icon"></span>
        </button>
    </div>

    <!-- 로그아웃 버튼 -->
    <form action="${pageContext.request.contextPath}/logout" method="get" class="d-grid gap-2" style="max-width: 300px; margin: 0 auto;">
        <button type="submit" class="btn btn-danger btn-lg">🚪 로그아웃</button>
    </form>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
