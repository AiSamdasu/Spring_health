package org.example.spring_caw_ktk.dto;

public class Exercise {

    private int id;
    private String exerciseName;
    private int calories;


    // 전체 필드 초기화하는 생성자
    public Exercise(int id, String exerciseName, int calories){
        this.id = id;
        this.exerciseName = exerciseName;
        this.calories = calories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }



}
