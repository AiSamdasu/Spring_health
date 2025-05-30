let result_Food_Kcal = null;

$('#searchBtn').click(function () {
    console.log("검색 버튼 클릭됨");
    const keyword = $('#searchInput').val();
    console.log("검색 키워드:", keyword);

    $.ajax({
        url: '/searchFood',
        method: 'GET',
        data: { keyword: keyword },
        success: function (data) {
            console.log("응답 데이터:", data);
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

                        // 컨트롤러로 전송
                        $.ajax({
                            url: '/submitFoodSelection',
                            method: 'POST',
                            data: result_Food_Kcal,
                            success: function (response) {
                                alert("서버에 전송 성공: " + response);
                            },
                            error: function () {
                                alert("서버 전송 실패");
                            }
                        });
                    });

                $('#resultList').append($('<li>').append(button));
            });
        },
        error: function () {
            alert("검색 중 오류 발생");
        }
    });
});
