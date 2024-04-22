package com.enrollzambia.todoapp.todoappapi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.enrollzambia.todoapp.todoappapi.dto.UserRequestDTO;
import com.enrollzambia.todoapp.todoappapi.model.TodoItem;
import com.enrollzambia.todoapp.todoappapi.model.User;

import jakarta.persistence.EntityManager;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public User login(UserRequestDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void signup(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveToken(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean verifyToken(String token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}


}
