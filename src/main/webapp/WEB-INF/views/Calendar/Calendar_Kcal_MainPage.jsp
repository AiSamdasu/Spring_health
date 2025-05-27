<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <title>칼로리 캘린더</title>
    <%@ include file="../bootstrap/bootstrap.jsp" %>

    <link rel="stylesheet" href="/css/Calendar_css/Calendar_Kcal_MainPage_css.css">
    <link rel="stylesheet" href="/css/Calendar_css/Calendar_pt.css">

    <script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
</head>
<body>

<!-- A구역: 상단 네비게이터 -->
<div class="navigator">
    <div class="nav-left">KCal/M</div>
    <div class="nav-center">
        <button>&lt;-</button>
        <span>달</span>
        <button>-&gt;</button>
    </div>
    <div class="nav-right">
        <button class="weight-btn">몸무게로 보기</button>
    </div>
</div>

<!-- 전체 메인 레이아웃 -->
<div class="main-wrapper">

    <!-- C구역: 왼쪽 -->
    <div class="left-sidebar">
        <button class="link-btn">링크1</button>
        <button class="link-btn">링크2</button>
    </div>

    <!-- B구역: 달력 -->
    <div class="calendar-container">
        <%@ include file="Calendar_pt.jsp" %>
    </div>

</div>

<!-- 모달 -->
<div id="entryModal" class="modal" style="display:none;">
    <div class="modal-content">
        <span class="close-btn">&times;</span>
        <h3>내용 입력</h3>
        <input type="hidden" id="modalDay">
        <textarea id="modalText" rows="4" cols="30"></textarea><br>
        <button id="saveBtn">저장</button>
    </div>
</div>

<script>
    let currentCell = null;

    // + 버튼 클릭 시 모달 열기
    $(document).on('click', '.open-modal', function () {
        currentCell = $(this).closest('.day-cell');
        const day = $(this).data('day');
        $('#modalDay').val(day);
        $('#modalText').val(currentCell.find('.cell-text').text());
        $('#entryModal').show();
    });

    // 모달 닫기
    $('.close-btn').click(() => $('#entryModal').hide());

    // 저장 버튼 클릭 시 fetch 전송
    $('#saveBtn').click(function () {
        const day = $('#modalDay').val();
        const text = $('#modalText').val();

        fetch('/saveEntry', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            },
            body: new URLSearchParams({ day, text })
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('서버 오류 발생');
                }
                return response.text(); // 또는 .json() - 서버 응답 형식에 따라
            })
            .then(() => {
                currentCell.find('.cell-text').text(text);
                $('#entryModal').hide();
            })
            .catch(error => {
                console.error('저장 중 오류:', error);
                alert('저장 실패');
            });
    });
</script>


</body>
</html>
