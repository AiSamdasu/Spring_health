package org.example.spring_caw_ktk.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class ExerciseController {


    @GetMapping("/searchExercisePage")
    public String searchExercisePage(){return "SearchExercise/SearchExercise_Process";}







}
