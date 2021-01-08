package com.skmisk.todolist.entity;

import java.util.List;

public class User {
	private int id;
	private String name;
	private String username;
	private String password;
	private String encryptedPassword;
	
	
	public User() {
		
	}
	private List<Task> tasklist;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public List<Task> getTasklist() {
		return tasklist;
	}
	public void setTasklist(List<Task> tasklist) {
		this.tasklist = tasklist;
	}
	@Override
	public String toString() {
		return name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
}
