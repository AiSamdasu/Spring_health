package org.example.spring_caw_ktk.dto;

public class UserInfo {
    private int id;
    private int userId;
    private double height;
    private double weight;
    private String gender;
    private double bmi;

    public UserInfo() {}

    public UserInfo(int userId, double height, double weight, String gender, double bmi) {
        this.userId = userId;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.bmi = bmi;
    }

    // Getter & Setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getBmi() {
        return bmi;
    }
    public void setBmi(double bmi) {
        this.bmi = bmi;
    }
}
