package org.example.spring_caw_ktk.controller;

import org.example.spring_caw_ktk.dao.RankRepository;
import org.example.spring_caw_ktk.dao.ExerciseRepository;
import org.example.spring_caw_ktk.dto.Exercise;
import org.example.spring_caw_ktk.dto.Rank;
import org.example.spring_caw_ktk.dto.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Scanner;

@Controller
public class RankController {

    private final RankRepository rankRepo = new RankRepository();


    @Autowired
    private ExerciseRepository exerciseRepository;

    // 운동 저장 시 점수 자동 반영
    @PostMapping("/insertExercise")
    public String insertExercise(@ModelAttribute Exercise exercise, HttpSession session) {
        User user = (User) session.getAttribute("loginUser");
        if (user == null) return "redirect:/login";

        // 유저 정보 설정
        exercise.setUserid(user.getUserid());

        // 1. 운동 저장
        exerciseRepository.insert(exercise);

        // 2. 총 칼로리 계산 후 랭킹 갱신
        int totalCalories = exerciseRepository.getTotalCaloriesByUser(user.getUserid());
        rankRepo.saveOrUpdateRank(user.getUserid(), totalCalories);

        return "redirect:/exerciseList";  // 적절한 페이지로 리다이렉트
    }


    // 랭킹 보기
    @GetMapping("/rank")
    public String showRank(Model model) {
        List<Rank> rankList = rankRepo.findAll();
        model.addAttribute("rankList", rankList);
        return "Rank/RankPage";
    }
}
