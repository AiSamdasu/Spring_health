package org.example.spring_caw_ktk.controller;

import org.example.spring_caw_ktk.dao.ExerciseRepository;
import org.example.spring_caw_ktk.dto.Exercise;
import org.example.spring_caw_ktk.dto.ExerciseRequest;
import org.example.spring_caw_ktk.dto.Kcal;
import org.example.spring_caw_ktk.dto.KcalRequest;
import org.example.spring_caw_ktk.dto.Member;
import org.example.spring_caw_ktk.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ExerciseController {

	@Autowired
	 private ExerciseService ExerciseService;
	
	@RequestMapping("/calendar_exercise")
	public String handleExercise(HttpSession session, Model model) {
	    Member loginMember = (Member) session.getAttribute("loginMember");

	    if (loginMember == null) {
	        return "redirect:/login";
	    }

	    try {
	        String userid = loginMember.getUserid();
	        ExerciseRequest req = new ExerciseRequest();
	        req.setUserid(userid);

	        List<Exercise> exerciseList = ExerciseService.showExercise(req);  // 변수도 소문자
	        model.addAttribute("exerciseList", exerciseList);  // 여기 수정
	        model.addAttribute("loginMember", loginMember);

	        return "calendar_exercise";
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "test02_error";
	    }
	}


	
	 @PostMapping("/calendar_exercise")
	 public String handleExercisePost(HttpSession session,ExerciseRequest req,Model model) {
		
		 try {
			 ExerciseService.saveExercise(req);
		        // 로그인 사용자 정보
		        Member loginMember = (Member) session.getAttribute("loginMember");
		        // 해당 사용자의 BMI 목록 조회
		        ExerciseRequest exerciseReq = new ExerciseRequest();
		        exerciseReq.setUserid(loginMember.getUserid());
		        List<Exercise> ExerciseList = ExerciseService.showExercise(exerciseReq);

		        // 모델에 정보 전달
		        model.addAttribute("exerciseList", ExerciseList);
		        model.addAttribute("loginMember", loginMember);

			 return "calendar_exercise";
		 } catch (Exception ex) {
			 ex.printStackTrace();  // 에러 로그 확인
			 return "test02_error";
		 }
	 }
	 
	 @GetMapping("/lis3")
	 public String showExerciseHistory(HttpSession session, Model model) {
		 // 세션에서 로그인된 사용자 가져오기
		    Member loginMember = (Member) session.getAttribute("loginMember");

		    // 로그인 안 되어 있으면 로그인 페이지로 리디렉트
		    if (loginMember == null) {
		        return "redirect:/login";
		    }

		    // userid 설정
		    String userid = loginMember.getUserid();
		    ExerciseRequest req = new ExerciseRequest();
		    req.setUserid(userid);

		    try {
		        List<Exercise> exerciseList = ExerciseService.showExercise(req);
		        model.addAttribute("exerciseList", exerciseList);
		        model.addAttribute("loginMember", loginMember); // JSP에서 이름 출력용
		        return "lis3";
		    } catch (Exception e) {
		        e.printStackTrace();
		        return "test02_error";
		    }
	 }
	 
	// 탐색
    @GetMapping("/searchExercisePage")
    public String searchExercisePage(){return "SearchExercise/SearchExercise_Process";}

    @GetMapping("/searchExercise")
    @ResponseBody
    public List<Exercise> searchExercise(@RequestParam("keyword") String keyword) {
        ExerciseRepository repo = new ExerciseRepository();
        return repo.searchExerciseByName(keyword);
    }

    @PostMapping("/submitExerciseSelection")
    @ResponseBody
    public String submitExerciseSelection(@ModelAttribute ExerciseRequest exerciseRequest,
            HttpSession session) {
		
		String exerciseName = exerciseRequest.getExercise_name();
		Integer calories = exerciseRequest.getCalories();
		
		// null 체크
		if (exerciseName == null || exerciseName.trim().isEmpty() || calories == null) {
		return "운동 이름이나 칼로리가 유효하지 않습니다.";
		}
		
		// 세션에 저장
		List<String> exerciseNames = (List<String>) session.getAttribute("selectedExerciseNames");
		if (exerciseNames == null) exerciseNames = new ArrayList<>();
		exerciseNames.add(exerciseName);
		session.setAttribute("selectedFoodNames", exerciseNames);
		
		List<Integer> caloriesList = (List<Integer>) session.getAttribute("selectedCaloriesList");
		if (caloriesList == null) caloriesList = new ArrayList<>();
		caloriesList.add(calories);
		session.setAttribute("selectedCaloriesList", caloriesList);
		
		return "선택 완료";
	}





}
