package com.skmisk.todolist.springmvc;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.skmisk.todolist.entity.Task;
import com.skmisk.todolist.entity.User;
import com.skmisk.todolist.service.ITaskService;
import com.skmisk.todolist.service.IUserService;

@Controller
@WebServlet("/TodoFrontController")
public class TodoFrontController {

	@Autowired
	WebApplicationContext context;

	@Autowired
	ITaskService taskService;
	@Autowired
	IUserService userService;

	@RequestMapping("/loginpage.do")
	public String loginpagerequest() {
		System.out.println("request processing...");
		return "login.jsp";
	}

	@RequestMapping("/login.do")
	public ModelAndView loginrequest(User user) {
		System.out.println("login processing..." + user.getUsername() + user.getPassword());
		// userService = (IUserService) context.getBean("userService");
		ModelAndView mv;

		if (user.getPassword().equals(userService.queryUserByUsername(user.getUsername()).getPassword())) {

			mv = new ModelAndView("index.jsp");
			List<Task> tasks = userService
					.queryTasksByUserId(userService.queryUserByUsername(user.getUsername()).getId());
			mv.addObject("tasks", tasks);
			System.out.println("user id: " + userService.queryUserByUsername(user.getUsername()).getId());
			mv.addObject("userid", userService.queryUserByUsername(user.getUsername()).getId());
			return mv;
		}

		/*
		 * if (用户名不存在) { mv = new ModelAndView("login.jsp");
		 * mv.addObject("loginresponse",
		 * "Incorrect username & password. Please try again by Spring MVC."); return mv;
		 * } else (用户密码不匹配){
		 * 
		 * }
		 */

		if (user.getUsername().equals("test")) {
			System.out.print("login by mvc");
			mv = new ModelAndView("index.jsp");
			List<Task> tasks = userService.queryTasksByUserId(1);
			mv.addObject("tasks", tasks);
			return mv;
		} else {
			mv = new ModelAndView("login.jsp");
			mv.addObject("loginresponse", "Incorrect username & password. Please try again by Spring MVC.");
			return mv;
		}
	}

	@RequestMapping("/signup.do")
	public ModelAndView signup(User user, @RequestParam("passwordrepeat") String passwordrepeat) {
		System.out.println("signup processing..." + user.getUsername() + user.getPassword());
		System.out.println("password is " + passwordrepeat);
		// System.out.println();
		// userService = (IUserService) context.getBean("userService");
		ModelAndView mv = new ModelAndView("login.jsp");

		if (userService.queryUserByUsername(user.getUsername()) != null) {
			mv.addObject("signupmsg", "username already taken.");
		} else {
			userService.addUser(user);
			mv.addObject("signupmsg", "signup successfully. Please login");
		}
		return mv;
	}

	@RequestMapping("/addtask.do")
	public ModelAndView addtask(@RequestParam("taskName") String taskName, int userid) {
		System.out.println("add task processing...");
		ModelAndView mv = new ModelAndView("index.jsp");
		Task task = new Task();
		task.setName(taskName);
		task.setUserId(userid);
		userService.saveTask(task);
		List<Task> tasks = userService.queryTasksByUserId(userid);
		mv.addObject("tasks", tasks);
		mv.addObject("userid", userid);
		return mv;
	}

	@RequestMapping("/deletetask.do")
	public ModelAndView deletetask(int taskId, int userid) throws UnsupportedEncodingException {
		System.out.println("delete task processing...");

		ModelAndView mv = new ModelAndView("index.jsp");
		userService.deleteTask(taskId);

		List<Task> tasks = userService.queryTasksByUserId(userid);

		mv.addObject("tasks", tasks);
		mv.addObject("userid", userid);
		return mv;
	}

	@RequestMapping("/finishtask.do")
	public ModelAndView finishtask(int taskId, int userid) throws UnsupportedEncodingException {
		System.out.println("finish task processing...");
		ModelAndView mv = new ModelAndView("index.jsp");
		// taskService = (ITaskService) context.getBean("taskService");

		taskService.markFinishById(taskId);

		List<Task> tasks = userService.queryTasksByUserId(userid);

		mv.addObject("tasks", tasks);
		mv.addObject("userid", userid);
		return mv;
	}

}
