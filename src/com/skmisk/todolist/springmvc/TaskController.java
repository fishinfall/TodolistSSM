package com.skmisk.todolist.springmvc;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skmisk.todolist.entity.Task;
import com.skmisk.todolist.service.TaskService;
import com.skmisk.todolist.service.UserService;


@Controller
@WebServlet("/TaskController")
public class TaskController {

	@Autowired
	TaskService taskService;
	@Autowired
	UserService userService;

	@RequestMapping("/addtask")
	public ModelAndView addtask(@RequestParam("taskName") String taskName) {
		ModelAndView mv = new ModelAndView("index.jsp");
		String username = getCurrentUsername();
		Task task = new Task();
		task.setName(taskName);
		task.setUserId(userService.queryUserIdbyUsername(username));
		taskService.addTask(task);
		mv.addObject("tasks", getTasksForCurrentUser());
		return mv;
	}

	@RequestMapping("/deletetask")
	public ModelAndView deletetask(int taskId) throws UnsupportedEncodingException {
		ModelAndView mv = new ModelAndView("index.jsp");
		taskService.deleteTask(taskId);
		mv.addObject("tasks", getTasksForCurrentUser());
		return mv;
	}

	@RequestMapping("/finishtask")
	public ModelAndView finishtask(int taskId) throws UnsupportedEncodingException {
		ModelAndView mv = new ModelAndView("index.jsp");
		taskService.markFinishById(taskId);
		mv.addObject("tasks", getTasksForCurrentUser());
		return mv;
	}
	
	private List<Task> getTasksForCurrentUser(){
		return taskService.queryTasksByUsername(getCurrentUsername());
	}
	
	private String getCurrentUsername() {
		Subject subject = SecurityUtils.getSubject();
		return subject.getPrincipal().toString();
	}

}
