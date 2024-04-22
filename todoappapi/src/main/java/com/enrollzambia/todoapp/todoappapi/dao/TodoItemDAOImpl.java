package com.enrollzambia.todoapp.todoappapi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.enrollzambia.todoapp.todoappapi.model.TodoItem;

import jakarta.persistence.EntityManager;

@Repository
public class TodoItemDAOImpl implements TodoItemDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<TodoItem> getByUserId(int userId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<TodoItem>query = currentSession.createQuery("from TodoItem",TodoItem.class);
		List<TodoItem>list = query.getResultList();
		return list;
	}

	@Override
	public TodoItem get(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		TodoItem todoItem = currentSession.get(TodoItem.class, id);
		return todoItem;
	}

	@Override
	public void save(TodoItem todoItem) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(todoItem);
	}

	@Override
	public void delete(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		TodoItem todoItem = currentSession.get(TodoItem.class, id);
		currentSession.delete(todoItem);
		
	}


}
