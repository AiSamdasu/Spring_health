package org.example.spring_caw_ktk.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class ExerciseRequest {
	private int id;
	private String userid;
	private Date date;
    private String exercise_name;
    private Integer calories;
    private Timestamp created_at;
    


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

	public String getExercise_name() {
		return exercise_name;
	}

	public void setExercise_name(String exercise_name) {
		this.exercise_name = exercise_name;
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


}
