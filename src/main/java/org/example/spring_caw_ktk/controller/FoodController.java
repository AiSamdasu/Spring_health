package org.example.spring_caw_ktk.controller;

import org.example.spring_caw_ktk.dao.FoodRepository;
import org.example.spring_caw_ktk.dto.Food;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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
    public String submitFoodSelection(@RequestParam("foodName") String foodName,
                                      @RequestParam("calories") int calories,
                                      HttpSession session) {
        // 이름 목록
        List<String> foodNames = (List<String>) session.getAttribute("selectedFoodNames");
        if (foodNames == null) foodNames = new ArrayList<>();
        foodNames.add(foodName);
        session.setAttribute("selectedFoodNames", foodNames);

        // 칼로리 목록
        List<Integer> caloriesList = (List<Integer>) session.getAttribute("selectedCaloriesList");
        if (caloriesList == null) caloriesList = new ArrayList<>();
        caloriesList.add(calories);
        session.setAttribute("selectedCaloriesList", caloriesList);

        return "redirect:/MainPage";  // GET 요청으로 리다이렉트
    }
}
