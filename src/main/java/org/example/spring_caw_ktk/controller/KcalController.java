package org.example.spring_caw_ktk.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.example.spring_caw_ktk.dto.Bmi;
import org.example.spring_caw_ktk.dto.BmiRequest;
import org.example.spring_caw_ktk.dto.Exercise;
import org.example.spring_caw_ktk.dto.Kcal;
import org.example.spring_caw_ktk.dto.KcalRequest;
import org.example.spring_caw_ktk.dto.Member;
import org.example.spring_caw_ktk.service.KcalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class KcalController {
	@Autowired
	 private KcalService KcalService;
	
	@RequestMapping("/calendar_kcal")
	public String handleKcal(HttpSession session, Model model) {
	    Member loginMember = (Member) session.getAttribute("loginMember");

	    if (loginMember == null) {
	        return "redirect:/login";
	    }

	    try {
	        String userid = loginMember.getUserid();
	        KcalRequest req = new KcalRequest();
	        req.setUserid(userid);
	        // 오늘의 칼로리 리스트 가져오기
	        List<Kcal> todayKcalList = KcalService.showTodayKcal(req);
	        
	     // 소모 칼로리 총합 계산
	        int totalCalories = 0;
	        if (todayKcalList != null) {
	            for (Kcal kcal : todayKcalList) {
	                totalCalories += (kcal.getCalories() != null ? kcal.getCalories() : 0);
	            }
	        }
	        
	        model.addAttribute("todayKcalList",todayKcalList);
	        model.addAttribute("totalCalories", totalCalories);
	        
	        List<Kcal> kcalList = KcalService.showKcal(req);
	        model.addAttribute("kcalList", kcalList);
	        model.addAttribute("loginMember", loginMember);

	        return "calendar_kcal";
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "test02_error";
	    }
	}

	
	 @PostMapping("/calendar_kcal")
	 public String handleKcalPost(HttpSession session,KcalRequest regReq,Model model) {
		
		 try {
			 KcalService.saveKcal(regReq);
		        // 로그인 사용자 정보
		        Member loginMember = (Member) session.getAttribute("loginMember");
		        // 해당 사용자의 BMI 목록 조회
		        KcalRequest kcalReq = new KcalRequest();
		        kcalReq.setUserid(loginMember.getUserid());
		        List<Kcal> kcalList = KcalService.showKcal(kcalReq);

		        // 모델에 정보 전달
		        model.addAttribute("kcalList", kcalList);
		        model.addAttribute("loginMember", loginMember);

			 return "calendar_kcal";
		 } catch (Exception ex) {
			 ex.printStackTrace();  // 에러 로그 확인
			 return "test02_error";
		 }
	 }
	 
	 @GetMapping("/lis2")
	 public String showBmiHistory(HttpSession session, Model model) {
		 // 세션에서 로그인된 사용자 가져오기
		    Member loginMember = (Member) session.getAttribute("loginMember");

		    // 로그인 안 되어 있으면 로그인 페이지로 리디렉트
		    if (loginMember == null) {
		        return "redirect:/login";
		    }

		    // userid 설정
		    String userid = loginMember.getUserid();
		    KcalRequest req = new KcalRequest();
		    req.setUserid(userid);

		    try {
		        List<Kcal> kcalList = KcalService.showKcal(req);
		        model.addAttribute("kcalList", kcalList);
		        model.addAttribute("loginMember", loginMember); // JSP에서 이름 출력용
		        return "lis2";
		    } catch (Exception e) {
		        e.printStackTrace();
		        return "test02_error";
		    }
	 }
}
