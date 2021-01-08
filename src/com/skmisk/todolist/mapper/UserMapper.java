package com.skmisk.todolist.mapper;

import java.util.List;

import com.skmisk.todolist.entity.User;
import com.skmisk.todolist.entity.Task;


public interface UserMapper {
	public User queryUserById(int id);
	
	public void addUser(User user);
	
	public void deleteUser(int id);
	
	public void updateUser(User user);
	
	public List<User> queryAllUsers();
		
	public User queryOneUserWithSpringMyBattisMapper(int id);
	
	
	// Actual using 

	
	public void updateOrInsertTasklist(List<Task> tasks);
	
	public void saveTask(Task task);
	
	public List<Task> queryTasksByUserId(int id);
	
	public void deleteTask(int taskId);
	
	public User queryUserByUsername(String username);

}