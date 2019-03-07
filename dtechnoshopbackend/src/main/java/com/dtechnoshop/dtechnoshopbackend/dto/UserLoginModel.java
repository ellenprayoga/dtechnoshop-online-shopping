package com.dtechnoshop.dtechnoshopbackend.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class UserLoginModel {
	@NotEmpty(message = "Silahkan masukkan email Anda !")
	private String email;
	
	@NotEmpty(message = "Silahkan masukkan password Anda !")
	private String password;
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
