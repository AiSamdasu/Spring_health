let result_Food_Kcal = null;

// 모달 열기
function openResultModal() {
    document.getElementById("resultModal").style.display = "block";
}

// 모달 닫기
function closeResultModal() {
    document.getElementById("resultModal").style.display = "none";
}

// 닫기 이벤트 등록
document.addEventListener("DOMContentLoaded", function () {
    document.querySelector(".close-btn").onclick = closeResultModal;
    window.onclick = function (event) {
        if (event.target === document.getElementById("resultModal")) {
            closeResultModal();
        }
    };
});

// 음식 리스트 출력 함수
function displayFoodList(data) {
    $('#resultList').empty();

    data.forEach(function (food) {
        const button = $('<button>')
            .addClass('food-btn')
            .text(`${food.foodName} - ${food.calories} kcal`)
            .click(function () {
                result_Food_Kcal = {
                    foodName: food.foodName,
                    calories: food.calories
                };
                console.log("선택된 음식:", result_Food_Kcal);

                // 서버로 전송
                $.ajax({
                    url: '/submitFoodSelection',
                    method: 'POST',
                    data: result_Food_Kcal,
                    success: function (response) {
                        alert(response);
                        closeResultModal();

                    },
                    error: function () {
                        alert("서버 전송 실패");
                    }
                });
            });

        $('#resultList').append($('<li>').append(button));
    });

    openResultModal();
}

// 전체 검색
$('#searchAllBtn').click(function () {
    console.log("전체 음식 출력 버튼 클릭됨");
    $.ajax({
        url: '/searchFood',
        method: 'GET',
        data: { keyword: '' },
        success: function (data) {
            console.log("응답 데이터:", data);
            displayFoodList(data);
        },
        error: function () {
            alert("전체 출력 중 오류 발생");
        }
    });
});

// 키워드 검색
$('#searchBtn').click(function () {
    console.log("검색 버튼 클릭됨");
    const keyword = $('#searchInput').val();
    if (!keyword){
        alert("음식을 입력하거나,\n키워드를 입력하시오.");

        $('#searchInput').focus();
        return;
    }
    console.log("검색 키워드:", keyword);

    $.ajax({
        url: '/searchFood',
        method: 'GET',
        data: { keyword: keyword },
        success: function (data) {
            console.log("응답 데이터:", data);
            displayFoodList(data);
        },
        error: function () {
            alert("검색 중 오류 발생");
        }
    });
});
