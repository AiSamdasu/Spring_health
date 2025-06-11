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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BmiController {
	@Autowired
	 private BmiService BmiService;
	
	 @RequestMapping("/calendar_bmi")
	 public String handleBmi() {   return "Calendar/calendar_bmi";  }
	
	 @PostMapping("/calendar_bmi")
	 public String handleBmiPost(HttpSession session,BmiRequest regReq,Model model) {
		
		 try {
			 BmiService.saveBmi(regReq);
		        // 로그인 사용자 정보
		        Member loginMember = (Member) session.getAttribute("loginMember");
		        // 해당 사용자의 BMI 목록 조회
		        BmiRequest bmiReq = new BmiRequest();
		        bmiReq.setUserid(loginMember.getUserid());
		        List<Bmi> bmiList = BmiService.showBmi(bmiReq);

		        // 모델에 정보 전달
		        model.addAttribute("bmiList", bmiList);
		        model.addAttribute("loginMember", loginMember);

			 return "Calendar/calendar_bmi";
		 } catch (Exception ex) {
			 ex.printStackTrace();  // 에러 로그 확인
			 return "test02_error";
		 }
	 }
	 
	 @GetMapping("/lis")
	 public String showBmiHistory(HttpSession session, Model model) {
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
		        return "lis";
		    } catch (Exception e) {
		        e.printStackTrace();
		        return "test02_error";
		    }
	 }
}
