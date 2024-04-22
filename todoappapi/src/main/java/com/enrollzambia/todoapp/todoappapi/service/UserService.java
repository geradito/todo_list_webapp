package com.enrollzambia.todoapp.todoappapi.service;

import com.enrollzambia.todoapp.todoappapi.dto.UserDTO;
import com.enrollzambia.todoapp.todoappapi.dto.UserRequestDTO;
import com.enrollzambia.todoapp.todoappapi.model.User;

public interface UserService {

	UserDTO login(UserRequestDTO userDTO);
	
	UserDTO signup(User user);

	boolean verifyToken(String token);
	
	void delete(int id);
}
