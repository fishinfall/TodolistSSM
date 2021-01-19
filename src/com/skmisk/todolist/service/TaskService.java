package com.skmisk.todolist.service;

import java.util.List;

import com.skmisk.todolist.entity.Task;

public interface TaskService {
	public void markFinishById(int taskId);

	public void addTask(Task task);

	public List<Task> queryTasksByUserId(int id);
	
	public List<Task> queryTasksByUsername(String username);

	public void deleteTask(int taskId);
	
}
