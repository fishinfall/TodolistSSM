package com.skmisk.todolist.service;

import java.util.List;

import com.skmisk.todolist.entity.Task;
import com.skmisk.todolist.entity.User;


public interface UserService {
	
	//public User queryUserById(int id);
	
	public User queryUserByUsername(String username);
	
	//public void updateOrInsertTasklist(List<Task> tasks);
	
	
	
	//public boolean isUserExisted(String username);
	
	public void addUser(User user);
	
	public int queryUserIdbyUsername(String username);
}
