package com.avinash.restapi.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Login {
	
	@NotBlank(message="User name can not be empty")
	@Size(min=3, max=12, message="user name must be between 3 and 12")
	private String username;
	private String email;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Login [username=" + username + ", email=" + email + "]";
	}

}
