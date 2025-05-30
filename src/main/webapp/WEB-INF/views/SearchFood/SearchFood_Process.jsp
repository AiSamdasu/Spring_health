<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="true" %> <!-- ` 백틱오류때문에 선언  -->

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>음식 검색</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <style>
        .food-btn {
            background-color: rgba(0, 0, 0, 0.05);
            border: 1px solid #ccc;
            border-radius: 8px;
            padding: 10px 15px;
            margin: 5px 0;
            cursor: pointer;
            font-size: 16px;
            width: 100%;
            text-align: left;
            transition: background-color 0.2s ease;
        }

        .food-btn:hover {
            background-color: rgba(0, 0, 0, 0.1);
        }

        ul {
            list-style: none;
            padding: 0;
        }

        li {
            margin-bottom: 5px;
        }
    </style>
</head>
<body>
<h2>음식 검색</h2>
<input type="text" id="searchInput" placeholder="음식 이름 입력">
<button id="searchBtn">검색</button>

<ul id="resultList"></ul>

<script>
    let result_Food_Kcal = null;

    $('#searchBtn').click(function () {
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
</script>
</body>
</html>
