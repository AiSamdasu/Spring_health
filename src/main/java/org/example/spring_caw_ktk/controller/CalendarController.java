package org.example.spring_caw_ktk.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.example.spring_caw_ktk.dto.Bmi;
import org.example.spring_caw_ktk.dto.BmiRequest;
import org.example.spring_caw_ktk.dto.Member;
import org.example.spring_caw_ktk.service.BmiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class CalendarController {
	@Autowired
	 private BmiService BmiService;
	@GetMapping("/calendar_bmi")
    public String defaultShow(HttpSession session,Model model) {
		// 세션에서 로그인된 사용자 가져오기
	    Member loginMember = (Member) session.getAttribute("loginMember");

	    // 로그인 안 되어 있으면 로그인 페이지로 리디렉트
	    if (loginMember == null) {
	        return "redirect:/login";
	    }
	   
	    // userid 설정
	    String userid = loginMember.getUserid();
	    BmiRequest req = new BmiRequest();
	    req.setUserid(userid);

	    try {
	        List<Bmi> bmiList = BmiService.showBmi(req);
	        model.addAttribute("bmiList", bmiList);
	        model.addAttribute("loginMember", loginMember); // JSP에서 이름 출력용
	        return "calendar_bmi";
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "test02_error";
	    }
    }
}
