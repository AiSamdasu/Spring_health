package org.example.spring_caw_ktk.controller;

import org.example.spring_caw_ktk.dao.FoodRepository;
import org.example.spring_caw_ktk.dto.Food;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FoodController {
    // 음식 이름으로 검색 (AJAX 요청에 응답)
    @GetMapping("/searchFood")
    @ResponseBody
    public List<Food> searchFood(@RequestParam("keyword") String keyword) {
        FoodRepository repo = new FoodRepository();
        return repo.searchFoodByName(keyword);
    }

    // 특정 날짜에 음식 저장 (예: 사용자가 캘린더에서 선택한 날짜에 음식 선택)
    @PostMapping("/saveFoodToDate")
    @ResponseBody
    public String saveFoodToDate(@RequestParam("day") String day, @RequestParam("foodId") int foodId) {
        // 여기에 DB 저장 로직 구현 필요 (예: 캘린더 날짜별 저장 테이블)
        System.out.println("저장 요청: 날짜 = " + day + ", 음식 ID = " + foodId);
        return "success";
    }

    // 캘린더 메인 페이지로 이동 (GET)
    @GetMapping("/calendar")
    public String showCalendarPage() {
        return "Calendar/Calendar_Kcal_MainPage"; // JSP 경로 기준
    }
}
