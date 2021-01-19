package com.skmisk.todolist.service;

import com.skmisk.todolist.entity.User;

public interface UserService {
	
	public User queryUserByUsername(String username);
	
	public void addUser(User user);
	
	public int queryUserIdbyUsername(String username);
}
