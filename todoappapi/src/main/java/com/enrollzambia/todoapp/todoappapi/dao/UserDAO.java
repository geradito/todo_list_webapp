package com.enrollzambia.todoapp.todoappapi.dao;

import java.util.List;

import com.enrollzambia.todoapp.todoappapi.dto.UserDTO;
import com.enrollzambia.todoapp.todoappapi.dto.UserRequestDTO;
import com.enrollzambia.todoapp.todoappapi.model.User;


public interface UserDAO {
	
	User login(UserRequestDTO userDTO);
	
	void signup(User user);
	
	void saveToken(User user);
	boolean verifyToken(String token);
	
	void delete(int id);
}
