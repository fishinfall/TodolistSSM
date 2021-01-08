package com.skmisk.todolist.service;

import java.util.List;

import com.skmisk.todolist.entity.Task;
import com.skmisk.todolist.entity.User;
import com.skmisk.todolist.mapper.UserMapper;

public class UserServiceImpl implements IUserService{
	UserMapper userMapper;

	public User queryUserById(int id) {
		return this.userMapper.queryUserById(id);
	}


	public UserMapper getUserMapper() {
		return userMapper;
	}
	
	public void updateOrInsertTasklist(List<Task> tasks) {
		this.userMapper.updateOrInsertTasklist(tasks);
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	public void saveTask(Task task) {
		this.userMapper.saveTask(task);
	}
	public List<Task> queryTasksByUserId(int id){
		return this.userMapper.queryTasksByUserId(id);
	}
	
	public boolean validateUser(User user) {
		
		return true;
	}
	
	public void deleteTask(int taskId) {
		this.userMapper.deleteTask(taskId);
	}
	
	public User queryUserByUsername(String username) {
		return this.userMapper.queryUserByUsername(username);
	}

	public boolean isUserExisted(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	public void addUser(User user) {
		// TODO Auto-generated method stub
		this.userMapper.addUser(user);
	}

}
