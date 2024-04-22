package com.enrollzambia.todoapp.todoappapi.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "todoitems")
public class TodoItem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer id;

	@Column(name="userId")
	private Integer userId;

	@Column
	private String text;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreate_at() {
		return created_at;
	}

	public void setCreate_at(Date create_at) {
		this.created_at = create_at;
	}

	@Column
	private String status;

	@Column
	private Date created_at;

	@Override
	public String toString() {
		return "TodoItem [id=" + id + ", userId=" + userId + ", text=" + text + ", status=" + status + ", create_at="
				+ created_at + "]";
	}
	
	
}
