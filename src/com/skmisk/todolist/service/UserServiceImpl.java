package com.skmisk.todolist.service;

import java.util.List;

import org.apache.shiro.SecurityUtils;

import com.skmisk.todolist.entity.Task;
import com.skmisk.todolist.entity.User;
import com.skmisk.todolist.mapper.UserMapper;
import com.skmisk.todolist.shiro.EncryptUtils;

public class UserServiceImpl implements UserService{
	UserMapper userMapper;

	public User queryUserById(int id) {
		return this.userMapper.queryUserById(id);
	}


	public UserMapper getUserMapper() {
		return userMapper;
	}
	
//	public void updateOrInsertTasklist(List<Task> tasks) {
//		this.userMapper.updateOrInsertTasklist(tasks);
//	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	

	
	public boolean validateUser(User user) {
		
		return true;
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
		String rawPassword = user.getPassword();
		String encryptedPassword = EncryptUtils.getSHA256StrJava(rawPassword);
		user.setPassword(encryptedPassword);
		this.userMapper.addUser(user);
	}
	
	public int queryUserIdbyUsername(String username) {
		return this.userMapper.queryUserIdbyUsername(username);
	}
	

}
