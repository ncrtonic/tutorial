package org.study.model;

public class User {
	private String userid;
	private String pw;
	private	String name;
	private	String email;
	
	
	
	public String getUserid() {
		return userid;
	}



	public void setUserid(String userid) {
		this.userid = userid;
	}



	public String getPw() {
		return pw;
	}



	public void setPw(String pw) {
		this.pw = pw;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "User [userid=" + userid + ", name=" + name + ", email=" + email + "]";
	}


}
