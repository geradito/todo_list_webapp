package com.enrollzambia.todoapp.todoappapi.dto;

public class UserRequestDTO extends UserDTO{

    private String password;
    
    
	public UserRequestDTO(String username,String password) {
		super(username, null);
		this.password = password;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
    
}
