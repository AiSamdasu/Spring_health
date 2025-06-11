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
/*
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
				// 선택한 음식 정보를 hidden input에 설정
				$('#food_name').val(food.foodName);
				$('#calories').val(food.calories);
                // 서버로 전송
                $.ajax({
                    url: '/submitFoodSelection', //main 서버반환
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
}*/

function displayFoodList(data) {
    $('#resultList').empty();

    data.forEach(function (food) {
        const button = $('<button type="button">')
//            .addClass('food-btn list-group-item list-group-item-action')
            .text(`${food.foodName} - ${food.calories} kcal`)
            .click(function (event) {
				event.preventDefault(); 
                // 1. 선택한 음식 정보를 hidden input에 저장
				$('#selectedFoodName').val(food.foodName);           // 올바른 방식
				$('#selectedFoodCalories').val(food.calories);       // 올바른 방식
				
                // 2. 모달 안에 텍스트로 표시
                $('#selectedFoodDisplay').html(`선택한 음식: <strong>${food.foodName}</strong> (${food.calories} kcal)`);

                // 3. (선택) 검색결과 창 닫기
                //closeResultModal(); // 모달이 열려있어야 할 경우 이 줄은 제거
            });

        $('#resultList').append($('<li>').append(button));
    });

    //openResultModal(); // 검색 결과 모달이 따로 있을 경우
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

