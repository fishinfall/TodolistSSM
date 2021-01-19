package com.skmisk.todolist.mapper;

import java.util.List;

import com.skmisk.todolist.entity.Task;

public interface TaskMapper {
	public void markFinishById(int taskId);

	public void deleteTask(int taskId);

	public void addTask(Task task);

	public List<Task> queryTasksByUserId(int id);
	
	public List<Task> queryTasksByUsername(String username);
	
	
}
