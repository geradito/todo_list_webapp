package com.enrollzambia.todoapp.todoappapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
//import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class})
@SpringBootApplication
public class TodoappapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoappapiApplication.class, args);
	}

}
