package com.skmisk.todolist.service;

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
	
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	public User queryUserByUsername(String username) {
		return this.userMapper.queryUserByUsername(username);
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
