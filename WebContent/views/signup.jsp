<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap.min.css">
<link href="signin.css" rel="stylesheet">
</head>

<body class="text-center">
	<main class="form-signin">
		<form action="signup.do" method="post">
			<h1 class="h3 mb-3 fw-normal">Please sign in</h1>
			<label for="inputEmail" class="visually-hidden">Email address</label>
			
			<input type="email" id="inputEmail" class="form-control"
				placeholder="Email address" required autofocus name="username">
				
				<!-- 
			<label for="inputPassword" class="visually-hidden">Password</label> 
			
			 -->
			
			<label
				for="inputPassword" class="visually-hidden">Password</label> <input
				type="password" id="inputPassword" class="form-control"
				placeholder="Password" required name="password">
				
				<label
				for="inputPassword" class="visually-hidden">Password</label> <input
				type="password" id="inputPassword" class="form-control"
				placeholder="Password" required name="passwordrepeat">
				
				<label
				for="inputPassword" class="visually-hidden">Password</label> <input
				type="password" id="inputPassword" class="form-control"
				placeholder="Password" required name="passwordrepeat">
				
			<div class="checkbox mb-3"></div>
			<button class="w-100 btn btn-lg btn-primary" type="submit">Sign
				up</button>
		</form>
	</main>
	
	
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<h3>
				欢迎来到待办事项管理工具，请登录
			</h3>
			<form>
				<fieldset>
					<legend>登录</legend> <label>用户名</label><br/><input type="text" /> 
					<br/>
					<label>密码</label><br/><input type="text" /><br /> <button class="btn" type="submit">提交</button>
				</fieldset>
			</form>
			<div>
				<a href="#">注册新用户</a>
			</div>
		</div>
	</div>
</div>
</body>
</html>