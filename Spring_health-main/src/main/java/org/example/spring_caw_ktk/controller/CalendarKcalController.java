package org.example.spring_caw_ktk.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalendarKcalController {

    @GetMapping("/calendar")
    public String calendarPage(Model model) {
        model.addAttribute("daysInMonth", 31);
        return "Calendar/Calendar_Kcal_MainPage"; 
    }

    @PostMapping("/saveEntry")
    @ResponseBody
    public ResponseEntity<String> saveEntry(@RequestParam("day") String day,
                                            @RequestParam("text") String text) {
        System.out.println("저장된 날짜: " + day + ", 입력 내용: " + text);
        return ResponseEntity.ok("저장 성공");
    }
    
    
}
