package com.enrollzambia.todoapp.todoappapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.enrollzambia.todoapp.todoappapi.exception.CustomException;
import com.enrollzambia.todoapp.todoappapi.model.User;
import com.enrollzambia.todoapp.todoappapi.repository.UserRepository;
import com.enrollzambia.todoapp.todoappapi.security.JwtTokenProvider;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class UserService2 {

	  @Autowired
	  private UserRepository userRepository;
	  @Autowired
	  private PasswordEncoder passwordEncoder;
	  @Autowired
	  private JwtTokenProvider jwtTokenProvider;
	  @Autowired
	  private AuthenticationManager authenticationManager;

	  public String signin(String username, String password) {
	      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	      return jwtTokenProvider.createToken(username);
	   }

	  public String signup(User appUser) {
	    if (!userRepository.existsByUsername(appUser.getUsername())) {
	      appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
	      userRepository.save(appUser);
	      return jwtTokenProvider.createToken(appUser.getUsername());
	    } else {
	      throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
	    }
	  }

	  public void delete(String username) {
//	    userRepository.deleteByUsername(username);
	  }

	  public User search(String username) {
	    User appUser = userRepository.findByUsername(username);
	    if (appUser == null) {
	      throw new CustomException("The user doesn't exist", HttpStatus.NOT_FOUND);
	    }
	    return appUser;
	  }

	  public User whoami(HttpServletRequest req) {
	    return userRepository.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
	  }

	  public String refresh(String username) {
	    return jwtTokenProvider.createToken(username);
	  }

}
