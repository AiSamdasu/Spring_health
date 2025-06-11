package org.example.spring_caw_ktk.controller;

import org.example.spring_caw_ktk.dao.FoodRepository;
import org.example.spring_caw_ktk.dto.Food;
import org.example.spring_caw_ktk.dto.KcalRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FoodController {

    // 음식 검색 페이지 반환
    @GetMapping("/searchFoodPage")
    public String searchFoodPage() {
        return "SearchFood/SearchFood_Process";
    }

    // AJAX 요청을 받아 DB에서 음식 검색 결과를 반환

    @GetMapping("/searchFood")
    @ResponseBody
    public List<Food> searchFood(@RequestParam("keyword") String keyword) {
        FoodRepository repo = new FoodRepository();
        return repo.searchFoodByName(keyword);
    }


    @PostMapping("/submitFoodSelection")
    @ResponseBody
    public String submitFoodSelection(@ModelAttribute KcalRequest kcalRequest,
                                      HttpSession session) {

        String foodName = kcalRequest.getFood_name();
        Integer calories = kcalRequest.getCalories();

        // null 체크
        if (foodName == null || foodName.trim().isEmpty() || calories == null) {
            return "음식 이름이나 칼로리가 유효하지 않습니다.";
        }

        // 세션에 저장
        List<String> foodNames = (List<String>) session.getAttribute("selectedFoodNames");
        if (foodNames == null) foodNames = new ArrayList<>();
        foodNames.add(foodName);
        session.setAttribute("selectedFoodNames", foodNames);

        List<Integer> caloriesList = (List<Integer>) session.getAttribute("selectedCaloriesList");
        if (caloriesList == null) caloriesList = new ArrayList<>();
        caloriesList.add(calories);
        session.setAttribute("selectedCaloriesList", caloriesList);

        return "선택 완료";
    }



}
