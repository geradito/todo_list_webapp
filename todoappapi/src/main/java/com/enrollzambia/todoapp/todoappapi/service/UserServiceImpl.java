package com.enrollzambia.todoapp.todoappapi.service;

import java.security.SecureRandom;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.enrollzambia.todoapp.todoappapi.dao.UserDAO;
import com.enrollzambia.todoapp.todoappapi.dto.UserDTO;
import com.enrollzambia.todoapp.todoappapi.dto.UserRequestDTO;
import com.enrollzambia.todoapp.todoappapi.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	private static final SecureRandom secureRandom = new SecureRandom(); //threadsafe
	private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); //threadsafe

	public static String generateNewToken() {
	    byte[] randomBytes = new byte[24];
	    secureRandom.nextBytes(randomBytes);
	    return base64Encoder.encodeToString(randomBytes);
	}
	
	@Transactional
	@Override
	public UserDTO login(UserRequestDTO userDTO) {
		User user = userDAO.login(userDTO);
		if(user!=null) {
			user.setToken(generateNewToken());
			userDAO.saveToken(user);	
		}
		
		return new UserDTO(user.getUsername(), user.getToken());
	}

	@Transactional
	@Override
	public UserDTO signup(User user) {
		user.setToken(generateNewToken());
		userDAO.signup(user);
		
		UserDTO userDTO  = new UserDTO(user.getUsername(), user.getToken());
		
		return userDTO;
		
	}

	@Transactional
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean verifyToken(String token) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
