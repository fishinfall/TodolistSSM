package com.skmisk.todolist.springmvc;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skmisk.todolist.entity.Task;
import com.skmisk.todolist.entity.User;
import com.skmisk.todolist.service.TaskService;
import com.skmisk.todolist.service.UserService;
import com.skmisk.todolist.shiro.EncryptUtils;

@Controller
@WebServlet("/UserController")
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	TaskService taskService;

	@RequestMapping("/tosignup")
	public String tosignup() {
		System.out.println("signuppage processing...");
		return "signup.jsp";
	}
	
	@RequestMapping("/tologinpage.do")
	public String tologinpage() {
		System.out.println("signuppage processing...");
		return "login.jsp";
	}

	@RequestMapping("/login")
	public ModelAndView login(User user) {
		ModelAndView mv;
		String inputUsername = user.getUsername();
		String inputPassword = user.getPassword();

		Subject subject = SecurityUtils.getSubject();

		UsernamePasswordToken token = new UsernamePasswordToken(inputUsername,
				EncryptUtils.getSHA256StrJava(inputPassword));
		//System.out.println(token.toString());
		try {
			subject.login(token);
			mv = new ModelAndView("index.jsp");
			List<Task> tasks =  taskService.queryTasksByUsername(inputUsername);
			mv.addObject("tasks", tasks);

			return mv;
		} catch (UnknownAccountException e) {
			mv = new ModelAndView("login.jsp");
			mv.addObject("loginresponse", "The usename doesn't exist. Please try a different one.");
			return mv;
		} catch (IncorrectCredentialsException e) {
			mv = new ModelAndView("login.jsp");
			mv.addObject("loginresponse", "Incorrect username & password. Please try again.");
			return mv;
		}
	}

	@RequestMapping("/signup")
	public ModelAndView signup(User user, @RequestParam("passwordrepeat") String passwordrepeat) {
		System.out.println("signup processing..." + user.getUsername() + user.getPassword());
		System.out.println("password is " + passwordrepeat);

		ModelAndView mv = new ModelAndView("login.jsp");

		if (userService.queryUserByUsername(user.getUsername()) != null) {
			mv.addObject("signupmsg", "username already taken.");
		} else {
			userService.addUser(user);
			mv.addObject("signupmsg", "signup successfully. Please login");
		}
		return mv;
	}
}
