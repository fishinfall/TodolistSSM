<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Signup</title>
<link rel="stylesheet" href="bootstrap.min.css">
 <link href="signin.css" rel="stylesheet">
</head>
<body class="text-center">
	<main class="form-signin">
		<form action="login">
			<h1 class="h3 mb-3 fw-normal">Welcome to Todo list! Please sign in.</h1>
			<label for="inputEmail" class="visually-hidden">Email address</label>
			<input type="email" id="inputEmail" class="form-control"
				placeholder="Email address" required autofocus name="username"> <label
				for="inputPassword" class="visually-hidden">Password</label> <input
				type="password" id="inputPassword" class="form-control"
				placeholder="Password" required name="password">
			<div class="checkbox mb-3">
			</div>
			<button class="w-100 btn btn-lg btn-primary" type="submit">Sign
				in</button>
		</form>
		<p align="left"><font face="verdana" color="black" size="2"><c:out value="${loginresponse} "/></font></p>
		
		<p align="left"><a href="tosignup">Sign up</a></p>
		
	</main>

</body>
</html>