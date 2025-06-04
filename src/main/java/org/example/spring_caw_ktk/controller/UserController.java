package org.example.spring_caw_ktk.controller;


import org.example.spring_caw_ktk.dao.UserRepository;
import org.example.spring_caw_ktk.dto.User;

import org.example.spring_caw_ktk.dto.UserInfo;
import org.example.spring_caw_ktk.util.KcalEvaluator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    private final UserRepository userRepo = new UserRepository();


    // 키, 몸무게 입력 → BMI 계산 → userinfo 저장
    @PostMapping("/submitUserInfo")
    public String submitUserInfo(@RequestParam("height") double height,
                                 @RequestParam("weight") double weight,
                                 @RequestParam("userId") int userId,
                                 Model model) {

        // 1. 성별 조회
        String gender = userRepo.findGenderByUserId(userId);

        // 2. BMI 계산
        double bmi = weight / Math.pow(height / 100.0, 2);

        // 3. userinfo 저장
        UserInfo info = new UserInfo();
        info.setUserId(userId);
        info.setHeight(height);
        info.setWeight(weight);
        info.setGender(gender);
        info.setBmi(bmi);

        userRepo.saveUserInfo(info);

        model.addAttribute("bmiINFO", bmi);
        return "UserInfoBMI/ResultUserInfo";
    }

    // 칼로리 입력 페이지로 이동
    @GetMapping("/inputKcal")
    public String showKcalForm(HttpSession session, Model model) {
        //User user = (User) session.getAttribute("loginUser");


        //if (user == null) {
        //    return "redirect:/login";
        //}


        // 로그인 없이 테스트용 사용자 직접 세션에 저장
        User testUser = new User();
        testUser.setId(1);
        testUser.setUserid("temp01");
        testUser.setName("테스트계정");
        testUser.setNickname("TA");
        testUser.setGender("남성");
        testUser.setAge(21);
        testUser.setBmi(22.1);
        session.setAttribute("loginUser", testUser);

        //
        model.addAttribute("user", testUser);
        return "UserInfoBMI/InputUserInfo";
    }

    // Kcal 평가
    @PostMapping("/evaluateKcal")
    public String evaluateKcal(@RequestParam("SumKcal") int sumKcal,
                               HttpSession session,
                               Model model) {
        // 세션에서 로그인된 사용자 가져오기
        User user = (User) session.getAttribute("loginUser");

        if (user == null) {
            return "redirect:/login";
        }

        double bmi = user.getBmi();
        String result = KcalEvaluator.evaluate(bmi, sumKcal);

        model.addAttribute("sumKcal", sumKcal);
        model.addAttribute("bmi", bmi);
        model.addAttribute("grade", result);

        return "MainPage"; // 결과 보여줄 JSP
    }
}
