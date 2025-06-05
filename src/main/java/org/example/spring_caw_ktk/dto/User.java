package org.example.spring_caw_ktk.dto;

import java.sql.Timestamp;

public class User {

    private int id;
    private String userid;     // 로그인용 아이디
    private String password;
    private String nickname;   // 닉네임
    private String name;       // 실명
    private int age;
    private String gender;
    private Timestamp createdAt; // 가입일
    private double bmi;

    public User() {}

    public User(int id, String userid, String password, String nickname, String name,
                int age, String gender, Timestamp createdAt) {
        this.id = id;
        this.userid = userid;
        this.password = password;
        this.nickname = nickname;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.createdAt = createdAt;
    }

    // Getter & Setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public double getBmi() {
        return bmi;
    }
    public void setBmi(double bmi) {
        this.bmi = bmi;
    }
}
