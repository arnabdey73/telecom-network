package com.techm.telecom.model;

public class Authenticate {

	private String userName;
	private String password;
	private String mobile;

	public Authenticate() {
	}

	public Authenticate(String userName, String password, String mobile) {
		super();
		this.userName = userName;
		this.password = password;
		this.mobile = mobile;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
