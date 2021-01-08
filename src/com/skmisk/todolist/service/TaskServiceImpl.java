package com.skmisk.todolist.service;

import com.skmisk.todolist.mapper.TaskMapper;

public class TaskServiceImpl implements ITaskService{
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
	
}
