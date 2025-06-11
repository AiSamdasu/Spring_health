package org.example.spring_caw_ktk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @GetMapping("/MainPage")
    public String MainPage(HttpSession session, Model model) {
        // 음식
        List<String> foodNames = (List<String>) session.getAttribute("selectedFoodNames");
        List<Integer> foodCalories = (List<Integer>) session.getAttribute("selectedCaloriesList");

        Map<String, Integer> foodCountMap = new LinkedHashMap<>();
        Map<String, Integer> foodTotalCalMap = new LinkedHashMap<>();

        if (foodNames != null && foodCalories != null) {
            for (int i = 0; i < foodNames.size(); i++) {
                String name = foodNames.get(i);
                int cal = foodCalories.get(i);
                foodCountMap.put(name, foodCountMap.getOrDefault(name, 0) + 1);
                foodTotalCalMap.put(name, foodTotalCalMap.getOrDefault(name, 0) + cal);
            }
        }

        // 운동
        List<String> exerciseNames = (List<String>) session.getAttribute("selectedExerciseNames");
        List<Integer> exerciseCalories = (List<Integer>) session.getAttribute("selectedExerciseCaloriesList");

        Map<String, Integer> exerciseCountMap = new LinkedHashMap<>();
        Map<String, Integer> exerciseTotalCalMap = new LinkedHashMap<>();

        if (exerciseNames != null && exerciseCalories != null) {
            for (int i = 0; i < exerciseNames.size(); i++) {
                String name = exerciseNames.get(i);
                int cal = exerciseCalories.get(i);
                exerciseCountMap.put(name, exerciseCountMap.getOrDefault(name, 0) + 1);
                exerciseTotalCalMap.put(name, exerciseTotalCalMap.getOrDefault(name, 0) + cal);
            }
        }

        model.addAttribute("foodCountMap", foodCountMap);
        model.addAttribute("foodTotalCalMap", foodTotalCalMap);
        model.addAttribute("exerciseCountMap", exerciseCountMap);
        model.addAttribute("exerciseTotalCalMap", exerciseTotalCalMap);

        return "MainPage";
    }
    @GetMapping({"/","/infoPage"})
    public String InfoPage(){

        return "infoPage";
    }
}
