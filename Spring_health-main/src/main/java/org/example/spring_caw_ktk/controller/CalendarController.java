package org.example.spring_caw_ktk.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

// json형태로 객체 반환해줌
@RestController
public class CalendarController {

    @GetMapping("/events")
    public List<Map<String, Object>> getEvents() {
        List<Map<String, Object>> events = new ArrayList<>();

        Map<String, Object> event1 = new HashMap<>();
        event1.put("title", "아침 : 100kcal");
        event1.put("start", "2025-05-28");;
        

        Map<String, Object> event2 = new HashMap<>();
        event2.put("title", "점심 : 100kcal");
        event2.put("start", "2025-05-28");
        
        Map<String, Object> event3 = new HashMap<>();
        event3.put("title", "저녁 : 150kcal");
        event3.put("start", "2025-05-29");;
       

        events.add(event1);
        events.add(event2);
        events.add(event3);
        return events;
    }

    @GetMapping("/calendar2")
    public ModelAndView calendarPage() {
        return new ModelAndView("Calendar/Calendar");
    }
}
