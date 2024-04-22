package com.enrollzambia.todoapp.todoappapi.controller;

import java.sql.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enrollzambia.todoapp.todoappapi.model.TodoItem;
import com.enrollzambia.todoapp.todoappapi.service.TodoItemService;

@RestController
@RequestMapping("/api")
public class TodoItemController {
	
	@Autowired
	private TodoItemService todoItemService;
	
	@GetMapping("/todo")
	public List<TodoItem>get(){
		return todoItemService.getByUserId(1);
	}
	
	@PostMapping("/todo")
	public TodoItem save(@RequestBody TodoItem todoItem){
		todoItem.setCreate_at(new java.sql.Date(System.currentTimeMillis()));
		todoItemService.save(todoItem);
		return todoItem;
	}
	
	@GetMapping("/todo/{id}")
	public TodoItem get(@PathVariable int id){
		return todoItemService.get(id);
	}
	
	@DeleteMapping("/todo/{id}")
	public String delete(@PathVariable int id){
		todoItemService.delete(id);
		return "Employee has been deleted with ID:"+id;
	}
	
	@PutMapping("/todo")
	public TodoItem update(@RequestBody TodoItem todoItem){
		todoItemService.save(todoItem);
		return todoItem;
	}
}
