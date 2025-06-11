package org.example.spring_caw_ktk.controller;

import org.example.spring_caw_ktk.dao.RankRepository;
import org.example.spring_caw_ktk.dao.ExerciseDao;
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
    /*

        @Autowired
        private ExerciseRepository exerciseRepository;

<<<<<<< HEAD
    @Autowired
    private ExerciseDao exerciseDao;
=======
        @PostMapping("/insertExercise")
        public String insertExercise(@ModelAttribute Exercise exercise, HttpSession session) {
            User user = (User) session.getAttribute("loginUser");
            if (user == null) return "redirect:/login";
>>>>>>> branch 'main' of https://github.com/AiSamdasu/Spring_health.git

            // 유저 정보 설정
            exercise.setUserid(user.getUserid());

            // 1. 운동 저장
            exerciseRepository.insert(exercise);

<<<<<<< HEAD
        // 1. 운동 저장
        exerciseDao.insert(exercise);
=======
            // 2. 총 칼로리 계산 후 랭킹 갱신
            int totalCalories = exerciseRepository.getTotalCaloriesByUser(user.getUserid());
            rankRepo.saveOrUpdateRank(user.getUserid(), totalCalories);
>>>>>>> branch 'main' of https://github.com/AiSamdasu/Spring_health.git

<<<<<<< HEAD
        // 2. 총 칼로리 계산 후 랭킹 갱신
        int totalCalories = exerciseDao.getTotalCaloriesByUser(user.getUserid());
        rankRepo.saveOrUpdateRank(user.getUserid(), totalCalories);
=======
            return "redirect:/exerciseList";  // 적절한 페이지로 리다이렉트
        }
>>>>>>> branch 'main' of https://github.com/AiSamdasu/Spring_health.git

    */
    // 랭킹 보기
    @GetMapping("/rank")
    public String showRank(Model model) {
        List<Rank> rankList = rankRepo.findAll();
        model.addAttribute("rankList", rankList);
        return "Rank/RankPage";
    }
}
