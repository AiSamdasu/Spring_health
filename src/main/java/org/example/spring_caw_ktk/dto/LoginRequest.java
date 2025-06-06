package org.example.spring_caw_ktk.dto;


public class LoginRequest {
	
    private String userid;     // 로그인용 아이디
    private String password;
    
    
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
    
}
