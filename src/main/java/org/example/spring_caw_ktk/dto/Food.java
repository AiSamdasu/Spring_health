package org.example.spring_caw_ktk.dto;

public class Food {

    private int id;
    private String foodName;
    private int calories;

    private int carbohydrate;
    private int protein;
    private int fat;


    public Food(int id, String foodName, int calories) {
        this.id = id;
        this.foodName = foodName;
        this.calories = calories;
    }

    public Food(int id, String foodName, int calories, int carbohydrate, int protein, int fat) {
        this.id = id;
        this.foodName = foodName;
        this.calories = calories;
        this.carbohydrate = carbohydrate;
        this.protein = protein;
        this.fat = fat;
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

    public int getCarbohydrate() { return carbohydrate; }
    public void setCarbohydrate(int carbohydrate) { this.carbohydrate = carbohydrate; }

    public int getProtein() { return protein; }
    public void setProtein(int protein) { this.protein = protein; }

    public int getFat() { return fat; }
    public void setFat(int fat) { this.fat = fat; }


}
