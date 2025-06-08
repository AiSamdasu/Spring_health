package org.example.spring_caw_ktk.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class Kcal {
	private int id;
	private String userid;
	private Date date;
    private String food_name;
    private int calories;
    private Timestamp created_at;
    
    public Kcal() {}

    public Kcal(int id, String userid, Date date , String food_name,int calories,Timestamp created_at) {
        this.id = id;
        this.userid = userid;
        this.date = date;
        this.food_name = food_name;
        this.calories=calories;
        this.created_at = created_at;
    }

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getFood_name() {
		return food_name;
	}

	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
    
    
}
