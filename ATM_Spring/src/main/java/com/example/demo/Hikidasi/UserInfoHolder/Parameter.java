package com.example.demo.Hikidasi.UserInfoHolder;

public class Parameter {
	
	private static String UserId;
	
	public void initParameter() {
		Parameter.UserId = null;
	}
	
	public void setUserId(String UserId_DB) {
		Parameter.UserId = UserId_DB;
	}
	
	public String getUserId() {
		return Parameter.UserId;
	}

}
