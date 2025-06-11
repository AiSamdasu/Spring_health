package org.example.spring_caw_ktk.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.example.spring_caw_ktk.dao.BmiDao;
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
	
	@GetMapping("/calendar_bmi")
	public String handleGetBmi(HttpSession session, Model model) {
	    try {
	        // 로그인한 사용자 가져오기
	        Member loginMember = (Member) session.getAttribute("loginMember");
	        if (loginMember == null) {
	            return "redirect:/login";
	        }

	        // 오늘의 BMI 정보 조회
	        BmiRequest req = new BmiRequest();
	        req.setUserid(loginMember.getUserid());
	        Bmi todayBmi = BmiService.showTodayBmi(req);

	        // BMI 리스트도 함께 조회하고 싶다면 아래 라인도 추가
	        List<Bmi> bmiList = BmiService.showBmi(req);

	        model.addAttribute("todayBmi", todayBmi);
	        model.addAttribute("bmiList", bmiList);
	        model.addAttribute("loginMember", loginMember);
	        return "calendar_bmi";
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "test02_error";
	    }
	}
	
	@PostMapping("/calendar_bmi")
	public String handleBmiPost(HttpSession session, BmiRequest regReq, Model model) {
	    try {
	        BmiService.saveBmi(regReq);

	        // 로그인 사용자 정보
	        Member loginMember = (Member) session.getAttribute("loginMember");
	        BmiRequest bmiReq = new BmiRequest();
	        bmiReq.setUserid(loginMember.getUserid());

	        // 오늘 BMI 조회 추가
	        Bmi todayBmi = BmiService.showTodayBmi(bmiReq);
	        List<Bmi> bmiList = BmiService.showBmi(bmiReq);

	        model.addAttribute("todayBmi", todayBmi);
	        model.addAttribute("bmiList", bmiList);
	        model.addAttribute("loginMember", loginMember);

	        return "calendar_bmi";
	    } catch (Exception ex) {
	        ex.printStackTrace();
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
	 
	 
	 // 하나
	 @GetMapping("/todayBmi")
	 public String showTodayBmi(HttpSession session, Model model) {
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
		        Bmi bmi = BmiService.showTodayBmi(req);
		        model.addAttribute("todayBmi", bmi);
		        model.addAttribute("loginMember", loginMember); // JSP에서 이름 출력용
		        return "todayBmiView";
		    } catch (Exception e) {
		        e.printStackTrace();
		        return "test02_error";
		    }
	 }
	 /*
	 @Autowired
	 private BmiDao bmiDao;

	 @GetMapping("/todayBmi")
	 public String showTodayBmi(Model model, HttpSession session) {
		// 세션에서 로그인된 사용자 가져오기
		    Member loginMember = (Member) session.getAttribute("loginMember");
		    String userid = loginMember.getUserid();
		   

	     try {
	         Bmi todayBmi = bmiDao.getTodayBmi(userid);
	         model.addAttribute("todayBmi", todayBmi);
	     } catch (Exception e) {
	         model.addAttribute("error", "오늘의 BMI 정보가 없습니다.");
	     }

	     return "todayBmiView"; // JSP 뷰 이름
	 }*/

}
