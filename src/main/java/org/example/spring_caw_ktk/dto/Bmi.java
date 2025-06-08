package org.example.spring_caw_ktk.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class Bmi {
	private int id;
	private String userid;
    private Member member;
    private float height;
    private float weight;
    private Date date;
    private float bmi;
    private Timestamp created_at;
    
    public Bmi() {}

    public Bmi(int id, String userid, float height,float weight, Date date , float bmi,Timestamp created_at) {
        this.id = id;
        this.userid = userid;
        this.height = height;
        this.weight = weight;
        this.date = date;
        this.bmi = bmi;
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
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public float getBmi() {
		return bmi;
	}
	public void setBmi(float bmi) {
		this.bmi = bmi;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	
}
