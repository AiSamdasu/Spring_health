package org.example.spring_caw_ktk.controller;

import org.example.spring_caw_ktk.dto.LoginRequest;
import org.example.spring_caw_ktk.dto.Member;
import org.example.spring_caw_ktk.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
@Controller
public class LoginController {
	
	@Autowired
	private MemberLoginService MemberLoginService;
	
	@RequestMapping("/login")
	 public String handleLogin() {   return "login";  }
	 
	 @PostMapping("/login")
	 public String handleLogin(LoginRequest req, HttpSession session) {
	     try {
	         Member member = MemberLoginService.login(req);
	         session.setAttribute("loginMember", member);
	         return "login_process";
	     } catch (Exception e) {
	         e.printStackTrace();
	         return "login_error";  // 에러 페이지로
	     }
	 }

	 // 로그아웃
	    @GetMapping("/logout")
	    public String logout(HttpSession session) {
	        session.invalidate(); // 세션 무효화
	        return "/MainPage";//redirect:/login
	    }

	 /*
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
    }*/
}
