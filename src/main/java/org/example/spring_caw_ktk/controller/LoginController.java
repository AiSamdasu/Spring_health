package org.example.spring_caw_ktk.controller;

import org.example.spring_caw_ktk.dto.User;
import org.example.spring_caw_ktk.dto.UserInfo;
import org.example.spring_caw_ktk.dao.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
@Controller
public class LoginController {
    private final UserRepository userRepo = new UserRepository();

    // 로그인 화면 진입
    @GetMapping("/login")
    public String showLoginForm() {
        return "LoginForm"; // → LoginForm.jsp에서 구현
    }

    // 로그인 처리
    @PostMapping("/login")
    public String login(@RequestParam String userid,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {

        // ⚠ 로그인 로직 생략하고 테스트용 사용자 생성
        User user = new User();
        user.setId(1);
        user.setUserid("testuser");
        user.setNickname("테스터");
        user.setName("홍길동");
        user.setGender("남성");
        user.setAge(20);

        session.setAttribute("loginUser", user); // 바로 로그인된 것처럼 저장

        return "redirect:/inputKcal";
    }

    // 로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 무효화
        return "redirect:/login";
    }
}
