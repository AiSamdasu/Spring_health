package org.example.spring_caw_ktk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping({ "/Test"})
    public String showTestPage() {
        return "test01";
    }
}
