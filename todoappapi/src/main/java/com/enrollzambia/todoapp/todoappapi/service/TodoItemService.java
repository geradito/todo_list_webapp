package com.enrollzambia.todoapp.todoappapi.service;

import java.util.List;

import com.enrollzambia.todoapp.todoappapi.model.TodoItem;

public interface TodoItemService {

	List<TodoItem>getByUserId(int userId);
	
	TodoItem get(int id);
	
	void save(TodoItem todoItem);
	
	void delete(int id);
}
