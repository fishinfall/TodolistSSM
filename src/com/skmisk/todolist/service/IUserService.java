package com.skmisk.todolist.service;

import java.util.List;

import com.skmisk.todolist.entity.Task;
import com.skmisk.todolist.entity.User;


public interface IUserService {
	
	public User queryUserById(int id);
	
	public User queryUserByUsername(String username);
	
	public void updateOrInsertTasklist(List<Task> tasks);
	
	public void saveTask(Task task);
	
	public List<Task> queryTasksByUserId(int id);
	
	public boolean validateUser(User user);
	
	public void deleteTask(int taskId);
	
	public boolean isUserExisted(String username);
	
	public void addUser(User user);
	
}
