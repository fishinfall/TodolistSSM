package com.skmisk.todolist.service;

import java.util.List;

import com.skmisk.todolist.entity.Task;
import com.skmisk.todolist.mapper.TaskMapper;

public class TaskServiceImpl implements TaskService{
	TaskMapper taskMapper;

	public TaskMapper getTaskMapper() {
		return taskMapper;
	}

	public void setTaskMapper(TaskMapper taskMapper) {
		this.taskMapper = taskMapper;
	}
	
	public void markFinishById(int taskId) {
		this.taskMapper.markFinishById(taskId);
	}
	
	public void deleteTask(int taskId) {
		this.taskMapper.deleteTask(taskId);
	}
	
	public void addTask(Task task) {
		this.taskMapper.addTask(task);
	}
	public List<Task> queryTasksByUserId(int id){
		return this.taskMapper.queryTasksByUserId(id);
	}
	public List<Task> queryTasksByUsername(String username){
		return this.taskMapper.queryTasksByUsername(username);
	}
	
	
	
}
