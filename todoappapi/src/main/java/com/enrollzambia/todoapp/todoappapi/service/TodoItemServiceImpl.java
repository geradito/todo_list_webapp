package com.enrollzambia.todoapp.todoappapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.enrollzambia.todoapp.todoappapi.dao.TodoItemDAO;
import com.enrollzambia.todoapp.todoappapi.model.TodoItem;

@Service
public class TodoItemServiceImpl implements TodoItemService {
	
	@Autowired
	private TodoItemDAO todoItemDAO;
	
	@Transactional
	@Override
	public List<TodoItem> getByUserId(int userId) {
		return todoItemDAO.getByUserId(userId);
	}

	@Transactional
	@Override
	public TodoItem get(int id) {
		return todoItemDAO.get(id);
	}

	@Override
	public void save(TodoItem todoItem) {
		todoItemDAO.save(todoItem);
		
	}

	@Transactional
	@Override
	public void delete(int id) {
		todoItemDAO.delete(id);
		
	}

}
