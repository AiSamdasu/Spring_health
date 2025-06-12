package org.example.spring_caw_ktk.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class Kcal {
	private int id;
	private String userid;
	private Date date;
    private String food_name;
    private Integer calories;
    private Timestamp created_at;
    private String classify;
    
    public Kcal() {}

    public Kcal(int id, String userid, Date date , String food_name,int calories,Timestamp created_at,String classify) {
        this.id = id;
        this.userid = userid;
        this.date = date;
        this.food_name = food_name;
        this.calories=calories;
        this.created_at = created_at;
        this.classify=classify;
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

	public Integer getCalories() {
		return calories;
	}

	public void setCalories(Integer calories) {
		this.calories = calories;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}
    
    
}
