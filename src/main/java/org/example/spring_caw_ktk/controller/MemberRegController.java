package org.example.spring_caw_ktk.controller;
import java.util.List;

import org.example.spring_caw_ktk.dao.MemberDao;
import org.example.spring_caw_ktk.dto.Member;
import org.example.spring_caw_ktk.dto.RegisterRequest;
import org.example.spring_caw_ktk.service.MemberRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MemberRegController {
	/*
	@Autowired
	 private MemberDao memberDao;
	 
	@GetMapping(value="/list")
	 public String list(Model model) { 
		List<Member> memberList = memberDao.selectAll();
		 model.addAttribute("members", memberList);
		 return "list";
	 }*/
	@Autowired
	 private MemberRegisterService memberRegisterService;
	
	 @RequestMapping("/register")
	 public String handleRegister() {   return "register";  }
	
	 @PostMapping("/register")
	 public String handleRegisterPost(RegisterRequest regReq) {
		 try {
			 memberRegisterService.regist(regReq);
			 return "register_process";
		 } catch (Exception e) {
			 e.printStackTrace();  // 에러 로그 확인
			 String message = e.getMessage();
	         if ("DuplicateUserID".equals(message)) {
	             return "redirect:/register?error=id";
	         } else if ("DuplicateNickname".equals(message)) {
	             return "redirect:/register?error=nickname";
	         } else {
	             return "redirect:/register?error=unknown";
	         }
		 }
	 }
	 
	 
	 
}
