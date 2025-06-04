package org.example.spring_caw_ktk.controller;

import org.example.spring_caw_ktk.dao.ExerciseRepository;
import org.example.spring_caw_ktk.dto.Exercise;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ExerciseController {


    @GetMapping("/searchExercisePage")
    public String searchExercisePage(){return "SearchExercise/SearchExercise_Process";}

    @GetMapping("/searchExercise")
    @ResponseBody
    public List<Exercise> searchExercise(@RequestParam("keyword") String keyword) {
        ExerciseRepository repo = new ExerciseRepository();
        return repo.searchExerciseByName(keyword);
    }

    @PostMapping("/submitExerciseSelection")
    @ResponseBody
    public String submitExerciseSelection(@RequestParam("exerciseName") String exerciseName,
                                          @RequestParam("calories") int calories,
                                          HttpSession session){
        // 이름 목록
        List<String> exerciseNames = (List<String>) session.getAttribute("selectedExerciseNames");
        if (exerciseNames == null) exerciseNames = new ArrayList<>();
        exerciseNames.add(exerciseName);
        session.setAttribute("selectedExerciseNames", exerciseNames);

        // 칼로리 목록
        List<Integer> caloriesList = (List<Integer>) session.getAttribute("selectedExerciseCaloriesList");
        if (caloriesList == null) caloriesList = new ArrayList<>();
        caloriesList.add(calories);
        session.setAttribute("selectedExerciseCaloriesList", caloriesList);

        return "선택 완료";  // GET 요청으로 리다이렉트
    }





}
