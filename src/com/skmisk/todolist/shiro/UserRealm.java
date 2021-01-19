package com.skmisk.todolist.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.skmisk.todolist.entity.User;
import com.skmisk.todolist.service.UserService;

@Configuration
public class UserRealm extends AuthorizingRealm{
	
	@Autowired
	UserService userService;

	
	
	public UserService getUserService() {
		return userService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/* 执行认证逻辑 */

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		System.out.println("processing authentication");
		
		UsernamePasswordToken uptoken = (UsernamePasswordToken) token;
		System.out.println("Service is "+userService);
		User dbUser = userService.queryUserByUsername(uptoken.getUsername());
		
	
		if (dbUser==null) {
			return null;
		}
		else {
			return new SimpleAuthenticationInfo(token.getPrincipal(),dbUser.getPassword(),"");
		}
	}

}
