package org.example.spring_caw_ktk.dto;

public class Food {

    private int id;
    private String foodName;
    private int calories;



    // 전체 필드 초기화하는 생성자
    public Food(int id, String foodName, int calories) {
        this.id = id;
        this.foodName = foodName;
        this.calories = calories;
    }

    public Food() {
    }

    // Getter/Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", foodName='" + foodName + '\'' +
                ", calories=" + calories +
                '}';
    }
}
